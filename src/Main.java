import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		
		
		Scanner sc = new Scanner(System.in);
		
	    while(true) {
	    	System.out.println("명령어 )");
	    	String cmd = sc.nextLine();
	    	
	    	
	    	if(cmd.equals("article list")) {
	    		System.out.println("게시글이 없습니다");
	    	}else if(cmd.equals("article write1")) {
	    		System.out.println("제목:");
	    		String cme = sc.nextLine();
	    		System.out.println("내용:");
	    		String cmc = sc.nextLine();
	    		System.out.println("1번글이 생성되었습니다");
	    		
	    	}else if (cmd.equals("article write2")) {
	    		System.out.println("제목:");
	    		String cmz = sc.nextLine();
	    		System.out.println("내용:");
	    		String cmw = sc.nextLine();
	    		System.out.println("2번글이 생성되었습니다");
	    	}else if (cmd.equals("exit")) {
	    		break;
	    	}else {
	    		System.out.println("존재하지 않는 명령어입니다");
	    	}
	    }System.out.println("프로그램 끝");

	}
}
