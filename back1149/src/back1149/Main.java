package back1149;

import java.util.*;

public class Main {
static Scanner in = new Scanner(System.in);
static int N = in.nextInt();
static int cost[][] = new int[N][3];
static int DP[][] = new int[N][3];
	
public static void main(String args[]){
	for(int i = 0 ; i < N ; i ++ ){
		for(int j = 0 ; j < 3 ; j++){
			cost[i][j] = in.nextInt();
		}
	}
	DP[0][0] = cost[0][0]; 
	DP[0][1] = cost[0][1]; 
	DP[0][2] = cost[0][2];	
for(int i = 1 ; i < N ; i++){	
DP[i][0] = cost[i][0] + Math.min(DP[i-1][1], DP[i-1][2]);
DP[i][1] = cost[i][1] + Math.min(DP[i-1][0], DP[i-1][2]); 
DP[i][2] = cost[i][2] + Math.min(DP[i-1][1], DP[i-1][0]); 
}


int min = Math.min(DP[N-1][0],Math.min(DP[N-1][1],DP[N-1][2]));

System.out.println(min);

}

}
