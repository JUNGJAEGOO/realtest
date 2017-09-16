import java.util.Scanner;

public class rpc {

	public static void main (String args[]){
		

		Scanner scan = new Scanner(System.in);
		String input;
		
		System.out.println("가위,바위,보 중 하나를 입력 하시오.");

		int num = 3;
		
		while(true)
		{
			
		input = scan.nextLine();
			
		if(input.equals("가위")){
			num = 0;
			break;
		}
		else if(input.equals("바위")){
			num = 1;
			break;
		}
		else if(input.equals("보")){
			num = 2;
			break;
		}
		else {
			System.out.println("제대로 다시 입력 해주세요.");
		}
		
	    }
		
		int com;
		String trancom;
		com = (int)(Math.random()*3);
		
		if(com == 0)
		{
			trancom = "가위";
		}
		else if(com == 1)
		{
			trancom = "바위";
		}
		else
		{ trancom = "보";}
		
		System.out.println("콤퓨타의 선택은 "+ trancom);
		if(num == com){
			System.out.println("비겼습니다");
		}
		else if(num == 0 && com == 1){
			System.out.println("졌습니다");
		}
		else if(num == 0 && com == 2){
			System.out.println("이겼습니다");
		}
		else if(num == 1 && com == 0){
			System.out.println("이겼습니다");
		}
		else if(num == 1 && com == 2){
			System.out.println("졌습니다");
		}
		else if(num == 2 && com == 0){
			System.out.println("졌습니다");
		}
		else if(num == 2 && com == 1){
			System.out.println("이겼습니다");
		}
		
}
}
