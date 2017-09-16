package prac_translator;
import java.util.*;
public class Main {

	public static void main(String args[]){
	
		Scanner in = new Scanner(System.in);
		String money = in.nextLine();


			String[] han1 = {"","ÀÏ","ÀÌ","»ï","»ç","¿À","À°","Ä¥","ÆÈ","±¸"};
			String[] han2 = {"","½Ê","¹é","Ãµ"};
			String[] han3 = {"","¸¸","¾ï","Á¶","°æ"};

			StringBuffer result = new StringBuffer();
			int len = money.length();
			for(int i=len-1; i>=0; i--){
				result.append(han1[Integer.parseInt(money.substring(len-i-1, len-i))]);
				if(Integer.parseInt(money.substring(len-i-1, len-i)) > 0)
					result.append(han2[i%4]);
				if(i%4 == 0){
					result.append(han3[i/4]);
				    result.append(" ");
				}
			}
			
			System.out.println(result + "¿ø");
	
	}
	
}
