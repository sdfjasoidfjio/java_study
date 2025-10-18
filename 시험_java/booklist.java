import java.util.*;

class Book {
    String title, author;
    int price;

    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void showInfo() {
        System.out.println(title + " / " + author + " / " + price);
    }
}

public class booklist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of book: ");
        int num = sc.nextInt();
        Book[] B = new Book[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter title, author, price >> ");
            String title = sc.next();
            String author = sc.next();
            int price = sc.nextInt();
            B[i] = new Book(title, author, price);
        }

        System.out.println("[Book List]");
        for (Book s : B) {
            s.showInfo();
        }

        Book first = B[0];
        Book last = B[0];

        for (int i = 1; i < num; i++) {
            if (first.price < B[i].price) {
                first = B[i];
            }
        }
        for (int i = 1; i < num; i++) {
            if (last.price > B[i].price) {
                last = B[i];
            }
        }
        System.out.println();

        System.out.print("Most expensive book: ");
        first.showInfo();
        System.out.print("Cheapest book: ");
        last.showInfo();
    }
}