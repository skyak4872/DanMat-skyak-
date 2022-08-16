package com.cross.Danmat.crossword.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cross.Danmat.DataSourceConfig;
import com.cross.Danmat.crossword.dao.CrosswordDao;
import com.cross.Danmat.crossword.domain.Crossword;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CrosswordDao cw_Dao = context.getBean("crosswordDao",CrosswordDao.class);
		List<String> word_list = new ArrayList<>();
		Random rd = new Random();
		int count = 0;
		
		List<Crossword> cw_list = cw_Dao.findAll();
		
		int wd_numbewr = rd.nextInt(cw_list.size());
		word_list.add(cw_list.get(wd_numbewr).getWord());
		System.out.println(word_list.get(count));
		while(count <= 5){
			System.out.println(rd.nextInt(word_list.get(count).length()));
			char wc = word_list.get(count).charAt(rd.nextInt(word_list.get(count).length()));
			List<Crossword> wc_list = cw_Dao.findAllByword(wc);
			int number = rd.nextInt(wc_list.size());
			word_list.add(wc_list.get(number).getWord());
			System.out.println(word_list.get(count+1));
			count++;
		}
	}
}