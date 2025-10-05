package 수업_java;

import java.util.*;

//5-1: 클래스 상속 만들기
class Point {
    private int x, y;

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}

class ColorPoint extends Point {
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }
}

class ColorPointEx {
    public static void main(String[] args) {
        Point p = new Point();
        p.set(1, 2);
        p.showPoint();

        ColorPoint cp = new ColorPoint();
        cp.set(3, 4);
        cp.setColor("red");
        cp.showColorPoint();
    }
}

// 5-2: 상속 관계에 있는 클래스 간 멤버 접근
class Person {
    private int weight;
    int age;
    protected int height;
    public String name;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Student extends Person {
    public void set() {
        age = 30;
        name = "홍길동";
        height = 175;
        setWeight(99);
    }
}

class InheritanceEx {
    public static void main(String[] args) {
        Student s = new Student();
        s.set();
    }
}

// 5-3 super()를 활용한 ColorPoint 작성
class Point1 {
    private int x, y;

    public Point1() {
        this.x = this.y = 0;
    }

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}

class ColorPoint1 extends Point1 {
    private String color;

    public ColorPoint1(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }
}

class SuperEx1 {
    public static void main(String[] args) {
        ColorPoint1 cp = new ColorPoint1(5, 6, "blue");
        cp.showColorPoint();
    }
}