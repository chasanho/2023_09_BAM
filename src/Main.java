import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);
		int lastArticleId = 0;

		List<Article> articles = new ArrayList<Article>();

		while (true) {

			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("너 명령어 입력 안했어");
				continue;
			}

			if (command.equals("exit")) {
				break;
			}

			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
				} else {
					System.out.println("번호   /    제목   ");
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf(" %d     /   %s  \n", article.id, article.title);
					}
				}

			}else if (command.equals("sign up")) {
				
				System.out.println("id:");
				String logId = sc.nextLine();
				System.out.println("pw:");
				String logPw = sc.nextLine();
				
				Article article = new Article(logId,logPw);
				articles.add(article);
				
				System.out.println("회원가입이 완료되셨습니다.축하합니다아아아");
				
				
				

			} 
			else if (command.equals("article write")) {
				int id = lastArticleId + 1;
				String regDate = Util.getNow();
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, regDate, title, body);
				articles.add(article);

				System.out.printf("%d번글이 생성되었습니다.\n", id);
				lastArticleId++;
			} else if (command.startsWith("article detail")) {

				String[] commandDiv = command.split(" "); // article detail 1

				int id = Integer.parseInt(commandDiv[2]);

				boolean found = false;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						found = true;
						System.out.println("번호 : " + article.id);
						System.out.println("날짜 : " + article.regDate);
						System.out.println("제목 : " + article.title);
						System.out.println("내용 : " + article.body);
						break;
					}
				}

				if (found == false) {
					System.out.printf("%d번 게시물은 없어\n", id);
				}

			} else if (command.startsWith("article delete")) {

				String[] commandDiv = command.split(" "); // article delete 1

				int id = Integer.parseInt(commandDiv[2]);

				boolean found = false;
				Article foundArticle = null;
				int foundIndex = -1;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						found = true;
						foundArticle = article;
						foundIndex = i;
						break;
					}
				}

				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 없어\n", id);
					continue;
				}
				
				articles.remove(foundIndex);
				System.out.println(id + "번 글을 삭제했어");

			} else {
				System.out.println("존재하지 않는 명령어입니다");
				continue;
			}
		}

		System.out.println("== 프로그램 종료 ==");

		sc.close();
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String body;
	String logId;
	String logPw;
	
	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

	Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
	
	Article(String logId,String logPw) {
		this.logId = logId;
		this.logPw = logPw;
	}
}