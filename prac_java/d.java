package prac_java;

import java.util.*;

public class d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        double celsius;
        while(true) {
            System.out.print("Enter temperature in Celsius (-999 to exit): ");
            try {
                celsius = sc.nextDouble(); // 섭씨 온도 입력받기
                if(celsius == (-999)) { // -999 입력 시 종료
                    System.out.println("Program terminated.");
                    break;
                }
                double fahrenheit = celsius * 9 / 5 + 32; // 변환 계산
                System.out.printf("Fahrenheit: %.2f\n", fahrenheit);
            } catch(InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.nextLine(); // 입력 버퍼 비우기
            }
        }
        sc.close(); // Scanner 닫기
    }
}