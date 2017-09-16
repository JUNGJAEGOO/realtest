package back1018;

import java.util.*;
public class Main {

	
	static Scanner in = new Scanner(System.in);
	static Scanner in2 = new Scanner(System.in);
	static int N = in.nextInt();
	static int M = in.nextInt();
	
	static char oriboard[][]= new char[N+2][M+2];;
	
	public static void main(String args[]){
		

		for( int i = 1 ; i <= N ; i++){
			String s = in2.nextLine();
			for ( int j = 1 ; j<= M ; j ++ ){
				 
				 oriboard[i][j] = s.charAt(j-1);
			}
		}
		/*
		WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
		for( int i = 1 ; i <= N ; i++){
			for ( int j = 1 ; j<= M ; j ++ ){
				System.out.print(oriboard[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");*/
		
		int mincount = 100000;
		int x = 1;
		int y = 1;
		
		while ( true ){
			
			
			int tmpcount = BFS(x,y);
			if ( mincount > tmpcount ) { mincount = tmpcount; }
			
			if ( x+7 < N){ x++; }
			else if( y+7 < M ){ y++; }
			else{ break; }
			
		}
		
		System.out.println(mincount);
		
	}
	
	public static int BFS(int startX,int startY){
		
		/*Queue<data> q = new LinkedList<data>();
		q.add(new data(1,1));*/
		char board[][] = new char[10][10];
		/*boolean visit[][] = new boolean[10][10];*/
		for( int i = 1 ; i <= 8 ; i++){
			for ( int j = 1 ; j<= 8 ; j ++ ){
				 board[i][j] = oriboard[startX+i-1][startY+j-1];
			}
		}
		
/*		for( int i = 1 ; i <= N ; i++){
			for ( int j = 1 ; j<= M ; j ++ ){
				System.out.print(oriboard[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");*/
		
		int count = 0;
		
		/*while ( ! q.isEmpty() ){*/
		 	
			/*data tmp = q.remove();
			System.out.println(tmp.x +" " + tmp.y + " ����");
			visit[tmp.x][tmp.y]=true;*/
		for ( int x = 1 ; x <= 8 ; x ++){
			for ( int y = 1 ; y <= 7 ; y++){
		
			if ( board[x][y] == 'W'){
				/*q.add(new data(tmp.x+1,tmp.y));
				q.add(new data(tmp.x-1,tmp.y));
				q.add(new data(tmp.x,tmp.y+1));
				q.add(new data(tmp.x,tmp.y-1));*/
				if ( board[x][y+1] == 'W' ){
					board[x][y+1] = 'B';
					count++;
				}
					
			}
			else if ( board[x][y] == 'B'){
				if ( board[x][y+1] == 'B'){
					board[x][y+1] = 'W';
					count++;
					}
				}
			}
		}
/*			else if ( board[tmp.x+1][tmp.y] == 'B'){
				q.add(new data(tmp.x+1,tmp.y));
				q.add(new data(tmp.x-1,tmp.y));
				q.add(new data(tmp.x,tmp.y+1));
				q.add(new data(tmp.x,tmp.y-1));
				if ( board[tmp.x][tmp.y] == 'B' && visit[tmp.x+1][tmp.y] == false){
					board[tmp.x+1][tmp.y] = 'W';
					count++;
					
				}
				if ( board[tmp.x-1][tmp.y] == 'B' && visit[tmp.x-1][tmp.y] == false){
					board[tmp.x-1][tmp.y] = 'W';
					count++;
					
				}
				if ( board[tmp.x][tmp.y+1] == 'B' && visit[tmp.x][tmp.y+1] == false){
					board[tmp.x][tmp.y+1] = 'W';
					count++;
					
				}
				if ( board[tmp.x][tmp.y-1] == 'B' && visit[tmp.x][tmp.y-1] == false ){
					board[tmp.x][tmp.y-1] = 'W';
					count++;
					
				}
			}*/
			
			
		
		
		return count;
	}
	
/*	public static class data{
		
		int x;
		int y;
		data(int x,int y){
			this.x = x;
			this.y = y;
		}
		
	}*/
	
}
