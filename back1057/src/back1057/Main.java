package back1057;
import java.util.Scanner;
public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int round = 0;
		int tmp = N;
		
		round = (int)(Math.ceil((Math.log(tmp)/Math.log(2))));

		//System.out.println(round);
		int n = in.nextInt();
		int m = in.nextInt();
		int count = 0;
		while ( count < round){
			
			if ( n%2 == 1){
				if( n+1 == m){
					break;
				}
				else{
					 n = Math.round((float)n/2);
					 m = Math.round((float)m/2);
					 //System.out.println(n + "°ú" + m);
					 count ++ ;
				}
			}
			else if ( n%2 == 0){
				if( n-1 == m){
					break;
				}
				else{
					 n = Math.round((float)n/2);
					 m = Math.round((float)m/2);
					 //System.out.println(n + "°ú" + m);
					 count ++ ;
				}
			}
		}
		
		System.out.println(count+1);
		
	}
	
}
