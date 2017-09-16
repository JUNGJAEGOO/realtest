package MazeFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Maze extends JApplet implements Runnable {
	Thread t = new Thread(this);
	public Maze(){
	
}

	class walls{
		int x,y;
		boolean visit;
		walls(int x,int y,boolean visit){
			this.x = x;
			this.y = y;
			this.visit = visit;
		}
		
	}
	

	static int N = 11;
	static int Wsize = 500;
	static int Msize = N;
	static int BSIZE = (int)(Wsize/Msize);
	static int map[][] = new int[Msize][Msize];
	static walls m[][] = new walls[Msize][Msize];
	static ArrayList<walls> list = new ArrayList<>();


	
	public void initwalls(){
		for(int i=0;i<Msize;i++){
			for(int j=0;j<Msize;j++){
				m[i][j] = new walls(i,j,false);
			}
		}
		
		setVisible(true);
		making();
		

	}
	
	static int ran(){
		int rand = (int)(Math.random()*2 + 1);
		return rand;
	}
	
	static void making(){

			
			int randX = ran();
			int randY = ran();
			m[randX][randY].visit=true;
			
			if(randX - 1 !=0 ){
				list.add(m[randX-1][randY]);
			}
			if(randX + 1 !=Msize-1){
				list.add(m[randX+1][randY]);
			}
			if(randY - 1 !=0){
				list.add(m[randX][randY-1]);
			}
			if(randY + 1 !=Msize-1){
				list.add(m[randX][randY+1]);
			}
			
			while(!list.isEmpty()){
			int index = (int)(Math.random()*list.size());
			walls wall = list.get(index);
			
			if(wall.x%2 == 1){
				if(wall.y-1 != 0 && m[wall.x][wall.y-1].visit == false){
				m[wall.x][wall.y].visit = true;
				m[wall.x][wall.y-1].visit = true;
				
				if(wall.y-2 != 0){
					list.add(m[wall.x][wall.y-2]);
				}
				if(wall.x-1 != 0){
					list.add(m[wall.x-1][wall.y]);
				}
				if(wall.x+1 != 0){
					list.add(m[wall.x+1][wall.y]);
				}
				}
				else if(wall.y+1 <=Msize-1 && m[wall.x][wall.y+1].visit == false){
				m[wall.x][wall.y+1].visit = true;	
				m[wall.x][wall.y].visit = true;
				if(wall.y+2 != 0){
					list.add(m[wall.x][wall.y-2]);
				}
				if(wall.x-1 != 0){
					list.add(m[wall.x-1][wall.y]);
				}
				if(wall.x+1 != 0){
					list.add(m[wall.x+1][wall.y]);
				}
				}
			}
			else if(wall.x%2 ==0){
				if(wall.x-1 != 0 && m[wall.x-1][wall.y].visit == false){
				m[wall.x-1][wall.y].visit = true;
				m[wall.x][wall.y].visit = true;
				
				if(wall.x-2 != 0){
					list.add(m[wall.x-2][wall.y]);
				}
				if(wall.y-1 != 0){
					list.add(m[wall.x][wall.y-1]);
				}
				if(wall.y+1 != 0){
					list.add(m[wall.x][wall.y+1]);
				}
				}
				else if(wall.x+1 <=Msize-1 && m[wall.x+1][wall.y].visit == false){
				m[wall.x+1][wall.y].visit = true;	
				m[wall.x][wall.y].visit = true;
				if(wall.x+2 != 0){
					list.add(m[wall.x+2][wall.y]);
				}
				if(wall.y-1 != 0){
					list.add(m[wall.x][wall.y-1]);
				}
				if(wall.y+1 != 0){
					list.add(m[wall.x][wall.y+1]);
				}
				}
			}

				list.remove(index);
				
			}
		
			  for(int i=0;i<Msize;i++){
				   for(int j=0;j<Msize;j++){
				    if(m[i][j].visit == false){
				     if(i%2 == 1){
				      if(j%2 == 0){
				       map[i][j] = 1; 
				      }
				     }else{
				      map[i][j] = 1;
				     }
				    }
				   }
				  }
			  for(int i=0;i<Msize;i++){
				   map[i][Msize-1] = 1;
				   map[i][0] = 1;
				   
				   map[Msize-1][i] = 1;
				   map[0][i] = 1;
				  }
				  
				  map[0][1] = 0;
				  map[Msize-1][Msize-2] = 0;
				  
				for(int i=0;i<Msize;i++){
					for(int j=0;j<Msize;j++){
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
		
	}
	 public void paint(Graphics g){
		  for(int i=0;i<Msize;i++){
		   for(int j=0;j<Msize;j++){
		    if(map[i][j] == 1) drawBlock(g, j, i);
		   }
		  }
		 }
		 
		 public void drawBlock(Graphics g, int x, int y){
		  g.setColor(Color.black);
		  
		  Color t = new Color(100,100,50);
		  g.setColor(t);
		  g.fillRect(x*BSIZE, y*BSIZE, BSIZE, BSIZE);
		 }
		

	public static void main(String args[]){
		new Maze();

	}
	

	@Override
	public void run() {
		while(true){}
		// TODO Auto-generated method stub
		
	}
}
