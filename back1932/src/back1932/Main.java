package back1932;

import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);
	static int n = in.nextInt();
	static int tri[][] = new int[n][n];
	static int hap[][] = new int[n][n];
	
	public static void main(String args[]){
		
		for(int i=0;i<n;i++){
			for(int j=0;j<i+1;j++){
				tri[i][j] = in.nextInt();
			}
		}
		
		hap = tri;
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i+1;j++){
				if(j==0 ){
					hap[i][j] = hap[i][j] + hap[i-1][j];
				}
				else if(j==i){
					hap[i][j] = hap[i][j] + hap[i-1][j-1];
				}
				else {
					hap[i][j] = hap[i][j] + max(hap[i-1][j-1],hap[i-1][j]);
				}
			}
		}
		
	int max = 0;	
	
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(hap[i][j] > max){
					max = hap[i][j];
				}
			}
		}
		
		System.out.println(max);
		
	}
	

	private static int max(int i, int j) {
		int max = i ;
		if (max<j){
			max = j;
		}
		return max;
	}
	
}
