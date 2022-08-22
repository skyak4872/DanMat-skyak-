package com.cross.Danmat.Board.Service;

import java.util.List;

import com.cross.Danmat.Board.Dao.BoardDao;
import com.cross.Danmat.Board.Domain.Board;

public class BoardServiceImpl implements BoardService {
	 private BoardDao boardDao = null;
	 
	 public BoardServiceImpl() {
		 super();
	 }
	 
	 public BoardServiceImpl(BoardDao boardDao) {
		 this.boardDao = boardDao;
	 }
	 
	 // 게시판 목록
	 @Override
	 public List<Board> boardList() {
		 return boardDao.boardList();
	 }
	 
	 // 게시물 작성
	 @Override
	 public void boardCreate(Board board) {
		 boardDao.boardCrate(board);		
	 }


	 // 게시물 삭제
//	@Override
//	public void boardDelete(int board_idx) {
//		boardDao.boardDelete(board_idx);	
//	}
	 

	 // 게시물 수정
//	@Override
//	public void boardUpdate(Board board, List<String> updateList) {
//		boardDao.boardUpdate(board, updateList);
//		
//		title
//		content
//		modifyDate
//
//	}


	// 게시물 상세내용 불러오기
//	@Override
//	public Board detail(int no) {
//		return boardDao.detail(no);
//	}

}