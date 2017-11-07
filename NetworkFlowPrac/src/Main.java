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
			  prev[i] = -1;  // ������� �ݺ����� �ʱ�ȭ.
		  }
		  
			while ( !q.isEmpty() ){
				
				int tmp = q.remove();
				
				for( int i = 0 ; i < adj[tmp].size() ; i++ ){
					int next = adj[tmp].get(i); // �� ���� ���� ��带 �ϴ� ���ǿ� �´��� Ž���ϱ� ���� next�� ����.
					if ( prev[next] != -1){
						continue;    // �̹� �� ���� �ٸ� ��� Ž��
					}
					
					if ( capa[tmp][next] - flow[tmp][next] > 0 ){
						prev[next] = tmp;
						
						q.add(next);     // �긱�� �ִٸ�(��η� �� �� �ִٸ�) ť�� �߰�.
						
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
			
			if( prev[end] == -1){      // BFS�� ���������� ���� ��θ� ��ã���� �Լ� ����.
				break;
			}
			
			int flo = inf;  // �ּҰ� �񱳸� ���ؼ� �ſ� ū������.
			for ( int i = end ; i != start ; i = prev[i]){
				flo = Math.min(flo,capa[prev[i]][i]-flow[prev[i]][i]);  // ����߿��� ���� ���� ������ ���� ã�´�.
			}
			
			for ( int i = end ; i != start ; i = prev[i]){
				System.out.print(i+" ");
				flow[prev[i]][i] += flo;   // ������ ���� �������δ� �����ְ�
				flow[i][prev[i]] -= flo;   // ���������δ� ���ְ�
			}
			
			System.out.println("");
			result += flo;
			
		}
		
		
	}
}
