package 수업_java;

import java.util.*;

//4-1: Circle 클래스의 객체 생성 및 활용
class Circle {
    int radius;
    String name;

    public Circle() {
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        Circle pizza;
        pizza = new Circle();
        pizza.radius = 10;
        pizza.name = "자바피자";
        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area);

        Circle donut = new Circle();
        donut.radius = 2;
        donut.name = "자바도넛";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);
    }
}

// 4-2: Rectanle 클래스 만들기 연습
class Rectangle {
    int width;
    int height;

    public int getArea() {
        return width * height;
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Scanner sc = new Scanner(System.in);
        System.out.println(">> ");

        rect.width = sc.nextInt();
        rect.height = sc.nextInt();

        System.out.println("사각형의 면적은 " + rect.getArea());

        sc.close();
    }
}

// 4-3: 두 개의 생성자를 가진 Circle 클래스
class Circle2 {
    int radius;
    String name;

    public Circle2() {
        radius = 1;
        name = "";
    }

    public Circle2(int r, String n) {
        radius = r;
        name = n;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        Circle2 pizza = new Circle2(10, "자바피자");

        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area);

        Circle2 donut = new Circle2();
        donut.name = "도넛피자";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);
    }
}

// 4-4: 생성자 선언 및 활용 연습
class Book {
    String title;
    String author;

    public Book(String t) {
        title = t;
        author = "작자미상";
    }

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    public static void main(String[] args) {
        Book littlePrince = new Book("어린왕자", "생텍쥐페리");
        Book loveStory = new Book("춘향전");
        System.out.println(littlePrince.title + " " + littlePrince.author);
        System.out.println(loveStory.title + " " + loveStory.author);
    }
}

// 4-5: this()로 다른 생성자 호출
class Book2 {
    String title;
    String author;

    void show() {
        System.out.println(title + " " + author);
    }

    public Book2() {
        this(" ", " ");
        System.out.println("생성자 호출됨");
    }

    public Book2(String title) {
        this(title, "작자미상");
    }

    public Book2(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args) {
        Book2 littlePrince = new Book2("어린왕자", "생텍쥐페리");
        Book2 loveStory = new Book2("춘향전");
        Book2 emptyBook = new Book2();
        loveStory.show();
    }
}

// 4-6: Circle 객체 배열 만들기
class Circle3 {
    int radius;

    public Circle3(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }
}

class CircleArray {
    public static void main(String[] args) {
        Circle3[] c;
        c = new Circle3[5];

        for (int i = 0; i < c.length; i++)
            c[i] = new Circle3(i);

        for (int i = 0; i < c.length; i++)
            System.out.print((int) (c[i].getArea()) + " ");
    }
}

// 4-7: 객체 배열 만들기 연습
class Book3 {
    String title, author;

    public Book3(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class BookArray {
    public static void main(String[] args) {
        Book3[] book = new Book3[2];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < book.length; i++) {
            System.out.print("제목>> ");
            String title = sc.nextLine();
            System.out.print("저자>> ");
            String author = sc.nextLine();
            book[i] = new Book3(title, author); // 배열 원소 객체 생성
        }

        for (int i = 0; i < book.length; i++) {
            System.out.print("(" + book[i].title + ", " + book[i].author + ")");
        }
        sc.close();
    }
}

// 4-8: 인자로 배열이 전달되는 예
class ArrayParameterEx {
    static void replaceSpace(char a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ')
                a[i] = ',';
        }
    }

    static void printCharArray(char a[]) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println();
    }

    public static void main(String args[]) {
        char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l' };
        printCharArray(c);
        replaceSpace(c);
        printCharArray(c);
    }
}

// 4-9: 가비지의 발생
class GarbageEx {
    public static void main(String[] args) {
        String a = new String("Good");
        String b = new String("Bad");
        String c = new String("Normal");
        String d, e;
        a = null;
        d = c;
        c = null;// 코드 실행 후 a가 가르키던 Good이 가비지 객체가 됨
    }
}
// 코드 실행 후 a가 가르키던 Good이 가비지 객체가 됨
// 가비지란 자신을 가리키는 레퍼런스가 하나도 없는 객체를 말함

// 4-10: 멤버 접근 지정자
class Sample {
    public int a;
    private int b;
    int c;
}

class AccessEx {
    public static void main(String[] args) {
        Sample aClass = new Sample();
        aClass.a = 10;
        // aClass.b = 10;//a,c는 각각 public, default 지정자 선언, b는 private로 선언되었으므로
        // AccessEx 클래스에서 접근 불가능
        aClass.c = 10;
    }
}

// 4-11: static 멤버를 객체의 멤버로 접근하는 사례
class StaticSample {
    public int n;

    public void g() {
        m = 20;
    }

    public void h() {
        m = 30;
    }

    public static int m;

    public static void f() {
        m = 5;
    }
}

class Ex {
    public static void main(String[] args) {
        StaticSample s1, s2;
        s1 = new StaticSample();
        s1.n = 5;
        s1.g();
        s1.m = 50;
        s2 = new StaticSample();
        s2.n = 8;
        s2.h();
        s2.f();
        System.out.println(s1.m);
        System.out.println(s2.m);
        System.out.println(s1.n);
        System.out.println(s2.n);
    }
}

// 4-12: static 멤버를 가진 Calc 클래스 작성
class Calc {
    public static int abs(int a) {
        return a > 0 ? a : -a;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int min(int a, int b) {
        return (a > b) ? b : a;
    }
}

class CalcEx {
    public static void main(String[] args) {
        System.out.println(Calc.abs(-5));
        System.out.println(Calc.max(10, 8));
        System.out.println(Calc.min(-3, -8));
    }
}

// 4-12: static을 이용한 환율 계산기
class CurrencyConverter {
    private static double rate;

    public static double toDollar(double won) {
        return won / rate;
    }

    public static double toKWR(double dollar) {
        return dollar * rate;
    }

    public static void setRate(double r) {
        rate = r;
    }
}

class StaticMember {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("환율(1달러)>>");
        double rate = sc.nextDouble();
        CurrencyConverter.setRate(rate);
        System.out.println("백만원은 $" + CurrencyConverter.toDollar(1000000) + "입니다.");
        System.out.println("$100는 " + CurrencyConverter.toKWR(100) + "원입니다.");
        sc.close();
    }
}