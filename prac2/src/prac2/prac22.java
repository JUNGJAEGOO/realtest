package prac2;

import java.util.ArrayList;

public class prac22{
public static void main(String[] args)
{
	ArrayList<String> linklist = new ArrayList<String>();
	ArrayList<String> linklist2 = new ArrayList<String>();
	
	linklist.add("a");
	linklist.add("b");
	linklist.add("c");
	linklist.add("d");
	linklist.add("e");
	linklist.add("f");
	linklist.add("g");
	linklist.add("h");
	linklist.add("i");
	linklist.add("j");
	linklist.add("k");
	

	System.out.println(linklist);
	System.out.println(linklist.size());
	int max = linklist.size()/3;
	System.out.println(max);
	
	for (int i=0;i<max;i++){
	String tmp1 = linklist.get(3*i);
	String tmp2 = linklist.get((3*i)+1);
	String tmp3 = linklist.get((3*i)+2);
	linklist2.add(tmp3);
	linklist2.add(tmp1);
	linklist2.add(tmp2);
	}
	linklist2.add(linklist.get(9));
	linklist2.add(linklist.get(10));
	
	System.out.println(linklist2);
	
}
}
