package back10942;
import java.util.*;
public class Main {

	static int arr[] = new int[2001];
	static int DP[][] = new int[2001][2001];
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for(int i=1;i<=N;i++){
			
			arr[i] = in.nextInt();
			
		}

		
		
		for(int i = 0 ; i < 2001 ; i++){
			for(int j = 0 ; j< 2001 ; j++){
				DP[i][j] = -1;
			}
		}
		
		int M = in.nextInt();
		int count = 0;
		int ans[] = new int[M];

		while(count<M){
			
			int S = in.nextInt();
			int E = in.nextInt();
			ans[count] = DFS(S,E);
			count++;
		}
		
		for(int i=0;i<M;i++){
			System.out.println(ans[i]);
		}

	}
	
	public static int DFS(int Start,int End){
		if ( Start == End){
			return 1;
		}
		if ( arr[Start] != arr[End]){
			return 0;
		}
		if ( DP[Start][End] != -1 ){
			return DP[Start][End];
		}
		if ( End < Start ) {
			return 1;
		}
		
		return DP[Start][End] = DFS(Start+1,End-1);
		
	}
}
