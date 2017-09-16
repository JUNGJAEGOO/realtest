package back1912;
import java.util.*;
public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int DP[][] = new int[N][N];
		int A[] = new int[100000];
		for(int i=0;i<N;i++){
			A[i] = in.nextInt();
			
		}
		
		for(int i=0;i<N;i++){
			DP[i][i] = A[i];
		}
		
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				DP[i][j] = DP[i][j-1] + A[j];
			}
		}

	    //for(int i=0;i<N;i++){
	    //	for(int j=0;j<N;j++){
	    //		System.out.print(DP[i][j]+ " ");
	    //	}
	    //	System.out.println();
	    //}
		
		int count;
	    int max[] = new int[N];
	    for(int i=0 ; i<N ; i++){
	    	count = i;
	    	max[i] = DP[i][i];
	    	while(count < 10){
	    		if( max[i] < DP[i][count]){
	    			max[i] = DP[i][count];
	    		}
	    		count++;
	    	}
	    }
	    //for(int i =0;i<N;i++){
	    //	System.out.print(max[i]+" ");
	    //}
	    //System.out.println();
	    Arrays.sort(max);
	    System.out.println(max[N-1]);
	}
}
