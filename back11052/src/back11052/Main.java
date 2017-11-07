package back11052;
import java.util.*;
public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int price[] = new int[N+1];
		int dp[] = new int[N+1];
		for ( int i=1;i<=N;i++){
			price[i] = in.nextInt();
		}
		
		dp[1] = price[1];
		int count = 1;
		while ( count <= N ){
			
			for(int i = 1 ; i<= count ; i++){
			dp[count] = Math.max(dp[count-i]+price[i],dp[count]);
			}
			
			count ++;
		}
		
		
			System.out.println(dp[N]);
		
	}
}
