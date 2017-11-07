package back1110;
import java.util.*;

public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int sip = 0;
		int il = 0;
		int result = N;
		int count = 0;
		
		if ( N == 0) { System.out.println(1); return; }
		
		while ( true ){
			
			if ( result >= 10){
			sip = result / 10;
			il = result % 10;
			}
			else if ( result < 10){
				result = result*10 + result;
				count++;
				//System.out.println("현재"+result);
				if ( result == N ){ System.out.println(count); break; }
				continue;
			}
			
			if ( sip + il < 10){
				result = il*10 + sip+il;
			}
			else if ( sip + il >= 10 ){
				result = il*10 + (sip+il)%10;
			}
			
			//System.out.println("현재"+result);
			//System.out.println("처음"+N);
			count ++ ;
			if ( result == N )
			{ 
				System.out.println(count);
				break;
			}
			
			
		}
		
		
	}
}
