package 시험다시풀기_java;

import java.util.*;

public class jb2024_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력받기 위한 스캐너 객체 생성. 객체변수명은 scanner 이다.
        System.out.print("Number of classes : ");
        int numberOfClasses = sc.nextInt(); // 분반 수 입력받기. 변수명은 numberOfClasses 이다.
        int[][] grades = new int[numberOfClasses][];// 2차원 정수형 배열 선언하고 생성하기. 변수명은 grades 이다.

        for (int i = 0; i < grades.length; i++) { // grades 배열 길이만큼 반복
            System.out.print("Number of student of class " + (i + 1) + ": "); // 학생 수 입력받기 위한 입력 안내 구문 출력
            int numberOfStudents = sc.nextInt();// 학생 수 입력받기. 변수명은 numberOfStudents 이다.
            grades[i] = new int[numberOfStudents]; // 학생 성적을 저장하기 위한 배열 생성하기
        }

        int no = 1;
        for (int[] item : grades) { // for-each 구문으로 grades 배열의 원소 가져오기. 원소저장 변수명은 item 이다.
            System.out.println("Class " + no++ + " ==> ");
            for (int i = 0; i < item.length; i++) { // item 배열의 길이만큼 반복
                while (true) {
                    try {
                        System.out.print((i + 1) + "th student's score (0-100): ");
                        int score = sc.nextInt();

                        if (score < 0 || 100 < score) {
                            System.out.println("Score should be between 0 and 100");
                        } else {
                            item[i] = score;
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invaild input. Enter integer number.");
                        sc.nextLine();
                    }
                }
            }
        }

        // 클래스별 평균 성적 계산
        for (int[] item : grades) { // for-each 구문으로 grades 배열의 원소 가져오기. 원소저장 변수명은 item 이다.
            int sum = 0; // 분반 학생들의 성적 총합을 구하는 구문 작성하기. 성적 합계를 저장하는 변수명은 sum 이다.
            for (int i = 0; i < item.length; i++) {
                sum += item[i];
            }

            double average = sum / item.length; // 평균성적 구하기
            System.out.printf("Average score: %.2f\n", average);
        }
    }
}
