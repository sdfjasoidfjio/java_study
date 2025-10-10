// 문제 1 — 생성자와 super()

// Person 클래스를 만들고, 이름(name)과 나이(age)를 멤버 변수로 선언하시오.
// 이 클래스를 상속받는 Student 클래스를 만들어 학번(studentId) 멤버를 추가하시오.
// 두 클래스 모두 생성자를 통해 변수를 초기화하도록 하고,
// Student 생성자에서는 super()를 이용해 Person의 생성자를 호출하시오.
// 마지막으로 info() 메서드를 만들어
// "이름: OOO, 나이: OO, 학번: OOOO" 형식으로 출력되게 하시오.

// 주석 : 범위 드래그 + Ctrl + k + c
// 해제 : 범위 드래그 + Ctrl + k + u

package prac_java;

import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    int studentId;

    Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;

    }

    public void info() {
        System.out.println("이름: " + name + ", 나이: " + age + ", 학번: " + studentId);
    }
}

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int age;
        int studentId;

        name = sc.next();
        age = sc.nextInt();
        studentId = sc.nextInt();

        Student s = new Student(name, age, studentId);
        s.info();

        sc.close();
    }
}
