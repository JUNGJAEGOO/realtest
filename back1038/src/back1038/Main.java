package back1038;
import java.util.*;
public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int result;
		long start = 0;
		if ( N <= 10){
			start = N;
		}
		else{
			result = 10;
			start = 11;
			while (true){
				//System.out.println(start+"�� ���ϴ�.");
				int plus = calc(start);
				//System.out.println(plus+"���ϱ�");
				result += plus;
				start++;
				if ( result == N){ break; }
			}
	//999999
	//9701538
			
		}
		if(start > 10 )
		System.out.println(start-1);
		else
		System.out.println(start);
	}
	
	public static int calc(long x){
		boolean isgood = true;
		int count = 1;
		//System.out.println((long)(x / Math.pow(10,count)));
		
		while( true ){   // �ڸ��� ã��
			
			if ( (int)(x / Math.pow(10,count)) == 0){
				 count--; 
				 break;
			}
			
			count ++ ;
			
		}
		System.out.println("�ڸ����� "+count);
		long mok = (long) Math.pow(10,count);
		long before = (long) (x / mok);
		
		while( true ){
			if (x>= 10){
			x = x - before * mok ;
			if ( x==0 ){ 
				isgood = false; break; }
			}
			 mok /= 10;
	         long tmp = (long)(x / mok) ;
		    if ( before <= tmp ){
		    	isgood = false; break;		    
		    }
		    before = tmp;
		   
		    if(mok == 1){ break;}
			
		    
			
		}
		
		//700 96430
		//800 98720
		//900 751000
		//950 830000
		//1000 865320
		//1022 9876543210
		if ( isgood == true ){
		return 1;
		}
		else{
	    return 0;
		}
		
	}
}
