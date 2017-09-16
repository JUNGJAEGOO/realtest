package practice;
import java.util.*;
public class Main {
	static Scanner in = new Scanner(System.in);

	static int N = in.nextInt();
	
	static int mat[][] = new int[N][N];

	public static void main(String args[]){
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				mat[i][j] = in.nextInt();
				if (mat[i][j] == 0){ mat[i][j] = 100;} 
			}

		}

		int max = 100;
		
		//for(int i=0;i<N;i++){
		//	for(int j=0;j<N;j++){
////
		//		System.out.print(mat[i][j]+" ");
		//			
		//	}
		//	System.out.println();
		//}
		//System.out.println();
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				for( int j=0;j<N;j++){
					
					if( mat[i][j] > mat[i][k]+mat[k][j]){
						mat[i][j] = mat[i][k]+mat[k][j];
					}
					
				}	
			}	
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){

				if ( mat[i][j] != 100 ){
					mat[i][j] = 1;
				}
				else if (mat[i][j] == 100 ) {
					mat[i][j] = 0;
				}
				System.out.print(mat[i][j]+" ");
					
			}
			System.out.println();
		}
		
	}



}
