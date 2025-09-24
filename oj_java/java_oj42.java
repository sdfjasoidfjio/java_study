package oj_java;
/*Main 클래스 위에 다음과 같은 요소들을 포함하는 Student 클래스를 작성하시오.
- 멤버 변수: name(String), score(int)
- 생성자: name과 score를 받아 초기화
- 메소드: showInfo() → “Name: ○○, Score: ○○” 형식으로 출력

1. main 메소드에서 Student 객체 배열을 길이 3으로 선언하고, 학생 3명의 정보를 저장한 후, showInfo 함수를 호출하여 모든 학생의 정보를 출력
2. 최고 점수 학생의 이름과 점수를 출력

출력 예시 1)
Name: A, Score: 85
Name: B, Score: 92
Name: C, Score: 78
The student with the best score (name: B, score: 92)*/

import java.util.Scanner;

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Score: " + score);
    }
}

public class java_oj42 {
    public static void main(String[] args) {
        Student[] student = new Student[3];

        Scanner scanner = new Scanner(System.in);

        student[0] = new Student("A", 85);
        student[1] = new Student("B", 92);
        student[2] = new Student("C", 78);

        for (int i = 0; i < student.length; i++) {
            student[i].showInfo();
        }

        Student best_score = student[0];
        for (int i = 1; i < student.length; i++) {
            if (student[i].score > best_score.score) {
                best_score = student[i];
            }
        }

        System.out.print(
                "The student with the best score (name: " + best_score.name + ", score: " + best_score.score + ")");

        scanner.close();
    }
}
