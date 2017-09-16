package hashmapprac;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class good {


	
	public static void main(String args[]) throws IOException{
		
		System.out.println("--------------------------------------");
		System.out.println("��ȭ��ȣ ���� ���α׷��� �����մϴ�. ���Ϸ� �������� �ʽ��ϴ�.");
		System.out.println("--------------------------------------");
		
		HashMap<String,good2> list = new HashMap<String,good2>();
		Scanner input = new Scanner(System.in);
		
		while(true){
			
			System.out.println("������� ��ȭ��ȣ�ο� ��ϵ� ����� �� : "+list.size());
			System.out.print("����:0  ����:1  ã��:2  ��ü����:3  ����:4 >> ");
			String choice = input.nextLine();

			
			if(choice.equals("0")){
				System.out.print("�̸�>>");
				String nam = input.nextLine();
				System.out.print("�ּ�>>");
				String addr = input.nextLine();
				System.out.print("��ȣ>>");
				String numb = input.nextLine();
				
				list.put(nam,new good2(addr,numb));
			}
			else if(choice.equals("1")){
				System.out.print("������ �̸�>>");
				String nam = input.nextLine();
				list.remove(nam);
				System.out.println("���� �Ǿ����ϴ�.");
			}
			else if(choice.equals("2")){
				System.out.print("�˻��� �̸�>>");
				String nam = input.nextLine();
				good2 a = list.get(nam);
				System.out.println(nam + " " + a.address + " " + a.pnum);	
			}
			else if(choice.equals("3")){
				Set<String> keys = list.keySet();
				Iterator<String> it = keys.iterator();
				while(it.hasNext()){
					String key = it.next();
					good2 value = list.get(key);
					System.out.println(key + " " + value.address + " " + value.pnum);	
				}
			}
			else if(choice.equals("4")){
				break;
			}
			else if(choice.equals("5")){
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("tmp.txt")));
				for (String key : list.keySet()){
					good2 val = list.get(key);
					bw.write("�̸�: "+key+"��ȭ��ȣ: "+val.pnum+"�ּ�: "+val.address);
					bw.newLine();
				}
			}
			
		}
		
		
		
	}
	
}
