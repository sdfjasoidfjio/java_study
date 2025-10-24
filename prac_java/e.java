package prac_java;
/******************************************************************************
 * [문제 2]
 ******************************************************************************/
// Rectangle 클래스를 만들어 가로와 세로를 입력받고 넓이와 둘레를 계산하는 프로그램을 완성하시오.
//
// **요구사항**
// 1) Rectangle 클래스는 width, height 두 필드를 가진다.
// 2) 생성자를 통해 초기화하며, 음수 입력 시 0으로 설정한다.
// 3) getArea(), getPerimeter() 메서드를 구현한다.
// 4) main에서는 객체를 생성하고 정보를 출력한다.

import java.util.*;

class Rectangle2 {
    private double width;
    private double height;

    public Rectangle2(double w, double h) {
        if (w < 0 || h < 0) { // 음수 검사
            width = 0;
            height = 0;
        } else {
            width =w;
            height = h;
        }
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width*2)+(height*2);
    }

    public void show() {
        System.out.printf("Width: %.1f, Height: %.1f, Area: %.1f, Perimeter: %.1f\n", width, height, getArea(), getPerimeter());
    }
}

public class e {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width and height: ");
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        Rectangle2 r = new Rectangle2(w, h);
        r.show();
        sc.close();
    }
}

