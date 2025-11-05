import java.util.*;

public class Q1_2023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                // 반지름 입력받기
                // 입력받은 반지름이-1이면 반복구문 벗어나기
                System.out.print("Enter a radius(-1 to exit) >> ");
                int n = sc.nextInt();
                sc.nextLine();

                if (n == -1) {
                    System.out.println("Program is ended.");
                    break;
                }
                System.out.print("Enter a operator(# to area, @ to length) >> ");
                String op = sc.nextLine();
                final float PI = 3.14f;
                float area, length;
                // 문자 변수를 선언하여 연산자 입력받기
                // float 타입으로 상수 기호 PI 선언하기
                // float 타입으로 area, length 변수 선언하기
                // switch 구문으로 연산자 처리하기
                switch (op) {
                    case "#": // 면적 계산하기
                        area = PI * (float) (n * n);
                        System.out.printf("Circle: radius = %d area = %.2f\n", n, area);
                        break;
                    case "@": // 둘레 계산하기
                        length = 2 * PI * (float) n;
                        System.out.printf("Circle: radius = %d length = %.2f\n", n, length);
                        break;
                    default:
                        System.out.println("Wrong operator!!");
                }

            } catch (InputMismatchException e) {
                // 입력 타입 오류 처리하기
                System.out.println("Do not enter float");
                sc.nextLine();
            }
        } while (true);
        sc.close();
    }
}
