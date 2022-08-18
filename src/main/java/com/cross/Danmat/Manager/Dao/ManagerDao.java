package com.cross.Danmat.Manager.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cross.Danmat.Manager.data.ManagerRowMapper;
import com.cross.Danmat.Manager.data.UserRowMapper;
import com.cross.Danmat.Manager.domain.Manager;
import com.cross.Danmat.User.Command.UserCommand;

public class ManagerDao {
	private JdbcTemplate jdbcTemplate;

	public ManagerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//아이디로 회원 찾기
	public UserCommand SearchIdForm(String userid){
		String sql ="SELECT userid FROM User WHERE userid = ? ";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(),userid);
	}
	
	//이메일로 회원 찾기
	public UserCommand SearchEmailForm(String email){
		String sql ="SELECT email FROM User WHERE email = ? ";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(),email);
	}
	
	//모든 유저 목록
	public List<UserCommand> getAllUserForm(){
		String sql ="SELECT * FROM User";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	//관리자 유효성 검사용
	public List<Manager> isManager() {
		String sql = "SELECT * FROM Manager";
		
		return jdbcTemplate.query(sql, new ManagerRowMapper());
	}
		
}
