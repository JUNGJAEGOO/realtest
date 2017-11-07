package back1016;

import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		long min = in.nextLong();
		long max = in.nextLong();
		long sr = (long) Math.sqrt(max);
		long dp[] = new long[1000001];
		boolean result[] = new boolean[1000001];
		int count = 0;
		long num = 0;
		for ( long i = 2 ; i <= sr ; i++){
			dp[(int)i] = i*i;
			num++;
		}
		//System.out.println(sr);
		for ( int i = 2 ; i <= sr ; i++ ){
			
			long realmin = min;
			if( realmin % dp[i] != 0){
			realmin = ( min/dp[i] + 1) * dp[i];
			}
			//System.out.println(realmin+" ¸®¾ó¹Î");
			
			for ( long j = realmin ; j <= max ; j+=dp[i]){
				if ( result[(int)(j-min)]==false){
				result[(int)(j-min)]=true;
				count++;
				}
			}
		}
		System.out.println(max-min-count+1);
		
	}
}
