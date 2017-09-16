package back1004;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static class data{
		int x,y,r;
		data(int x,int y,int r){
			this.x = x;
			this.y = y;
			this.r = r;
		}

	}
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();

		int count = 0;
		
		
		while ( count < T ){
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			
			ArrayList<data> list = new ArrayList<data>();
			int n  = in.nextInt();
			int plannet = 0;
			for( int i = 0 ; i < n ; i++){
				
				int x = in.nextInt();
				int y = in.nextInt();
				int r = in.nextInt();
				list.add(new data(x,y,r));
				//System.out.println(list.get(i).x +" "+list.get(i).y + " " + list.get(i).r);
			}
		    
			for( int i = 0 ; i < n ; i++){
				data tmp = list.get(i);
				//System.out.println(Math.pow((tmp.x - x1),2) + Math.pow((tmp.y - y1),2) <= Math.pow(tmp.r,2));
				//System.out.println(Math.pow((tmp.x - x2),2) + Math.pow((tmp.y - y2),2) <= Math.pow(tmp.r,2));
				//System.out.println(i+"¹øÂ°");
				if(Math.pow((tmp.x - x1),2) + Math.pow((tmp.y - y1),2) <= Math.pow(tmp.r,2) && Math.pow((tmp.x - x2),2) + Math.pow((tmp.y - y2),2) <= Math.pow(tmp.r,2) ){
				}
				else if( Math.pow((tmp.x - x1),2) + Math.pow((tmp.y - y1),2) <= Math.pow(tmp.r,2) ){
					
					plannet ++ ;
				}
				else if( Math.pow((tmp.x - x2),2) + Math.pow((tmp.y - y2),2) <= Math.pow(tmp.r,2) ){
					
					plannet ++ ;
				}

			}
			
			System.out.println(plannet);
		}
		
	}
}
