package back2931;

import java.util.*;

public class Main {
static Scanner in = new Scanner(System.in);
static int R = in.nextInt();
static int C = in.nextInt();
static boolean visit[][] = new boolean[R+2][C+2];	
static char graph[][] = new char[R+2][C+2];
static Queue<data> q = new LinkedList<>();

static class data{
	int x , y;
	
	data(int x,int y){
		this.x = x;
		this.y = y;
	}
}

public static void BFS(int x,int y){
	
	
	if(visit[x][y] == false){
		
		visit[x][y] = true;
		q.add(new data(x,y));
	}
	else{
		return;
	}
	
	while(!q.isEmpty()){
		data imsi = q.poll();
		
		if(graph[imsi.x][imsi.y] == '.'){
			
			if((graph[imsi.x][imsi.y-1] == '-' || graph[imsi.x][imsi.y-1] == '+')  && (graph[imsi.x][imsi.y+1] == '-' || graph[imsi.x][imsi.y+1] == '+')){
				if(graph[imsi.x+1][imsi.y] == '|'  && graph[imsi.x-1][imsi.y] == '|'){
					graph[imsi.x][imsi.y] = '+';
				}
				else if(graph[imsi.x+1][imsi.y] == '+'  && graph[imsi.x-1][imsi.y] == '|'){
					graph[imsi.x][imsi.y] = '+';
				}
				else if(graph[imsi.x+1][imsi.y] == '|'  && graph[imsi.x-1][imsi.y] == '+'){
					graph[imsi.x][imsi.y] = '+';
				}
				else if(graph[imsi.x+1][imsi.y] == '+'  && graph[imsi.x-1][imsi.y] == '+'){
					graph[imsi.x][imsi.y] = '+';
				}
				else{
					graph[imsi.x][imsi.y] = '-';
				}
			}
			
			if((graph[imsi.x-1][imsi.y] == '|' || graph[imsi.x-1][imsi.y] == '+')  && (graph[imsi.x+1][imsi.y] == '|' || graph[imsi.x+1][imsi.y] == '+')){
				if(graph[imsi.x][imsi.y-1] == '-'  && graph[imsi.x][imsi.y+1] == '-'){
					graph[imsi.x][imsi.y] = '+';
				}
				else if(graph[imsi.x+1][imsi.y] == '+'  && graph[imsi.x-1][imsi.y] == '|'){
					graph[imsi.x][imsi.y] = '+';
				}
				else if(graph[imsi.x+1][imsi.y] == '|'  && graph[imsi.x-1][imsi.y] == '+'){
					graph[imsi.x][imsi.y] = '+';
				}
				else if(graph[imsi.x+1][imsi.y] == '+'  && graph[imsi.x-1][imsi.y] == '+'){
					graph[imsi.x][imsi.y] = '+';
				}
				else{
					graph[imsi.x][imsi.y] = '-';
				}
			}
			
			
		}else{
			if(visit[imsi.x-1][imsi.y] == false){
			q.add(new data(x-1,y));
			}
			if(visit[imsi.x+1][imsi.y] == false){
				q.add(new data(x+1,y));
				}
			if(visit[imsi.x][imsi.y-1] == false){
				q.add(new data(x,y-1));
				}
			if(visit[imsi.x][imsi.y+1] == false){
				q.add(new data(x,y+1));
				}
		}
		
		
		
		
		
		
		
	}
	
	
	return;
}
	
	public static void main(String args[]){


	    
	    for(int i=1;i<=R;i++){
	    	for(int j=1;j<=C;j++){
	    		visit[i][j] = false;
	    	}
	    }
	    
	    for(int i=1;i<=R;i++){
	    	for(int j=1;j<=C;j++){
	    		String input = in.nextLine();
	    		char trans = input.charAt(0);
	    		graph[i][j] = trans;
	    	}
	    }
		
	    for(int i=1;i<=R;i++){
	    	for(int j=1;j<=C;j++){
	    		BFS(i,j);
	    	}
	    }
	    
	}
	
}
