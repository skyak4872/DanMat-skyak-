package com.cross.Danmat.crossword.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.PriorityQueue;
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
		List<Integer> rd_result = new ArrayList<>();
		Random rd = new Random();
		int size = 10;
		
		List<Crossword> cw_list = cw_Dao.findAll();
		word_list.add(cw_list.get(rd.nextInt(cw_list.size())).getWord());
		List<Character> word = new ArrayList<Character>();
		int number = rd.nextInt(word_list.get(0).length());
		char n = word_list.get(0).charAt(number);
		String keyword = cw_list.get(rd.nextInt(cw_list.size())).getWord();
		for(int i = 0; i < 10; i++) {
			word.add(n);
			while(word.get(i) == n){
				number = rd.nextInt(word_list.get(i).length());
				n = word_list.get(i).charAt(number);
			}				
			cw_list = cw_Dao.findAllByword(n);
			while(word_list.get(i) == keyword) {
				keyword = cw_list.get(rd.nextInt(cw_list.size())).getWord();
			}
			word_list.add(keyword);
		}
		word_list.remove(0);
		System.out.println();
		for(int i = 0; i < word_list.size(); i++) {
			System.out.println(word_list.get(i));
		}
		
		char[][] map = new char[size][size];
		
		for(int i = 0; i< map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = '*';
			}
		}
		
		for(int i = 0; i< word_list.size(); i++) {
			for(int j = 0; j < word_list.get(i).length(); j++) {
				map[i][j] = word_list.get(i).charAt(j);
			}
		}
		
		for(int i = 0; i< map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+ "  ");
			}
			System.out.println();
		}
		
		
		
		
//		while(count <= 5){
//			System.out.println(rd.nextInt(word_list.get(count).length()));
//			char wc = word_list.get(count).charAt(rd.nextInt(word_list.get(count).length()));
//			List<Crossword> wc_list = cw_Dao.findAllByword(wc);
//			int number = rd.nextInt(wc_list.size());
//			word_list.add(wc_list.get(number).getWord());
//			System.out.println(word_list.get(count+1));
//			count++;
//		}
	}
}