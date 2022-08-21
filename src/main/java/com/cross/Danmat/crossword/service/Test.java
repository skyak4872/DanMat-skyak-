package com.cross.Danmat.crossword.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cross.Danmat.DataSourceConfig;
import com.cross.Danmat.crossword.dao.CrosswordDao;
import com.cross.Danmat.crossword.data.GridGenerator;
import com.cross.Danmat.crossword.data.TextIO;
import com.cross.Danmat.crossword.domain.Crossword;

public class Test {
	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
//		CrosswordDao cw_Dao = context.getBean("crosswordDao",CrosswordDao.class);
//		List<String> word_list = new ArrayList<>();
//		List<Integer> rd_result = new ArrayList<>();
//		Random rd = new Random();
//		int size = 10;
//		
//		맵 제작
//		단어 선택
//		단어 넣을 위치 선택
//		다음 시작 위치 선택
//		다음 단어 선택
//		단어 중복 검사
//		위치 선택
//		
		//맵 틀
//		char[][] map = new char[size][size];
//		
//		//단어 선택할 단어 리스트 중 단어 선택
//		List<Crossword> cw_list = cw_Dao.findAll();
//		word_list.add(cw_list.get(rd.nextInt(cw_list.size())).getWord());
//		
//		//단어 넣을 위치 선택 및 단어 배열 만들기
//		int f_location = rd.nextInt(map.length);
//		int count = 0;
//		int word_count = 0;
//		char[] word = word_list.get(count).toCharArray();
//		
//		//해당 위치에 단어 넣기
//		int x_location = f_location; // 배열의 위치를 나타내주는 변수 
//		int y_location = 0; // y의 위치값을 나타내주는 변수
//		
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[0].length; j++) {
//				map[i][j] = '*';
//			}
//		}
//		for(int i = f_location; i <=f_location ; i++) {
//			for(int j = y_location; j< word.length; j++) {
//				map[i][j] = word[word_count];
//				word_count++;
//			}
//			count = 0;
//		}
//		int next_keyword = rd.nextInt(word_list.get(count).length()-1);
//		count++;
//		char keyword = word[next_keyword];
//		
//		cw_list = cw_Dao.findAllByword(keyword);
//		word_list.add(cw_list.get(rd.nextInt(cw_list.size())).getWord());
//		
//		System.out.println(keyword);
//		System.out.println(next_keyword);
//		System.out.println(word_list.get(1));
//		
//		y_location += next_keyword;
//		
//		for(int i = x_location-next_keyword; i <= x_location+word.length; i++) {
//			for(int j = y_location; j <= y_location; j++) {
//				map[i][j] = word[word_count];
//			}
//			count++;
//		}
//		count = 0;
//		
//		
//		
//		for(int i = 0; i< map.length; i++) {
//			for(int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j]+ "  ");
//			}
//			System.out.println();
//		}
		
		
		int size = 5;
		
		GridGenerator puzzle = new GridGenerator(size);
		puzzle.makeAtOnce();
		puzzle.showGrid();
		
		ArrayList<int[]> everyBlock = new ArrayList<int[]>();
		everyBlock = puzzle.getEveryInfoOfBlocks();
		
		for(int i = 0; i < everyBlock.size(); i++) {
			int[] temp = everyBlock.get(i);
			for(int j = 0; j < temp.length - 1; j++) {
				TextIO.put(temp[j] + ", ");
			}
			TextIO.put(temp[temp.length-1]);
			TextIO.putln();
		}
		System.out.println(puzzle.openedSquareCounter());
		
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