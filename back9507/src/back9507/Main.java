package back9507;
import java.util.*;
public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		long dp[][] = new long[68][16];
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[2][0] = 2;
		dp[3][0] = 4;
		for( int i = 4 ; i <= 67 ; i++){
			
			int count = 0;
			for(int x = 0 ; x < 9 ; x++){
			dp[i][x] = dp[i-1][x]+dp[i-2][x] + dp[i-3][x]+dp[i-4][x];
			}
			
			while ( count < 9){
				
			if (dp[i][count] >= 1000 ) {
				dp[i][count+1] += dp[i][count]/1000;
				dp[i][count] %= 1000;
			}
			
			count++;
			}
			
			
			
/*			boolean check = false;
			for(int s = 15 ; s>=0;s--){
				
			
			if(dp[i][s] == 0){ if(check == false){continue;} }
			

			
			if ( dp[i][s]< 10 && dp[i][s]>0){
				if ( check == false ){
					System.out.print(dp[i][s]);
				}
				else{
					System.out.print("00"+dp[i][s]);
				}
				check = true;
			}
			else if( dp[i][s] < 100 && dp[i][s] > 10){
				if ( check == false ){
					System.out.print(dp[i][s]);
				}
				else{
				System.out.print("0"+dp[i][s]);
				}
				check = true;
			}
			else if( dp[i][s]== 0)
			{
				System.out.print("000");
			}
			else{
				System.out.print(dp[i][s]);
				check = true;
			}
			
			
		}	
			
			System.out.println();
			
			*/
			
			
			
			
			
			
			
		}
		
		while ( T > 0){
			
			int N = in.nextInt();
			
			boolean check = false;
			for(int s = 15 ; s>=0;s--){
				
			
			if(dp[N][s] == 0){ if(check == false){continue;} }
			
			if ( dp[N][s]== 0){
				System.out.print("000");
			}
			
			if ( dp[N][s]< 10 && dp[N][s]>0){
				if ( check == false ){
					System.out.print(dp[N][s]);
				}
				else{
					System.out.print("00"+dp[N][s]);
				}
				check = true;
			}
			else if( dp[N][s] < 100 && dp[N][s] > 10){
				if ( check == false ){
					System.out.print(dp[N][s]);
				}
				else{
				System.out.print("0"+dp[N][s]);
				}
				check = true;
			}
			else{
				System.out.print(dp[N][s]);
				check = true;
			}
			
			
		}	
			System.out.println();
			T--;
       }
	}
}
// 0 0 0 0 0 0 0 0 0 0 0 0 274 423 830 33  // 41
/// 0 0 0 0 0 0 0 0 0 0 0 0 527 1967 1939 938  // 42
