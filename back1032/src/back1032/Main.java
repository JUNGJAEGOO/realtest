package back1032;
import java.util.*;

public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		int count = 0;
		char[][] arr = new char[50][50];
		
		while ( count < N ){
			//System.out.println("�Է�: " );
			String s = in.nextLine();
			arr[count] = s.toCharArray();
			
			count++;
		}
	    
		int wordlength = arr[0].length; 
		char standard[] = arr[0];
	    for(int i = 1 ; i < N ; i++){
	    	for ( int j = 0 ; j < wordlength ; j++){
	    		if(arr[i][j]==standard[j]){
	    			standard[j] = standard[j];
	    		}
	    		else{
	    			standard[j] = '?';
	    		}
	    	}
	    }
	    
	    System.out.println(standard);
	    
	    
	    
	    
	}
	
}
