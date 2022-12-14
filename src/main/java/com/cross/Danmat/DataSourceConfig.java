package com.cross.Danmat;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.cross.Danmat.Board.Dao.BoardDao;
import com.cross.Danmat.Board.Service.BoardServiceImpl;
import com.cross.Danmat.Manager.Dao.ManagerDao;
import com.cross.Danmat.Manager.Service.ManagerServiceImpl;
import com.cross.Danmat.TwentyHills.Dao.TwentyHillsDao;
import com.cross.Danmat.TwentyHills.Service.TwentyHillsServiceImpl;
import com.cross.Danmat.User.Dao.UserDao;
import com.cross.Danmat.User.Service.UserServiceImpl;
import com.cross.Danmat.crossword.dao.CrosswordDao;



@Configuration
public class DataSourceConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/danmat?serverTimezone=Asia/Seoul");
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public UserDao userDao() {
		return new UserDao(dataSource());
	}
	
	@Bean
	public UserServiceImpl userService() {
		return new UserServiceImpl(userDao());
	}
	
	@Bean
	public CrosswordDao crosswordDao() {
		return new CrosswordDao(dataSource());
	}
	
	@Bean
	public ManagerDao managerDao() {
		return new ManagerDao(dataSource());
	}
	
	@Bean
	public ManagerServiceImpl managerService() {
		return new ManagerServiceImpl(managerDao());
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao(dataSource());
	}
	
	@Bean
	public BoardServiceImpl boardService() {
		return new BoardServiceImpl(boardDao());
	}
	
	@Bean
	public TwentyHillsDao twentyHillsDao() {
		return new TwentyHillsDao(dataSource());
	}
	
	@Bean
	public TwentyHillsServiceImpl twentyHillsService() {
		return new TwentyHillsServiceImpl(twentyHillsDao());
	}
}
