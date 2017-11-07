import java.util.*;

public class Main {

	static int prev[];
	static int flow[][];
	static int capa[][];
	static int inf = 1900000000;
	static ArrayList<Integer> adj[];
	static int result = 0;
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int e = in.nextInt();
		adj = new ArrayList[n];
		flow = new int[n][n];
		capa = new int[n][n];
		prev = new int[n];
		
		for(int i=0;i<n;i++){
			adj[i] = new ArrayList<Integer>();
			
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				capa[i][j] = inf;
			}
		}
		
		for(int i=0;i<e;i++){
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			int capacity = in.nextInt();
			capa[x][y] = capacity;
			
			adj[x].add(y);
			adj[y].add(x);
		}
		
		for(int i = 0 ; i<n ; i++){
			for(int j=0;j<adj[i].size();j++){
				System.out.print(adj[i].get(j));
			}
			System.out.println("");
		}
		
		int start = in.nextInt() - 1;
		int end = in.nextInt() - 1;
		
		networkFlow(start,end,n);
		System.out.println(result);
	}
	
	public static void networkFlow(int start,int end,int n){
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		while ( true ){
			
		  q.add(start);
			
		  for ( int i = 0 ; i < n ; i++){
			  prev[i] = -1;  // 경로정보 반복마다 초기화.
		  }
		  
			while ( !q.isEmpty() ){
				
				int tmp = q.remove();
				
				for( int i = 0 ; i < adj[tmp].size() ; i++ ){
					int next = adj[tmp].get(i); // 안 가본 주위 노드를 일단 조건에 맞는지 탐색하기 위해 next로 지정.
					if ( prev[next] != -1){
						continue;    // 이미 간 노드면 다른 노드 탐색
					}
					
					if ( capa[tmp][next] - flow[tmp][next] > 0 ){
						prev[next] = tmp;
						
						q.add(next);     // 흘릴수 있다면(경로로 볼 수 있다면) 큐에 추가.
						
						if ( next == end){
							break;
						}
					}
					
				}
			}
			for(int i = 0 ; i < n ; i++){
				System.out.print(prev[i]+ " ");
			}
			System.out.println();
			
			if( prev[end] == -1){      // BFS로 마지막까지 가는 경로를 못찾으면 함수 종료.
				break;
			}
			
			int flo = inf;  // 최소값 비교를 위해서 매우 큰값으로.
			for ( int i = end ; i != start ; i = prev[i]){
				flo = Math.min(flo,capa[prev[i]][i]-flow[prev[i]][i]);  // 경로중에서 가장 작은 유량의 값을 찾는다.
			}
			
			for ( int i = end ; i != start ; i = prev[i]){
				System.out.print(i+" ");
				flow[prev[i]][i] += flo;   // 역으로 가는 방향으로는 더해주고
				flow[i][prev[i]] -= flo;   // 순방향으로는 빼주고
			}
			
			System.out.println("");
			result += flo;
			
		}
		
		
	}
}
