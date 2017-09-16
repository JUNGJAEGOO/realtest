package back2302;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		
		Scanner in = new Scanner (System.in);
		int N = in.nextInt();
		int M = in.nextInt(); //고정석 개수
		int fix[] = new int[M+1];
		int num[] = new int[N-M];
		for(int i = 0 ; i < M ; i++){
			
			fix[i] = in.nextInt();
			
		}
		
		int count = 0;
		int count2 = 0;
		for(int i = 1 ; i <= N ; i++){
		
		if( i != fix[count]){
			num[count2]++;
		}
		else if( i == fix[count] && i+1 != fix[count+1]){
			count++;
			count2++;
		}
		else if( i == fix[count] && i+1 == fix[count+1]){
			count++;
		}
		}
		
		int count3 = 0;
		int save[] = new int[count2+1];
		int DP[] = new int[N+1];
		
		while( count3 <= count2 ){
		if(count == N){
			break;
		}
		DP[1] = 1;
		DP[2] = 2;
		for(int i=3;i<=num[count3];i++){
		DP[i] = DP[i-1] + DP[i-2];
		}
		save[count3] = DP[num[count3]];
		count3++;
		
	    }
		//System.out.println(count2 + " " + count3);
		int sum = 1;
		if (count==N){
			sum = 0;
		}
		for(int i=0;i<count3;i++){
			//System.out.println(save[i] + " " + num[i]);
			sum = sum * save[i];
		}
		System.out.println(sum);
	}

}
