package back2178;

import java.util.*;

public class Main {
	static boolean visit[][] = new boolean[100][100];
	static Scanner in = new Scanner(System.in);
	static int M = in.nextInt();
	static int N = in.nextInt();
	static int Mat[][] = new int[M+2][N+2];
	
	public static void main(String args[]){

	for(int i=1;i<=M;i++){
		for(int j=1;j<=N;j++){
			Mat[i][j] = in.nextInt();
		}
	}
	for(int i=1;i<=M;i++){
		for(int j=1;j<=N;j++){
		visit[i][j] = false;
		}
	}
	
	
	bfs(1,1);
	
	
	}
	
	static void bfs(int X,int Y){
		Queue<data> que = new LinkedList<data>();
		data start = new data(X,Y,1);
		que.add(start);
		visit[X][Y] = true;

		while(!que.isEmpty()){
		
		data DATA = que.poll();
		
		if(Mat[DATA.x-1][DATA.y] == 1 &&  visit[DATA.x-1][DATA.y] == false){
			que.offer(new data(DATA.x-1,DATA.y,DATA.cost+1));
			visit[DATA.x-1][DATA.y]=true;
		}
		if(Mat[DATA.x+1][DATA.y] == 1 &&  visit[DATA.x+1][DATA.y] == false){
			que.offer(new data(DATA.x+1,DATA.y,DATA.cost+1));
			visit[DATA.x+1][DATA.y]=true;
		}
		if(Mat[DATA.x][DATA.y-1] == 1 &&  visit[DATA.x][DATA.y-1] == false){
			que.offer(new data(DATA.x,DATA.y-1,DATA.cost+1));
			visit[DATA.x][DATA.y-1]=true;
		}
		if(Mat[DATA.x][DATA.y+1] == 1 &&  visit[DATA.x][DATA.y+1] == false){
			que.offer(new data(DATA.x,DATA.y+1,DATA.cost+1));
			visit[DATA.x][DATA.y+1]=true;
		}
		
		if(DATA.x == M && DATA.y == N){
			System.out.println("탈출 성공, 코스트는 "+DATA.cost);
		}
		
		}
		
		
	}
	
	static class data{
		int x,y,cost;
		data(int x,int y,int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
	}
}
