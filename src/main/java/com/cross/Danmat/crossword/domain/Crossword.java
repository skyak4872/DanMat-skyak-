package com.cross.Danmat.crossword.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Crossword {
	private long Wid;
	private String Word;
	private int Len;
	private String Grade;
	private String Category;
	private String Category2;
	private String Def;
	private String Ex;
}
