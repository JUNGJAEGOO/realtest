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
		System.out.println("전화번호 관리 프로그램을 시작합니다. 파일로 저장하지 않습니다.");
		System.out.println("--------------------------------------");
		
		HashMap<String,good2> list = new HashMap<String,good2>();
		Scanner input = new Scanner(System.in);
		
		while(true){
			
			System.out.println("현재까지 전화번호부에 등록된 사람의 수 : "+list.size());
			System.out.print("삽입:0  삭제:1  찾기:2  전체보기:3  종료:4 >> ");
			String choice = input.nextLine();

			
			if(choice.equals("0")){
				System.out.print("이름>>");
				String nam = input.nextLine();
				System.out.print("주소>>");
				String addr = input.nextLine();
				System.out.print("번호>>");
				String numb = input.nextLine();
				
				list.put(nam,new good2(addr,numb));
			}
			else if(choice.equals("1")){
				System.out.print("삭제할 이름>>");
				String nam = input.nextLine();
				list.remove(nam);
				System.out.println("삭제 되었습니다.");
			}
			else if(choice.equals("2")){
				System.out.print("검색할 이름>>");
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
					bw.write("이름: "+key+"전화번호: "+val.pnum+"주소: "+val.address);
					bw.newLine();
				}
			}
			
		}
		
		
		
	}
	
}
