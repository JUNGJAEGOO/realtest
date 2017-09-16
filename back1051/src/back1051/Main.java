package back1051;
import java.util.*;
public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int Nleng = 0;
		int Mleng = 0;
		int mat[][] = new int[150][150];
		int add = 0;
		int count = 0;
		
		if( N<=M){
		mat = new int[N+2*N-2][M+2*N-2];
		Nleng = 3*N - 2;
		Mleng = M+2*N-2;
		add = N-1;
		count = N-1;
		}
		else if ( M<N){
		mat = new int[N+2*M-2][M+2*M-2];
		Nleng = N+2*M-2;
		Mleng = 3*M - 2;
		add = M-1;
		count = M-1;
		}
		
		for(int i=0 ; i< Nleng ;i++){
			for(int j=0;j< Mleng;j++){
				mat[i][j] = -1;
			}
		}
		for(int i=add ; i< N + add;i++){
			for(int j=add;j< M + add;j++){
				mat[i][j] = in.nextInt();
			}
		}
		for(int i=0 ; i< Nleng;i++){
			for(int j=0;j< Mleng;j++){
				System.out.print(mat[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println(count);
		
		int max = 0;
while(true){

	for(int i=add;i<N+add;i++){
		for(int j=add;j<M+add;j++){
		if( mat[i][j] == mat[i+count][j+count] && mat[i][j] == mat[i][j+count] && 
				mat[i][j] == mat[i+count][j]){
			if ( count > max ){ max = count; }
		}
		else if( mat[i][j] == mat[i-count][j-count] && mat[i][j] == mat[i-count][j] && 
				mat[i][j] == mat[i][j-count]){
			if ( count > max ){ max = count; }
		}
		else if( mat[i][j] == mat[i+count][j-count] && mat[i][j] == mat[i][j-count] && 
				mat[i][j] == mat[i+count][j]){
			if ( count > max ){ max = count; }
		}
		else if( mat[i][j] == mat[i-count][j+count] && mat[i][j] == mat[i-count][j] && 
				mat[i][j] == mat[i][j+count]){
			if ( count > max ){ max = count; }
		}
		}
	}

	count --;
	if (count==0){break;}

}
		
System.out.println((max+1) * (max+1));
		
		
	}
	
}
