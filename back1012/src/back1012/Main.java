package back1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	static int M = in.nextInt(); // 가로
	static int N = in.nextInt(); // 세로
	static int K = in.nextInt(); // 배추수
	static int gaesoo = 0;
	static int mat[][] = new int[N+2][M+2];
	static boolean visit[][] = new boolean[N+2][M+2];
	public static void main(String args[]){
		for(int i=1;i<=N;i++){
			for(int j=1;j<=M;j++){
				mat[i][j] = 0;
				visit[i][j] = false;
			}
		}
		int count = K;
		while ( true ){
			int X = in.nextInt();
			int Y = in.nextInt();
			mat[Y+1][X+1] = 1;
			count --;
			if( count <= 0 ){ break; }
		}
		
		//for(int i=1;i<=N;i++){
		//	for(int j=1;j<=M;j++){
		//		System.out.print(mat[i][j]+" ");
		//	}
		//	System.out.println();
		//}
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=M;j++){
				BFS(i,j);
			}
		}
		System.out.println(gaesoo);
	}
	
 static void BFS(int x,int y){
	 Queue<data> q = new LinkedList<data>();
	 if(mat[x][y] == 1 && visit[x][y] == false ){
		 data start = new data(x,y);
		 q.offer(start);
		 visit[x][y] = true;
		 gaesoo++;
	 }
	 else{
		 return;
	 }
	 
	 while(!q.isEmpty()){
		 data imsi = q.poll();
		 if(mat[imsi.x+1][imsi.y] == 1 && visit[imsi.x+1][imsi.y] == false){
			 q.add(new data(imsi.x+1,imsi.y));
			 visit[imsi.x+1][imsi.y] = true;
		 }
		 if(mat[imsi.x-1][imsi.y] == 1 && visit[imsi.x-1][imsi.y] == false){
			 q.add(new data(imsi.x-1,imsi.y));
			 visit[imsi.x-1][imsi.y] = true;
		 }
		 if(mat[imsi.x][imsi.y+1] == 1 && visit[imsi.x][imsi.y+1] == false){
			 q.add(new data(imsi.x,imsi.y+1));
			 visit[imsi.x][imsi.y+1] = true;
		 }
		 if(mat[imsi.x][imsi.y-1] == 1 && visit[imsi.x][imsi.y-1] == false){
			 q.add(new data(imsi.x,imsi.y-1));
			 visit[imsi.x][imsi.y-1] = true;
		 }
		 
		 
	 }
	 
	 return;
	 
 }
 
 static class data{
	 int x,y;
	 data(int x,int y){
		 this.x = x;
		 this.y = y;
	 }
 }
 
}
