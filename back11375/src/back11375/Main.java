package back11375;

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
		visit = new boolean[N];
		int result = 0;
		A = new int[N];
		B = new int[M];
		
		for ( int i = 0 ; i < N ; i++){
			A[i] = -1;
		}
		for ( int i = 0 ; i < M ; i++){
			B[i] = -1;
		}
		
		list = new ArrayList[N];
		
		for(int i=0;i<N;i++){
			list[i] = new ArrayList<Integer>();//√ ±‚»≠
		}
		
		int index = 0;
		while ( index < N ){
			int adjnum = in.nextInt();
			int tmp[] = new int[adjnum];
			for(int i = 0 ; i < adjnum ; i++){
				
				tmp[i] = in.nextInt() - 1;
				list[index].add(tmp[i]);
			}
			
			index++;
		}
		
		
		for ( int i = 0 ; i < N ; i++){
			
			for(int j = 0 ; j < N ; j++){
			visit[j] = false;
			}
			if ( DFS(i) ){ result ++ ; }
			
		}
		
		System.out.println(result);
		
		
		
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
