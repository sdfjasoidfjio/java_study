import java.util.*;

public class Q2_2023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter a radius(-1 to exit) >>");
                int r = sc.nextInt();
                sc.nextLine();// 입력버퍼 비워주기 Int()나 float()다음에 바로 Line()을 받으면
                              // 변수에 \n가 들어감
                if (r == -1) {
                    System.out.println("Program is ended");
                    break;
                }
                System.out.print("Enter a operator(# to area, @ to length) >>");
                String op = sc.next();
                final float PI = 3.14f;// double값을 float값으로 바꿔서 넣어주기
                float area, length;
                switch (op) {
                    case "#":
                        area = r * r * PI;
                        System.out.println("Circle: radius = " + r + " Area size = " + area);
                        break;
                    case "@":
                        length = 2 * PI * r;
                        System.out.println("Circle: radius = " + r + " Length = " + length);
                        break;
                    default:
                        System.out.println("Wrong operator!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Do not enter float");
                sc.nextLine(); // 입력버퍼에 전에 입력했던 값이 그대로 남아있기 때문에 비워주는 것
            }
        } while (true);
        sc.close();
    }
}