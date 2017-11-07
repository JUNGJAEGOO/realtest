package back11376;
import java.util.*;
public class Main {

	static ArrayList<Integer> list[];
	static int A[];
	static int B[];
	static boolean visit[];
	
	public static void main(String args[]){
		
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		visit = new boolean[2*N];
		int result = 0;
		A = new int[2*N];
		B = new int[M];
		
		for ( int i = 0 ; i < N ; i++){
			A[i] = -1;
		}
		for ( int i = 0 ; i < M ; i++){
			B[i] = -1;
		}
		
		list = new ArrayList[2*N];
		
		for(int i=0;i<2*N;i++){
			list[i] = new ArrayList<Integer>();//√ ±‚»≠
		}
		
		int index = 0;
		while ( index < 2*N ){
			int adjnum = in.nextInt();
			int tmp[] = new int[adjnum];
			for(int i = 0 ; i < adjnum ; i++){
				
				tmp[i] = in.nextInt() - 1;
				list[index].add(tmp[i]);
				list[index+1].add(tmp[i]);
			}
			
			index+=2;
		}
		
		
		for ( int i = 0 ; i < 2*N ; i++){
			
			for(int j = 0 ; j < 2*N ; j++){
			visit[j] = false;
			}
			if(DFS(i)){ result++; }
			
		}
		
		System.out.println(result);

/*	for(int i=0;i<N;i++){
			System.out.println(A[i]+1);
		}*/

		
		
		
		
	}
	
	
	public static boolean DFS(int start){
		
		if ( visit[start] == true){ return false;}	
		visit[start] = true;
	
		for(int i=0;i<list[start].size();i++){
			int end = list[start].get(i);
			
			if( B[end] == -1 || !visit[B[end]] && DFS(B[end])){
				A[start] = end;
				B[end] = start;
				return true;
			}
			
		}
		return false;
	}
}
