package baekjoon_java;

import java.util.*;

// 백준 2557
/*
 * public class Main {
 * public static void main(String[] args) {
 * System.out.println("hello world");
 * }
 * }
 */

// 백준 1000, 1001, 10998, 1008
/*
 * public class Main {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in); //import java.util.Scanner필수
 * int a, b;
 * a = sc.nextInt();//정수를 입력받을 때
 * b = sc.nextInt();
 * System.out.print(a + b);//출력하기(-, *, x, /를 출력하고 싶으면 여기 부호만 바꾸면 됨)
 * }
 * }
 */

// 백준 10926
/*
 * public class Main {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * String name;
 * name = sc.next();
 * 
 * System.out.println(name + "??!");
 * 
 * sc.close();
 * }
 * }
 */

// 백준 18108
/*
 * public class Main {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * 
 * int year;
 * year = sc.nextInt();
 * 
 * System.out.println(year - 543);//2025년을 불기연도로 바꾸면 2568년이라고 하네요
 * }
 * }
 */

// 3003
/*
 * public class Main {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * int K, Q, R, B, N, P;
 * K = sc.nextInt();
 * Q = sc.nextInt();
 * R = sc.nextInt();
 * B = sc.nextInt();
 * N = sc.nextInt();
 * P = sc.nextInt();
 * 
 * System.out.print(1 - K);
 * System.out.print(1 - Q);
 * System.out.print(2 - R);
 * System.out.print(2 - B);
 * System.out.print(2 - N);
 * System.out.print(8 - P);
 * }
 * }
 */

// 10430
/*
 * public class Main {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * int a, b, c;
 * 
 * a = sc.nextInt();
 * b = sc.nextInt();
 * c = sc.nextInt();
 * 
 * System.out.println((a + b) % c);
 * System.out.println(((a % c) + (b % c)) % c);
 * System.out.println((a * b) % c);
 * System.out.println(((a % c) * (b % c)) % c);
 * }
 * }
 */

// 2588
public class day1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a, b;

        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a * (b % 100 % 10));
        System.out.println(a * (b % 100 / 10));
        System.out.println(a * (b / 100));
        System.out.println(a * b);

        sc.close();
    }
}
