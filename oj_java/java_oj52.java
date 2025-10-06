package oj_java;

import java.util.Scanner;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("Person:" + name);
    }
}

class Student extends Person {
    int grade;

    public Student(String name, int grade) {
        super(name);
        this.grade = grade;
    }

    public void info() {
        System.out.println("Student: " + name + ", " + grade);
    }
}

public class java_oj52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[3];
        for (int i = 0; i < 3; i++) {
            String name = sc.next();
            int grade = sc.nextInt();
            students[i] = new Student(name, grade);
        }

        for (int i = 0; i < 3; i++) {
            students[i].info();
        }

        sc.close();
    }
}
