package com.cross.Danmat.Manager.Service;

import java.util.List;

import com.cross.Danmat.Manager.Dao.ManagerDao;
import com.cross.Danmat.Manager.domain.Manager;
import com.cross.Danmat.User.Command.UserCommand;

public class ManagerServiceImpl implements ManagerService{
	ManagerDao managerDao;

	public ManagerServiceImpl(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}


	@Override
	public int mglogin(String mgid, String mgpasswd) {
		int count = 0;
		List<Manager> manager_list = managerDao.isManager();
		
		for(int i = 0; i<manager_list.size(); i++) {
			if(manager_list.get(i).getMgid().equals(mgid)) {
				count++;
				if(manager_list.get(i).getMgpasswd().equals(mgpasswd)) {
					count++;
				}else {
					return count;
				}
			}else {
				return count;
			}
		}
		return count;
	}

	@Override
	public UserCommand searchId(String userid) {
		return managerDao.SearchIdForm(userid);
	}

	@Override
	public UserCommand searchEmail(String email) {
		return managerDao.SearchEmailForm(email);
	}


	@Override
	public List<UserCommand> AllUserList() {
		return managerDao.getAllUserForm();
	}

}
