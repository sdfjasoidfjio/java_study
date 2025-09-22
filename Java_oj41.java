
/*Main 클래수 위에 다음과 같은 요소들을 포함하는 Book 클래스를 작성하시오.
- 멤버 변수: title(String), author(String)
- 생성자: title과 author를 받아 초기화
- 메소드: showInfo() → “Title: ○○, Author: ○○” 형식으로 출력

1. main 메소드에서 Book 객체 배열을 길이 3으로 선언하고, 3권의 책 정보를 직접 생성자에 넣어 초기화한 후, 반복문을 이용해 모든 책의 정보를 출력하시오.

출력 예시 1)
Title: Java Programming, Author: A
Title: Data Structure, Author: B
Title: Operating System, Author: C */
import java.util.Scanner;

class Book {
    String title, author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void showInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }

}

public class Java_oj41 {

    public static void main(String[] args) {
        Book[] book = new Book[3];

        Scanner scanner = new Scanner(System.in);

        book[0] = new Book("Java Programming", "A");
        book[1] = new Book("Data Structure", "B");
        book[2] = new Book("Operating System", "C");

        for (int i = 0; i < book.length; i++) {
            book[i].showInfo();
        }

        scanner.close();
    }
}
