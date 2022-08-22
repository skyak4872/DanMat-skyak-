package com.cross.Danmat.Board.Service;
import java.util.List;

import com.cross.Danmat.Board.Domain.Board;

public interface BoardService {
	public List<Board> boardList();
	public void boardCreate(Board board);
//	public void delete(int no);
//	public Board detail(int board_idx);
//	public void boardUpdate(Board board);
}