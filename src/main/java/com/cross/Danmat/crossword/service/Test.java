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
		int size = 10;
		int count = 0;
		
		List<Crossword> cw_list = cw_Dao.findAll();
		
		int wd_number = rd.nextInt(cw_list.size());
		word_list.add(cw_list.get(wd_number).getWord());
		
		char[][] map = new char[size][size];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				map[i][j] = '*';
			}
		}
		char[] word = word_list.get(count).toCharArray();
		
		int dice = rd.nextInt(size);
		int x_location = dice;
		int y_location = 0;
		
		for(int i = x_location; i <=x_location; i++) {
			for(int j = y_location; j < word.length; j++) {
				map[i][j] = word[j];
			}
		}
		
		y_location += word.length-1;
		int word_leng = rd.nextInt(word.length);
		char keyword = word[word_leng];
		cw_list = cw_Dao.findAllByword(keyword);
		wd_number = rd.nextInt(cw_list.size());
		word_list.add(cw_list.get(wd_number).getWord());
		count++;
		word = word_list.get(count).toCharArray();
		System.out.println(word_list.get(count-1));
		System.out.println(word);
		int x_num = 0;
		int y_num = word_leng+word_list.get(count-1).length();
		System.out.println(word_leng);
		for(int i = 0; i < word_list.get(count-1).length(); i++) {
			for(int j = 0; j < word.length; j++) {
				if(word_list.get(count-1).charAt(i) == word[j]) {
					x_num = j;
				}
			}
		}
		System.out.println(x_num);
		int wd_len = 0;
		for(int i = x_location-x_num; i < x_location-x_num+word.length; i++) {
			for(int j = y_location-y_num; j <= y_location-y_num; j++) {
				map[i][j] = word[wd_len];
			}
			wd_len++;
		}
		wd_len = 0;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + "  ");
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