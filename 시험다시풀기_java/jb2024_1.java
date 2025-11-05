package 시험다시풀기_java;

import java.util.Scanner;

public class jb2024_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력받기 위한 스캐너 객체 생성
        double weight, height, min_weight, max_weight;
        float bmi;
        String name;

        System.out.print("Name : ");
        name = sc.next(); // 이름 입력받기
        System.out.print("Weight(kg) : ");
        weight = sc.nextDouble(); // 몸무게 입력받기
        System.out.print("Height(cm) : ");
        height = sc.nextDouble(); // 키 입력받기
        bmi = (float) (weight / ((height / 100) * (height / 100))); // bmi 계산하기

        System.out.println("The BMI value of " + name + " is " + String.format("%.2f", bmi));
        min_weight = 18.5 * ((height / 100) * (height / 100));
        max_weight = 23 * ((height / 100) * (height / 100));
        int n = 0;
        if (bmi < 18.5) {
            System.out.println("You are Underweight");
            n++;
        } else if (bmi < 23) {
            System.out.println("You are Normal");
        } else {
            System.out.println("Your are over weight");
            n++;
        }

        if (n == 1) {
            System.out.printf("You need to maintain your weight between %.1f kg and %.1f kg\n", min_weight, max_weight);
        }
    }
}
