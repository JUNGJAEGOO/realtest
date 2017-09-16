package back11722;
import java.util.*;
public class Main {

	static Scanner in = new Scanner(System.in);
	static int N = in.nextInt();
	static int mat[] = new int[N];
	static int dp[] = new int[N];
	static int num[] = new int[N];
	public static void main(String args[]){
		
		for(int i=0;i<N;i++){
			mat[i] = in.nextInt();
			num[i] = 1;
		}
		
		
		for(int i=0;i<N;i++){
			
			for(int j=0;j<i;j++){
				
				if(mat[j]>mat[i] && num[j]+1>num[i] ){
					
					num[i] = num[j]+ 1;
					
				}
			}
			
		}
		
		Arrays.sort(num);
		for(int i =0;i<N;i++){
			System.out.print(num[i]+" ");
		}
		System.out.println("\n"+num[num.length-1]);
		

		
	}
	
}
