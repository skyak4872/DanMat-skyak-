package com.cross.Danmat.crossword.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cross.Danmat.crossword.domain.Crossword;

public class CrosswordRowMapper implements RowMapper<Crossword>{

	@Override
	public Crossword mapRow(ResultSet rs, int rowNum) throws SQLException {
		Crossword cw = new Crossword(rs.getLong("wid"), rs.getString("word")
				, rs.getInt("len") , rs.getString("grade"), rs.getString("category"),
				rs.getString("category2"), rs.getString("def"), rs.getString("ex"));
		return cw;
	}
	

}
