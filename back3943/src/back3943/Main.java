package back3943;
import java.util.*;
public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int count = 0;
		
		while ( count < T ){
		int N = in.nextInt();
		int DP[] = new int[1000001];
		count ++;
		
		DP[1] = N;
		int i = 0;
		long max = DP[1];
		int count1=0;
		while ( true ){
			
			i++;
			if ( DP[i] == 1) { break; }
			
			if ( DP[i] % 2 == 0 ){
				
					DP[i+1] = DP[i]/ 2 ;	
					count1++;
				if (DP[i]>max) { max = DP[i]; } 
			
				
			}
			else{
				
				DP[i+1] = (DP[i]*3) + 1;
				count1++;
				if (DP[i+1]>max) { max = DP[i+1]; } 
			}
			
			if ( DP[i+1] == 1 ){
				break;
			}
			
		}
		
		System.out.println(max);
		System.out.println(count1);
		}
	}
}
