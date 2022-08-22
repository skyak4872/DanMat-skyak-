package com.cross.Danmat.Board.Domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Board {
	private int board_idx; // 게시물 번호
	private String userId; // 유저 id
	private String title; // 게시글 제목
	private String content; // 게시글 목록
	private Date createDate; // 게시글 생성일자
	private Date modifyDate; // 게시글 수정일자
	private Date deleteDate; // 게시글 삭제일자
	private String delete_yn;
	
	public Board() {
		super();
	}
}