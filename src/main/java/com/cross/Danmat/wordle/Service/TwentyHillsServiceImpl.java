package com.cross.Danmat.wordle.Service;

import java.util.Random;

import com.cross.Danmat.wordle.Domain.TwentyHills;

public class TwentyHillsServiceImpl implements TwentyHillsService {
	Random rd = new Random();
	
	
	@Override
	public TwentyHills load_word(TwentyHills twentyHills) {
		twentyHiills = TwentyHillsDao.findByNum(rd.nextInt());
		return twentyHills;
	}

}
