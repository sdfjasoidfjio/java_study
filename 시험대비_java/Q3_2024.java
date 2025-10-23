import java.util.*;

class Library{
    private static int totalBooks = 0;
    private static int totalMembers = 0;

    public Library(){
        totalBooks += 10;
        totalMembers += 1;
    }

    public Library(int totalBooks, int totalMembers){
        this.totalBooks += totalBooks;
        this.totalMembers += totalMembers;
    }

    public void borrowBook(){
        if (totalBooks > 0 ){
            totalBooks --;
            System.out.println("You borrowed a book. Books left: "+ totalBooks);
        }else{
            System.out.println("No books left to borrow.");
        }
    }
    public void returnBook(){
        totalBooks ++;
         System.out.println("You returned a book. Books available: " + totalBooks);
    }
    public void Info(){
        System.out.println("Books : " + totalBooks + "\nMember: " + totalMembers);
    }
}
public class Q3_2024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib1 = new Library();
        
        System.out.print("Enter the number of books: ");
        int books = sc.nextInt();
        System.out.print("Enter the number of members: ");
        int members = sc.nextInt();
        Library lib2 = new Library(books, members);

        while (true) { 
            System.out.println("\n1. Borrow Book");
            System.out.println("2. Return Book"); 
            System.out.println("3. Library Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int num = sc.nextInt();

            switch(num){
                case 1:
                    lib2.borrowBook();
                    break;
                case 2:
                    lib2.returnBook();
                    break;
                case 3:
                    lib2.Info();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
