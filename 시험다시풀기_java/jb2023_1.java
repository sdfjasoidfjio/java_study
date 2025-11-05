package 시험다시풀기_java;

import java.util.*;

public class jb2023_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.print("Enter a radius(-1 to exit) >> ");
				int n = sc.nextInt();
				sc.nextLine();// int 다음에 문자열을 받을 땐 nextLine()으로 버퍼를 비워줘야 함

				if (n == -1) {
					System.out.println("Program is ended.");
					break;
				}
				System.out.print("Enter a operator(# to area, @ to length) >> ");
				char op = sc.next().charAt(0);

				final float PI = 3.14f;
				float area, length;

				switch (op) {
					case '#':
						area = PI * (n * n);
						System.out.println("Circle: radius = " + n + " Area size = " + area);
						break;
					case '@':
						length = 2 * PI * n;
						System.out.println("Circle: radius = " + n + " Length size = " + length);
						break;
					default:
						System.out.println("Wrong operator!!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Do not enter float");
				sc.nextLine(); // 버퍼 비워줘야 함
			}
		} while (true);

		sc.close();
	}
}
