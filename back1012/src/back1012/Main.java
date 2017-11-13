package back1012;

import java.util.*;
import java.io.*;


public class Main {
	static int mat[][];
	static boolean visit[][];
	static int result;
	public static void main (String args[])throws Exception{
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while ( T > 0 ){
		result = 0;
		StringTokenizer st;
		String input = br.readLine();
		st = new StringTokenizer(input," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		mat = new int[M+2][N+2];
		visit = new boolean[M+2][N+2];
		for ( int i = 1 ; i <= M ; i++){
			for ( int j = 1 ; j <= N ; j++){
				mat[i][j] = 0;
			}
		}
		for ( int i = 0 ; i < K ; i++){
			String tmp = br.readLine();
			st = new StringTokenizer(tmp," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			mat[x+1][y+1] = 1;
		}
		
		for ( int i = 1 ; i <= M ; i++){
			for ( int j = 1 ; j <= N ; j++){
				if ( mat[i][j] == 1 && visit[i][j] == false ){
					BFS(i,j);
					result++;
				}
			}
		}
		
		T--;
		System.out.println(result);
		}
	}
	
	public static void BFS(int X, int Y ){
		Queue<data> q = new LinkedList<>();
		q.add(new data(X,Y));
		visit[X][Y] = true;
		while ( !q.isEmpty() ){
			data tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			if ( mat[x+1][y] == 1 && visit[x+1][y] == false){
				visit[x+1][y] = true;
				q.add(new data(x+1,y));
			}
			if ( mat[x-1][y] == 1 && visit[x-1][y] == false){
				visit[x-1][y] = true;
				q.add(new data(x-1,y));
			}
			if ( mat[x][y+1] == 1 && visit[x][y+1] == false){
				visit[x][y+1] = true;
				q.add(new data(x,y+1));
			}
			if ( mat[x][y-1] == 1 && visit[x][y-1] == false){
				visit[x][y-1] = true;
				q.add(new data(x,y-1));
			}
			
		}
	}
	
	public static class data{
		int x, y;
		data( int x , int y ){
			this.x = x; this.y = y;
		}
	}
}
 

