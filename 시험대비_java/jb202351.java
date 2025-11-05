import java.util.*;

// 한점의 좌표 값
class Point { // 주의: 클래스를 절대 수정하지 마라.
    private int x, y; // 한점의 xy 좌표

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void show() {
        System.out.print("(" + x + "," + y + ")");
    }

    // 점의 x,y 좌표를 각각 dx,dy만큼 이동한다.
    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

abstract class Shape { // 주의: 클래스를 절대 수정하지 마라.
    private String color;

    Shape(String color) {
        this.color = color;
    }

    void show() {
        System.out.println("(c:" + color + ")");
    }

    // 그래픽 객체의 x,y 좌표를 각각 dx,dy만큼 이동한다.
    abstract void move(int dx, int dy);
}

// 문제: Shape 클래스 상속하여 Rect 클래스를 작성하라.
class Rect extends Shape {
    private Point p1; // 왼쪽 위쪽 점 좌표 x1, y1
    private Point p2; // 오른쪽 아래쪽 점 좌표 x2, y2
    // 문제: 생성자 및 필요한 멤버 메소드 구현
    //

    Rect(int x1, int y1, int x2, int y2, String color) {
        super(color);
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public void show() {
        System.out.print("Rect:");
        p1.show();
        p2.show();
        super.show();
    }

    public void move(int dx, int dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
    }
}

// 문제: Shape 클래스 상속하여 Circle 클래스를 작성하라.
class Circle extends Shape {
    private Point center; // 원점 좌표 x, y
    private int radius; // 반지름
    // 문제: 생성자 및 필요한 멤버 메소드 구현
    //

    Circle(int x, int y, int radius, String color) {
        super(color);
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public void show() {
        System.out.print("Circle:");
        center.show();
        System.out.print("(r:" + radius + ")");
        super.show();
    }

    public void move(int dx, int dy) {
        center.move(dx, dy);
    }
}

// 주의: 아래 클래스들은 절대 수정하지 마라.
public class jb202351 {

    // 이 함수 코드를 이해하지 못해도 상관없음
    static Shape[] shuffleShapes(Scanner scan) {
        Shape grps[] = {
                // 사각형의 왼쪽 위쪽 점 좌표는 x1, y1 오른쪽 아래쪽 점 좌표는 x2, y2이다.
                // 사각형: x1, y1, x2, y2, color
                new Rect(10, 45, 20, 30, "Red"),
                // 원: 원점의 x, y, radius, color
                new Circle(55, 15, 7, "Yellow"),
                new Rect(50, 25, 60, 40, "Black"),
                new Circle(65, 35, 5, "Blue"),
        };

        // grps[] 원소들의 순서를 바꿈;
        System.out.print("start index[0~99]? ");
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
                        p.move(100, 1000); // x와 y 좌표 값을 각각 +100, +1000씩 이동하라.
                        p.show();
                    }
                    break;

                case 3:
                    for (Shape p : shapes) {
                        p.move(-100, -1000); // x와 y 좌표 값을 각각 -100, -1000씩 이동하라.
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
