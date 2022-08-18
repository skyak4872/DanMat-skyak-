package com.cross.Danmat.Manager.Service;

import java.util.List;

import com.cross.Danmat.User.Command.UserCommand;

public interface ManagerService {

	int mglogin(String mgid, String mgpasswd);   
	
	UserCommand searchId(String email);

	UserCommand searchEmail(String userid);
	
	List<UserCommand> AllUserList();
}
