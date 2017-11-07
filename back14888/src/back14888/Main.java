package back14888;
import java.util.*;
public class Main {
	static int maxlength;
	static int opr[];
	static int arr[];
	static int N;
	static String tmp = "";
	static String res = "";
	static boolean check;
	static int max;
	static int min;
	static int count = 0;
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N];
		opr = new int[4];
		for ( int i = 0 ; i < N ; i++){
			arr[i] = in.nextInt();
		}
		for ( int i = 0 ; i < 4 ; i++){
			opr[i] = in.nextInt();
			maxlength += opr[i];
		}
		
		String result;
		
			for ( int i = 0 ; i < 4 ; i++){
				if ( opr[i]!=0){
					check = false;
					DFS(i,0);
				}
			}
			
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void DFS(int start,int len){
		opr[start]--;
		tmp += Integer.toString(start);
		//System.out.print(start);
		if ( len+1 == maxlength){
			if ( check == false){
				res = tmp;
				check = true;
			}else{
				char tmpchar[] = res.toCharArray();
				char tmpchar2[] = tmp.toCharArray();
				for ( int i = 0 ; i<tmp.length();i++){
					tmpchar[res.length()-tmp.length()+i]=tmpchar2[i];
				}
				res = String.valueOf(tmpchar);
			}
			//System.out.print(res+" ");
			tmp = "";
			
			int tmpsum = arr[0];
			for ( int i = 0 ; i < res.length() ; i++){
				
				if ( res.charAt(i)=='0'){
					tmpsum = tmpsum+arr[i+1];
				}
				else if ( res.charAt(i)=='1'){
					tmpsum = tmpsum-arr[i+1];
				}
				else if ( res.charAt(i)=='2'){
					tmpsum = tmpsum*arr[i+1];
				}
				else if ( res.charAt(i)=='3'){
					tmpsum = (int)(tmpsum/arr[i+1]);
				}
			}
			//System.out.println(tmpsum);
			if ( count == 0){
			max = tmpsum; min = tmpsum;
			}
			if ( tmpsum > max){
				max = tmpsum;
			}else if ( tmpsum < min){
				min = tmpsum;
			}
			count++;
			
		}
		for ( int i = 0 ; i < 4 ; i++){
			if ( opr[i]!=0){
			
			DFS(i,len+1);
			}
		}
		opr[start]++;
	}
}
