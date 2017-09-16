package hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hang {

	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		System.out.println("지금부터 행맨 게임을 시작합니다.");
		String[] line = new String[16];
		String game;
		int ran;
		int ran1;  // 첫번째 무작위로 글씨 가리기
		int ran2;  // 두번째 무작위로 글씨 가리기
		int maxleng; // 선택된 단어 길이
		while(true){
			int suc = 0;
			
		try {
			BufferedReader bw = new BufferedReader(new FileReader("c:\\words.txt"));
			
			try {
				for(int i=0;i<16;i++){
				line[i] = bw.readLine();
				System.out.println(line[i]);}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		ran = (int)(Math.random() * 16 );
		game = line[ran];
		maxleng = game.length();
		ran1 = (int)(Math.random() * maxleng);
		ran2 = (int)(Math.random() * maxleng);
		System.out.println(game + " " + maxleng + ran1 + ran2);
		
		if (ran2 == ran1){
			while(true){
				ran2 = (int)(Math.random() * maxleng);
				if(ran2 != ran1){
					break;
				}
			}
		}
		
		char[] gameTOarray = game.toCharArray();
		char[] gameTOarray2 = game.toCharArray();
	
		gameTOarray2[ran1] = '_';
		gameTOarray2[ran2] = '_';
		System.out.println(gameTOarray);
		int fail = 0;
		while(true){

		System.out.println(gameTOarray2);
		System.out.print(">> ");
		String scan1 = input.nextLine();
		char[] scan = scan1.toCharArray();
		
		if(scan[0] == (gameTOarray[ran1])){
			System.out.println("적중!");
			gameTOarray2[ran1] = scan[0];
			suc++;
		}
		else if(scan[0] == (gameTOarray[ran2])){
			System.out.println("적중!");
			gameTOarray2[ran2] = scan[0];
			suc++;
		}
		else{
			System.out.println("틀림!");
			fail++;
		}
		
		if(suc == 2){
			System.out.println("완전 정답. 그동안의 실패 횟수는 : "+fail);
			break;
		}
		
		}
		
		System.out.print("다시하시겠습니까? y/n >> ");
		String ms = input.nextLine();
		if(ms.equals("n".toUpperCase())){
			break;
		}

		
		}
		
		
	}
}
