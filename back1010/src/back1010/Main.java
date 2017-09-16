package back1010;

import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int count = 0;
		
		
		
		while ( count < T ){
			
			int N = in.nextInt();
			int M = in.nextInt();
			long DP[] = new long[N+1];
			DP[1] = M;
			
			if( N == 2){
			for( int i = 0 ; i < M ; i ++){
				DP[2] = DP[2] + i;
			}
			}
			else if( N > 2 ){
				for( int i = 0 ; i < M ; i ++){
					DP[2] = DP[2] + i;
				}
				for(int i = 3 ; i <= N ; i++ ){
					long sum = 0;
					int min = 1;
					long tmp = 0;
					while ( true ){
					for(int j = M-1 ; j > min ; j--){
				    tmp = tmp + j ;
					}
					sum = sum + DP[i-1] - tmp;
				    min++;
				    tmp = 0;
				    if(min == M-1){
				    	break;
				    }
				    
					}
					DP[i] = sum;
				}
			}			
			
			count++;
			for(int i=1;i<=N;i++){
			System.out.println(DP[i]);
			}
		}
		
	}
	
}
