package back1002;
import java.util.*;
public class Main {

	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int count = 0;
		while ( count < T ){
			
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int r1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int r2 = in.nextInt();
			
			int max = r1;
			int min = r2;
			if ( r2 > r1 ){
				max = r2;
				min = r1;
			}
			if( x1 == x2 && y1 == y2 && r1 == r2 ){
				System.out.println("-1");
			}
			else if( Math.sqrt(Math.pow((x1-x2),2)) + Math.sqrt(Math.pow((y1-y2),2)) == r1 + r2){
				System.out.println("1");
			}
			else if( Math.sqrt(Math.pow((x1-x2),2)) + Math.sqrt(Math.pow((y1-y2),2)) < max ){
				System.out.println("0");
			}
			else if( Math.sqrt(Math.pow((x1-x2),2)) + Math.sqrt(Math.pow((y1-y2),2)) > r1 + r2 ){
				System.out.println("0");
			}
			else if( Math.sqrt(Math.pow((x1-x2),2)) - Math.sqrt(Math.pow((y1-y2),2)) == max - min ){
				System.out.println("1");
			}
			else{
				System.out.println("2");
			}

			count ++;
		}
		
		
		
	}
}
