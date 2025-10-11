// 문제 3 — 다형성과 오버라이딩 심화
// 📘 문제 설명

// Shape 클래스를 만들고 area() 메서드를 선언하시오.
// Circle, Rectangle, Triangle이 상속받아 각각의 넓이를 계산하여 출력하시오.
// main()에서 Shape 배열을 만들어 세 객체를 담고, for문으로 area()를 호출하시오.

package prac_java;

import java.util.*;

class Shape {
    void area() {
    }
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    void area() {
        System.out.println("원의 넓이: " + 3.14 * (r * r));
    }
}

class Rectangle extends Shape {
    double w, h;

    Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    void area() {
        System.out.println("직사각형의 넓이: " + w * h);
    }
}

class Triangle extends Shape {
    double b, hei;

    Triangle(double b, double hei) {
        this.b = b;
        this.hei = hei;
    }

    void area() {
        System.out.println("삼각형의 넓이: " + 0.5 * b * hei);
    }
}

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 원
        double r, w, h, b, hei;
        r = sc.nextDouble();
        w = sc.nextDouble();
        h = sc.nextDouble();
        b = sc.nextDouble();
        hei = sc.nextDouble();

        Shape[] s = {
                new Circle(r),
                new Rectangle(w, h),
                new Triangle(b, hei)
        };

        for (Shape i : s) {
            i.area();
        }
        sc.close();

    }
}

// 이 방법 말고 변수 받는거와 계산을 아예 클래스 메소드 안으로 넣어서 단순화 하는 방법도 있음