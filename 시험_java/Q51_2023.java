import java.util.*;

class Point {
    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void show() {
        System.out.print("(" + x + "," + y + ")");
    }

    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

abstract class Shape {
    private String color;

    Shape(String color) {
        this.color = color;
    }

    void show() {
        System.out.println("(c:" + color + ")");
    }

    abstract void move(int dx, int dy);
}

class Rect extends Shape {
    private Point p1;
    private Point p2;

    // 문제: 생성자 및 필요한 메소드 구현
    Rect(int x1, int y1, int x2, int y2, String color) {
        super(color);
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    void show() {
        System.out.print("Rect:");
        p1.show();
        p2.show();
        super.show();
    }

    void move(int dx, int dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
    }
}

class Circle extends Shape {
    private Point center;
    private int radius;

    // 문제:
    Circle(int x, int y, int radius, String color) {
        super(color);
        this.center = new Point(x, y);
        this.radius = radius;
    }

    // 문제 2) show() 재정의
    void show() {
        System.out.print("Circle:");
        center.show();
        System.out.print("(r:" + radius + ")");
        super.show();
    }

    // 문제 3) move() 재정의
    void move(int dx, int dy) {
        center.move(dx, dy);
    }
}

public class Q51_2023 {
    static Shape[] shuffleShapes(Scanner scan) {
        Shape grps[] = {
                // 사각형의 왼쪽 위쪽 점 좌표는 x1, y1 오른쪽 아래쪽 점 좌표는 x2, y2이다.
                // 사각형: x1, y1, x2, y2, color
                new Rect(10, 45, 20, 30, "Red"), new Circle(55, 15, 7, "Yellow"),
                new Rect(50, 25, 60, 40, "Black"), new Circle(65, 35, 5, "Blue"),
        };
        System.out.print("start index[0-99]?");
        int i = scan.nextInt() % grps.length;
        int j = (i + 3) % grps.length;
        Shape tmp = grps[i];
        grps[i] = grps[j];
        grps[j] = tmp;
        return grps;
    }

    public static void mainMenu(Scanner scan) {
        Shape shapes[] = shuffleShapes(scan);

        while (true) {
            System.out.print("\n0.exit 1.show 2.move+ 3.move- >> ");
            int input = scan.nextInt();
            if (input == 0)
                break;
            switch (input) {
                case 1:
                    for (Shape p : shapes)
                        p.show();
                    break;
                case 2:
                    for (Shape p : shapes) {
                        p.move(100, 1000);
                        p.show();
                    }
                    break;
                case 3:
                    for (Shape p : shapes) {
                        p.move(-100, -1000);
                        p.show();
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        mainMenu(scan);
        scan.close();
    }
}
