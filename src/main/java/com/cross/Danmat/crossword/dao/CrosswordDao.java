package com.cross.Danmat.crossword.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cross.Danmat.crossword.data.CrosswordRowMapper;
import com.cross.Danmat.crossword.domain.Crossword;

public class CrosswordDao {
	JdbcTemplate jdbcTemplate;

	public CrosswordDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public List<Crossword> findAll(){
		String sql = "SELECT * FROM word";
		
		return jdbcTemplate.query(sql, new CrosswordRowMapper());
	}
	
	public Crossword findWord(long wid) {
		String sql = "SELECT * FROM word WHERE wid = ?";
		
		return jdbcTemplate.queryForObject(sql, new CrosswordRowMapper(), wid);
	}
	
	public List<Crossword> findAllByword(char word){
		String sql = "SELECT * FROM word WHERE word LIKE ?";
		return jdbcTemplate.query(sql, new CrosswordRowMapper(), "%"+word+"%");
	}
	
	public List<Crossword> findAllBylen(int len){
		String sql = "SELECT * FROM word WHERE len = ?";
		return jdbcTemplate.query(sql, new CrosswordRowMapper(), len);
	}
}
