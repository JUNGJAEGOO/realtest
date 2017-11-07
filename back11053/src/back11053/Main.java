package back11053;
import java.util.*;

public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int A[] = new int[N+1];
		int DP[] = new int[N+1];
		int count[] = new int[N+1];
		for ( int i = 1 ; i <= N ; i++){
			A[i] = in.nextInt();
			DP[i] = A[i];
		}
		
		for ( int i = 1 ; i <= N ;i++){
			for ( int j = 1 ; j <= i ; j++){
				if ( A[i] > A[j] ){
					if ( DP[j]+A[i] < DP[i]){
					DP[i] = DP[i];}
					else{
					DP[i] = DP[j]+A[i];
					count[i]++;
					}
				}
			}
			count[i]++;
		}
		
		int max = 0;
		for(int i= 1 ;i<=N;i++){
		if( count[i]>max){ max = count[i];} 
		}
		System.out.println(max);
	}		
}
