package back7576;
import java.util.*;
public class Main {
	static Scanner in = new Scanner(System.in);
	static  int M = in.nextInt();
	static  int N = in.nextInt();
	static int opr=0;
	static int mat[][] = new int[M+2][N+2];
	static char visit[][] = new char[M+2][N+2];
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);

		
		for( int i = 1 ; i <= M ; i++){
			for ( int j = 1 ; j <= N ; j++){
				visit[i][j] = 'p';
			}
		}
		
		for( int i = 1 ; i <= M ; i++){
			for ( int j = 1 ; j <= N ; j++){
				mat[i][j] = in.nextInt();
				if( mat[i][j] == 1){
				visit[i][j] = 'n';}
			}
		}
		
		int minuscount = 0 , onecount = 0;
		for( int i = 1 ; i <= M ; i++){
			for ( int j = 1 ; j <= N ; j++){
				if ( mat[i][j] == -1){
					minuscount++;
				}
				if(mat[i][j] == 1){
					onecount ++;
				}
			}
		}
		
		if( minuscount + onecount == M*N ){ System.out.println("0"); return;}

		
		int zerocount = 0;
		for( int i = 1 ; i <= M ; i++){
			for ( int j = 1 ; j <= N ; j++){
				if ( mat[i][j] == 0){
					zerocount++;
				}
			}
		}
		if( zerocount == M*N ){ System.out.println("-1"); return;}



		
		
		
		int day = 0;
		while ( true ){
			
			for( int i = 1 ; i <= M ; i++){
				for ( int j = 1 ; j <= N ; j++){
					if ( visit[i][j] == 'x' )
					{ visit[i][j] = 'n'; } 
				}
			}
		/*	//11 11
			0 0 0 0 1 0 -1 -1 0 0 0
			0 -1 1 1 0 0 1 1 0 0 0
			0 0 0 0 -1 1 0 0 1 0 0
			0 0 -1 0 0 -1 -1 0 0 0 -1
			1 1 -1 0 0 1 0 0 0 -1 1
			-1 0 0 0 0 0 1 0 0 1 0
			0 1 0 -1 0 0 0 0 1 1 1
			0 0 0 1 0 0 0 0 0 -1 0
			0 0 0 0 0 0 0 0 0 0 -1
			-1 0 0 0 0 0 1 1 0 0 1
			-1 0 0 0 0 -1 -1 0 0 0 -1*/
			
			
			opr = 0;
			
			for( int i = 1 ; i <= M ; i++){
				for ( int j = 1 ; j <= N ; j++){
					if(mat[i][j]==1 && visit[i][j]=='n'){
						BFS(i,j);
					
					}
				}
			}
			
			
			if ( opr == 0 ){ break; } 
			
			
			day++;
		}
		
		int count = 0;
		for( int i = 1 ; i <= M ; i++){
			for ( int j = 1 ; j <= N ; j++){
				if(visit[i][j]=='n'){
					count ++;
				}
			}
		}
		
		
		
		
		if( minuscount == M*N || count != M*N - minuscount ){ 
			System.out.println("-1"); }
		else { System.out.println(day); }
		
	}
	
	public static void BFS(int i , int j){
		
		if ( mat[i+1][j] == 0 && visit[i+1][j] == 'p'){
			visit[i+1][j] = 'x';
			mat[i+1][j] = 1;
			opr++;
		}
		if ( mat[i-1][j] == 0 && visit[i-1][j] == 'p'){
			visit[i-1][j] = 'x';
			mat[i-1][j] = 1;
			opr++;
		}
		if ( mat[i][j+1] == 0 && visit[i][j+1] == 'p'){
			visit[i][j+1] = 'x';
			mat[i][j+1] = 1;
			opr++;
		}
		if ( mat[i][j-1] == 0 && visit[i][j-1] == 'p'){
			visit[i][j-1] = 'x';
			mat[i][j-1] = 1;
			opr++;
		}
		
		return;
	}
}
