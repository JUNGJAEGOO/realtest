package back1254;
import java.util.*;
public class Main {

	static Scanner in = new Scanner(System.in);
	static String S = in.nextLine();;
	static char Arr[];
	static int c;
	
	public static void main(String args[]){
	    
		
		
		Arr = S.toCharArray();
		
		if ( Arr.length == 1) { System.out.println(1); return;}
		
			int leftmax = -1,rightmax = -1;
			int max = -1;
			
/*			for ( int i = 1 ; i <= Arr.length-1 ; i ++){

					//System.out.println(0+"������ "+i+"��° ��");
					FELIN(0,i,0);
					
					if ( c != 0 ){
						int left = 0;
						int right = i;
						
						while ( true ){
						int savec = c;
						left ++;
						right --;
					    if ( left > right) { break; }
						FELIN(left,right,c);
						//aSystem.out.println(c +"�� "+ savec);
						
						}

					}
						
					if ( leftmax < c){ leftmax = c; } 
					c = 0;
				
			}*/
			
			for ( int s = 0 ; s <= Arr.length-2 ; s ++){

					//System.out.println(s+"������ "+(Arr.length-1)+"��° ��");
					FELIN(s,Arr.length-1,0);
					
					if ( c != 0 ){
						int left = s;
						int right = Arr.length-1;
						
						while ( true ){
						int savec = c;
						left ++;
						right --;
					    if ( left > right || c == 0) { break; }
						FELIN(left,right,c);
						//System.out.println(c +"�� "+ savec);
						
						}

					}
					
					if ( rightmax < c){ rightmax = c; } 
					c = 0;
				
			}
			
			//System.out.println(leftmax +" "+ rightmax);
			
			if ( leftmax >= rightmax){ max = leftmax; }
			else { max = rightmax; }
			
			int length = 0;
			if ( max == 0 ){ length = (Arr.length * 2) - 1; } 
			else if ( max == Arr.length ){ length = max; }
			else { length = Arr.length + (Arr.length - max)   ; }
			
			System.out.println(length);
	
		
	}
	
	public static void FELIN(int i , int j,int count){
	
		
		if( i == j ){
			count++;
			c = count;
			return;
		}
		if( Arr[i] == Arr[j] ){
			c = c + 2;
			//System.out.println("����");
			//FELIN(i++,j--,count);
			return;
		}
		if( i > j ){
			c = count;
			return;
		}
		if( Arr[i]!= Arr[j]){
			c = 0;
			//System.out.println("�޶�!");
			return;
		}
		
		
	}
	
}
