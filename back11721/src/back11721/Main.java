package back11721;

import java.util.*;

public class Main{
    
    
    
    public static void main(String args[]){
    
        Scanner in = new Scanner(System.in);
        String str;
        str = in.nextLine();
        char cut[][] = new char[10][10];
        char[] ori = new char[100];
        ori = str.toCharArray();
        System.out.println(ori.length);
        int count=0;
        for(int i=0;i<10;i++){
            
            for(int j=0;j<10;j++){
            cut[i][j]=ori[count];
            if(count>ori.length){
            	break;
            }
            count++;
            }
        }
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
            System.out.print(cut[i][j]);
            }
            System.out.println();
        }
        
        
        
    }
}