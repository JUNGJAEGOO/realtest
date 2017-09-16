package mazegame;

import java.awt.Graphics;
import java.util.Stack;
import java.awt.*;
import javax.swing.*;

class data{
	int x;
	int y;
	data(int x,int y){
		this.x = x;
		this.y = y;
	}
	
}

public class mazeamaking extends JFrame{
	
	static int Msize = 9;
	static int winSize = 500;
	static int map[][] = new int[Msize][Msize];
	static Stack<data> st = new Stack<>();
	static boolean visit[];
	static int Bsize = (int)(winSize/Msize);

	static class data{
		int x,y;
		data(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void init(){   // 미로 초기화
		for(int i=0;i<Msize;i=i+2){
			for(int j=0;j<Msize;j++){
		    map[i][j] = 1;
		 	}
		}
		for(int i=1;i<Msize;i=i+2){
			for(int j=0;j<Msize;j=j+2){
			    map[i][j] = 1;
			 	}
			for(int j=1;j<Msize;j=j+2){
			    map[i][j] = 0;
			    st.push(new data(i,j));
			 	}
		}
		
	}
	static char ran(){
		int rand = (int)(Math.random()*4);
		char choice;
		
		if(rand == 0){
			choice = 'U';
		}
		else if(rand == 1){
			choice = 'D';
		}
		else if(rand == 2){
			choice = 'L';
		}
		else{
			choice = 'R';
		}
		return choice;
	}
	
	static void crush(){
		while(!st.isEmpty()){
		data imsi = st.peek();
		int x = imsi.x;
		int y = imsi.y;
		int cantgo[] = {1,1,1,1};
		char bbob;
		System.out.print("("+x+","+y+")" +" 선택  ");
		st.pop();

		if(x-1 == 0 || map[x-1][y] == 0 ){  // 위로가기 제약
			cantgo[0] = 0;
		}
		if(x+1 == Msize-1 || map[x+1][y] == 0){ // 아래로가기 제약
			cantgo[1] = 0;
		}
		if(y-1 == 0 || map[x][y-1] == 0){ // 좌로 가기 제약
			cantgo[2] = 0;
		}
		if(y+1 == Msize-1 || map[x][y+1] == 0){ // 우로 가기 제약
			cantgo[3] = 0;
		}
		System.out.print(" cantgo = ");
		
		for(int i=0;i<4;i++){
			System.out.print(cantgo[i]+" ");
		}
		
		while( true){
			if( cantgo[0] == 0 && cantgo[1] == 0 && cantgo[2] == 0 && cantgo[3] == 0){ bbob = 'P'; break; }	
		bbob = ran();
		
		if ( bbob == 'U' && cantgo[0]==0){
			continue;  // 다시 뽑기
		}
		else if ( bbob == 'D' && cantgo[1]==0){
			continue;  // 다시 뽑기
		}
		else if ( bbob == 'L' && cantgo[2]==0){
			continue;  // 다시 뽑기
		}
		else if ( bbob == 'R' && cantgo[3]==0){
			continue;  // 다시 뽑기
		}
		else{
			break;
		}
		}
		
		if(bbob == 'U'){
			map[x-1][y] = 0;
			System.out.print("(" + (x-1) + "," + y + ")" + " 뚫기");
		}
		else if(bbob == 'D'){
			map[x+1][y] = 0;
			System.out.print("(" + (x+1) + "," + y + ")" + " 뚫기");
		}
		else if(bbob == 'L'){
			map[x][y-1] = 0;
			System.out.print("(" + (x) + "," + (y-1) + ")" + " 뚫기");
		}
		else if(bbob == 'R'){
			map[x][y+1] = 0;
			System.out.print("(" + (x) + "," + (y+1) + ")" + " 뚫기");
		}
		else{
			System.out.print("그냥 통과");
		}
		System.out.println("");
		}
		

	}
	
public void paint(Graphics g){

//map[0][1] = 0;
//map[Msize-1][Msize-2] = 0;
	for(int i=0;i<Msize;i++){
		for(int j=0;j<Msize;j++){
			if(map[i][j]==1) {drawBlock(g,j,i);}
		}
	}
	

	
}
public void drawBlock(Graphics g,int x,int y){
	g.setColor(Color.BLACK);
	Color t = new Color(100,100,50);
	g.setColor(t);
	g.fillRect(x*Bsize+50, y*Bsize+50, Bsize, Bsize);
}
	
public mazeamaking(){
	setTitle("미로 찾기");
	setSize(winSize+100,winSize+100);
	setLayout(new FlowLayout());
	setVisible(true);
}
public static void main(String args[]){
	
	init();

	
	crush();
	//map[0][0] = 0;  // 출발점
	//map[Msize][Msize] = 0; // 종료점 
	
	for(int i=0;i<Msize;i++){
		for(int j=0;j<Msize;j++){
			System.out.print(map[i][j]);
		}
		System.out.println();
	}
	
	new mazeamaking();
	
	
}
	
}

