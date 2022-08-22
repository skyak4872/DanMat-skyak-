//// 일단 dao로만
//package com.KIAC.DM.board.dao;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.apache.ibatis.session.SqlSession;
//
//import com.KIAC.DM.board.domain.Board;
////@Repository
//public class BoardDaoImpl {
//	 @Inject
//	 private SqlSession sql;
//	 
//	 private static String namespace = "com.board.mappers.board";
//	// 게시물 목록
//	// @Override
//	 public List<Board> list() {
//	     return sql.selectList(namespace + ".list");
//	 }
//	 
//	 // 게시물 등록
//	@Override
//	public void create(Board board) {
//		sql.insert(namespace + ".create", board);
//	}
//	
//	// 게시물 상세내용 불러오기
//	@Override
//	public Board detail(int no) {
//		return sql.selectOne(namespace +".detail", no);
//	}
//
//	// 게시물 수정
//	@Override
//	public void update(Board board) {
//		sql.update(namespace +".update", board);
//	}
//
//	// 게시글 삭제
//	@Override
//	public void delete(int no) {
//		sql.delete(namespace +".delete", no);
//	}
//}