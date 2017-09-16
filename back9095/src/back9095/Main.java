package back9095;
import java.util.*;
public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int count = 0;
		while ( count < T){
		int N = in.nextInt();
		int DP[] = new int[N+1];
		if( N == 1){
		DP[1] = 1;
		}
		else if ( N == 2){
		DP[1] = 1;	
		DP[2] = 2;	
		}
		else if ( N == 3){
		DP[1] = 1;
		DP[2] = 2;		
		DP[3] = 4;
		}
		else if( N >= 4 ){
			DP[1] = 1;
			DP[2] = 2;
			DP[3] = 4;
		for(int i=4;i<=N;i++){
		DP[i] = DP[i-1] + DP[i-2] + DP[i-3] ;
		}
		}
		System.out.println(DP[N]);
		count++;
		}
	}
}
