package back1009;
import java.util.Scanner;
public class Main {

	public static void main(String args[]){
	
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();
	int count = 0;

	while( true ) {
	int a = in.nextInt();
	int b = in.nextInt();
	long result = 1;
	
	while(true){
	result = a * result;
	b--;
	if ( result > 10){
		result = result % 10;
	
	}
	
	if(b == 0){ break;}
	}
	
	if(result == 0){
		result = 10;
	}
	
	count ++;
	System.out.println(result);
	
	if(count>=T){
		break;
	}
	
	}
	
	}
}
