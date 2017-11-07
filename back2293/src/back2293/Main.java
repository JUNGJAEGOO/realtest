package back2293;
import java.util.*;
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
		dp[0] = 1;
		for ( int i = 0 ; i < coin.length; i++){
			for ( int j = 1 ; j <= k ; j++){
				if ( j-coin[i] >= 0){
					dp[j] = dp[j] + dp[j-coin[i]];
				}
			}
		}
		
	
		System.out.println(dp[k]);
	
	}
}