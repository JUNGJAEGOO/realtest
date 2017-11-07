package back1019;
import java.util.*;
public class Main {

	static int max = 1000000000;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int dp[] = new int[10];
		for(int i = 0 ; i < 10 ; i++){
		dp[i] = 0;
		}
		
		if ( N < 10){
			int count = N;
			while ( count > 0){
				dp[count] += 1;
				count--;
			}
			
			for(int i = 0 ; i < 10 ; i++){
				System.out.print(dp[i]+" ");
			}
			
			return;
		}
		
		
		int stan = pandan(N);
		System.out.println(stan);
		int tmp = N;
		tmp /= stan;
		//System.out.println(tmp);
		
		while ( N >= 10){
			
		if ( N >= 10){
			for(int i = 1 ; i < 10 ; i++){
				dp[i] += 1;
			}
			for(int i = 0 ; i <= tmp; i++){
				dp[i] += tmp;
			}
			
			for(int i = 0 ; i < tmp; i++){
				dp[tmp] += 1;
			}
			
		}
		N = N / 10;
		
		}
		
		N = N % stan;

		if ( N < 10){
			int count = N;
			while ( count > 0){
				dp[count] += 1;
				count--;
			}
		}
		
		
		
		for(int i = 0 ; i < 10 ; i++){
		System.out.print(dp[i]+" ");
		}
	}
	
	public static int pandan(int x){
		int stan = 1000000000;
		
		while ( stan > 1){
			if ( x / stan != 0){
				return stan;
			}
			stan /= 10;
		}
		
		return -1;
	}
}
