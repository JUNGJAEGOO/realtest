package back2579;
import java.util.*;
public class Main {
static Scanner in = new Scanner(System.in);
	static int N = in.nextInt();
	static int point[] = new int[N+1];
	static int dp[] = new int[N+1];
	public static void main(String args[]){
		point[0] = 0;
		for(int i=1;i<=N;i++){
			
			point[i] = in.nextInt();
			
		}
		
		dp[0] = 0;
		dp[1] = point[1];
		dp[2] = point[2] +  Math.max(point[1],point[0]);
		dp[3] = point[3] +  Math.max(point[2],point[1]);
		//dp[2] = point[2] + dp[1] + dp[0];
		//dp[3] = point[3] + dp[2] + dp[1];
		for(int i=4;i<=N;i++)
		{
			
		     dp[i] = point[i] + Math.max(dp[i-3]+point[i-1],dp[i-2]);

		}
		
		for(int i=1;i<=N;i++){
		System.out.println(dp[i]);
		}
	}
	
}
