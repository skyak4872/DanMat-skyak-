package com.cross.Danmat.Board.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cross.Danmat.Board.Domain.Board;

public class BoardDao {
	private JdbcTemplate jdbcTemplate;

	public BoardDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public BoardDao() {
		super();
	}
	
	// 게시판 목록
	public List<Board> boardList() {
		String sql = "SELECT * FROM board";
		return jdbcTemplate.query(sql, new RowMapper<Board>() {
			
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board(rs.getInt("board_idx"), rs.getString("userId"), rs.getString("title"), rs.getString("content"), rs.getDate("createDate"), rs.getDate("modifyDate"), rs.getDate("deleteDate"), rs.getString("delete_yn"));
				return board;
			}		
		});
	}
	
	// 게시물 작성
	public void boardCrate(Board board) {
		String sql = "INSERT INTO Board(userId, title, content) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, board.getUserId(), board.getTitle(), board.getContent());		
	}
	
	
	// 게시글 삭제
//	public void delete(int no) {
//	
//	}
	
	
	//-----------------------------------------
	// 게시글 수정
//	public void boardUpdate(Board board, List<String> updateList) {
//		String sql = "UPDATE Board SET title=? content=? modifyDate=now() where board_idx=?";
//		updateList.add(board.getTitle());
//		updateList.add(board.getContent());
//		System.out.println(updateList);
//		
//		jdbcTemplate.update(sql, updateList , board.getBoard_idx());
//	}
	
	
//	public void create(Board board);
//
//	public Board detail(int no);
//	
//	

}