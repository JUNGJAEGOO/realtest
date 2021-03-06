import java.util.*;


public class Main {

	static int DP[][];
	static int maxsize = 0;
	static boolean visit[][];
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int Testcase = in.nextInt();
		int count = 0;
		int arr[][] = new int[Testcase][3];
		while ( Testcase > count ){
			
			arr[count][0] = count+1;  // 인덱스 설정.
			arr[count][1] = in.nextInt() + 1;  // 사이즈 정하기.
			//if ( arr[count][1] > maxsize ) { maxsize = arr[count][1]; }
			maxsize = arr[count][1];
			
			
			
			DP = new int[maxsize][maxsize];
			visit = new boolean [maxsize][maxsize];
			for(int i = 0 ; i < maxsize ; i ++){
				for ( int j = 0 ; j< maxsize ; j++){
					DP[i][j] = 1;
					visit[i][j] = false;
				}
			}
			
			for(int i = 0 ; i < maxsize ; i++){
				DP[0][i] = 0;
				DP[i][0] = 0;
			}
			DP[0][1] = 1;
			DP[1][0] = 1;
			
			cal(1,1);
			
			int size = 0;
			for(int i = 0 ; i < maxsize ; i ++){
				for ( int j = 0 ; j< maxsize ; j++){
					//System.out.print(DP[i][j]+" ");
					if (DP[i][j] == 1){ size ++;}
				}
				//System.out.println("");
			}
			
			
			arr[count][2] = size;
			
			count++;
			
		}
		
		for(int i = 0 ; i < Testcase ; i++){
		System.out.print(arr[i][0] +" "+ (arr[i][1]-1) + " "+arr[i][2]);
		System.out.println("");
		}
		
	}
	
	
	public static void cal(int x,int y){
		
		if( x == maxsize || y == maxsize || visit[x][y] == true ){ return; }

		visit[x][y] = true;
		
		if ( x >= y && DP[x][y]!= 0){
			for(int i = 2; x*i < maxsize ; i++ ){
				DP[x*i][y*i] = 0;
			}
		}
		else if(y>x && DP[x][y]!= 0){
			for(int i = 2 ; y*i < maxsize ; i++ ){
				DP[x*i][y*i] = 0;
			}
		}
		
		cal(x+1,y);
		
		cal(x,y+1);
		
		return;
	}
	
	
}
