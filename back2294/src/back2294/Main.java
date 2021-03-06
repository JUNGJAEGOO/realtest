package back2294;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner ( System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int coin[] = new int[n];
		int dp[] = new int[k+1];
		for ( int i = 0 ; i < n ; i++){
			coin[i] = in.nextInt();
		}
		
		for ( int i = 0 ; i < coin.length ; i++){
			if ( coin[i]>k ){ continue; }
			dp[coin[i]] = 1;
		}
		
		for ( int i = 0 ; i < coin.length ; i++){
			for ( int j = 1 ; j<=k ; j++){
				if ( j-coin[i]>=0){
					if ( dp[j-coin[i]] != 0){
						if ( dp[j] == 0 ){ dp[j] = dp[j-coin[i]]+1; }
						else {dp[j] = Math.min(dp[j],dp[j-coin[i]]+1); }
					}
				}
			}
		}
		/*for ( int i = 0 ; i <= k ; i++){
			System.out.println(dp[i]);
		}*/
		if ( dp[k] == 0 ){
			System.out.println(-1);
		}else{
		System.out.println(dp[k]);
		}
	}
}
