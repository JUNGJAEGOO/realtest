package hang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	
	static boolean[] visited;
	static int[][] mat; 
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt(); // 시작점
		visited = new boolean[10001];
		mat = new int[1001][1001];
		
		int i; // for문 용
		int a,b;
		for(i=1;i<=M;i++){  // 그래프 그리기
			
		   a = sc.nextInt();
		   b = sc.nextInt();
		   mat[a][b] = 1;
		   mat[b][a] = 1;
			
		}
		
		dfs(V);
		for(int j=1;j<=N;j++){
			visited[j] = false;
		}
		System.out.println("");
		bfs(V);
		
}


	public static void dfs(int v){
		visited[v] = true;
		System.out.print(v + " ");
		for(int j=1;j<=N;j++){
			if(mat[v][j]==1 && visited[j]==false){
				dfs(j);
			}

		}
	}

	public static void bfs(int v){
		Queue<Integer> q = new LinkedList<>();
		visited[v] = true;
		System.out.print(v + " ");
		q.offer(v);
		int temp ;
		while(!q.isEmpty()){
			temp = q.poll();
		for(int j=0;j<N+1;j++){
			if(mat[temp][j]==1 && visited[j]==false){
				q.offer(j);
				visited[j] = true;
				System.out.print(j + " ");
			}
		}
		}
	}
	
}

