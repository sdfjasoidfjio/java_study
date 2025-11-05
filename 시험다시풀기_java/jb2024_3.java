package 시험다시풀기_java;

import java.util.*;

import 수업_java.lec2;

class Library {
    private static int totalBooks = 0; // 도서관의 총 책 수를 저장하는 변수 초기화.
    private static int totalMembers = 0; // 도서관의 총 회원 수를 저장하는 변수 초기화.
    // 기본 생성자 (totalBooks를 10 증가시키고 totalMembers를 1 증가시킴)

    public Library() {
        totalBooks += 10;
        totalMembers += 1;
    }

    // 사용자 정의 책 수와 회원 수를 설정하는 오버로드된 생성자
    public Library(int totalBooks, int totalMembers) {
        this.totalBooks = totalBooks;
        this.totalMembers = totalMembers;
    }

    // 책을 대출하는 메서드
    public static void borrowBook() {
        if (totalBooks > 0) {
            totalBooks--;
            System.out.println("You borrowed a book. Books left: " + totalBooks); // 대출 성공 메시지 출력.
        } else {
            System.out.println("No books left to borrow."); // 대출할 책이 없다는 메시지 출력.
        }
    }

    // 책을 반납하는 메서드
    public static void returnBook() {
        totalBooks++;
        System.out.println("You returned a book. Books available: " + totalBooks); // 반납 성공 메시지 출력.
    }

    // 도서관의 현재 상태를 출력하는 메서드
    public static void Info() {
        System.out.printf("books : %d\nmembers : %d\n", totalBooks, totalMembers);
    }
}

public class jb2024_3 {
    public static void main(String[] args) {
        // 사용자 입력을 받기 위한 Scanner 객체 생성.
        Scanner sc = new Scanner(System.in);
        // 기본 값으로 도서관 객체 생성
        Library lib = new Library();
        // 사용자 정의 값으로 또 다른 도서관 생성
        System.out.print("Enter the number of books: "); // 사용자에게 책 수 입력 요청.
        int books = sc.nextInt();
        System.out.print("Enter the number of members: "); // 사용자에게 회원 수 입력 요청.
        int members = sc.nextInt();

        Library lib2 = new Library(books, members);// 오버로드된 생성자를 사용하여 사용자 정의 도서관 객체 생성.

        // 메뉴 기반 시스템
        while (true) {
            System.out.println("\n1. Borrow Book"); // 대출 옵션 출력.
            System.out.println("2. Return Book"); // 반납 옵션 출력.
            System.out.println("3. Library Status"); // 도서관 상태 옵션 출력.
            System.out.println("4. Exit"); // 종료 옵션 출력.
            System.out.print("Choose an option: "); // 옵션 선택 요청.
            int num = sc.nextInt();
            switch (num) {
                case 1: // 대출 옵션 선택 시
                    Library.borrowBook(); // 책 대출 메서드 호출.
                    break;
                case 2: // 반납 옵션 선택 시
                    Library.returnBook(); // 책 반납 메서드 호출.
                    break; // switch 종료.
                case 3: // 도서관 상태 옵션 선택 시
                    Library.Info(); // 도서관 상태 메서드 호출.
                    break;
                case 4: // 종료 옵션 선택 시
                    System.out.println("Exiting the system."); // 종료 메시지 출력.
                    sc.close();// Scanner 객체 닫기.
                    return; // 메인 메서드 종료.
                default: // 잘못된 옵션 입력 시
                    System.out.println("Invalid option. Please try again."); // 잘못된 옵션 메시지 출력.
            }
        }
    }
}
