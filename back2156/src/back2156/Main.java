package back2156;
import java.util.*;

public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int dp[] = new int[N];
		for(int i = 0 ; i < N ; i ++){
			arr[i] = in.nextInt();
		}
		
		if(N==1){
			System.out.println(arr[0]);
		}
		else if(N==2){
			System.out.println(arr[0]+arr[1]);
		}
		else if(N==3){
			System.out.println(Math.max(arr[2]+arr[0],Math.max(arr[0]+arr[1],arr[1]+arr[2])));
		}
		else if(N>3){
		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(arr[2]+arr[0],Math.max(arr[0]+arr[1],arr[1]+arr[2]));
		for ( int i = 3 ; i < N ; i++){
		dp[i] = Math.max(dp[i-1],Math.max(arr[i]+arr[i-1]+dp[i-3],arr[i]+dp[i-2]));
		
		}
     /*	for ( int i = 0 ; i < N ; i++){
			System.out.println(dp[i]);
		}*/
		System.out.println(dp[N-1]);
		}
		
	}
}
