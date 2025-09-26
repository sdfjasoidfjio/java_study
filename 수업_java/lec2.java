package 수업_java;

import java.util.Scanner;

//2-1: 프로그램의 기본 구조
/* public class lec2 {//클래스
    public static int sum(int n, int m) {//메소드
        return n + m;
    }

    //main() 메소드에서 실행 시작
    public static void main(String[] args) {//메소드
        int i = 20;
        int s;
        char a;

        s = sum(i, 10);//sum() 메소드 호출
        a = '?';
        System.out.println(a);//출력
        System.out.println("Hello");
        System.out.println(s);
    }
} */

//예제 2-1설명
// 클래스 만들기
// public 선언하면 다른 클래스에서 접근 가능
// 클래스 코드는 {} 내에 모두 작성

// main 메소드
// public static void 로 선언
// Stirng[] args로 실행 인자를 전달받음

//메소드 호출
//sum()호출 시 변수 i의 값과 정수 10을 전달
//sum()의 n,m에서 각각 20, 10 값 전달
//sum()은 n과 m 값을 더한 30 리턴
//변수 s는 정수 30을 전달받음

//변수 선언
//메소드 내에서 선언된 변수는 지역 변수(지역 변수는 메소드 실행이 끝나면 자동 소멸)

//화면 출력
//표준 출력 스트림에 메시지 출력
//System.out.의 println()메소드 호출(println은 다음 행으로 커서 이동)

//2-2: 변수, 리터럴, 상수 활용
/* public class lec2 {
    public static void main(String[] args) {
        final double PI = 3.14;

        double radius = 10.0;
        double circleArea = radius * radius * PI;

        System.out.println("원의 면적은 " + circleArea);
    }
} */

//2-4: Scanner를 이용한 키 입력 연습
/* public class lec2 {
    public static void main(String[] args) {
        System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요");
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        String city = sc.next();
        int age = sc.nextInt();
        double weight = sc.nextDouble();
        boolean single = sc.nextBoolean();

        System.out.print("이름은 " + name + ", 도시는 " + city + ", 나이는 " + age
                + "살, 체중은 " + weight + "kg, 독신 여부는 " + single + "입니다.");

        sc.close();
    }
} */

//2-5: /와 % 산술 연산
/* public class lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int time = sc.nextInt();
        int second = time % 60;
        int minute = (time / 60) % 60;
        int hour = (time / 60) / 60;

        System.out.print(time + "초는 ");
        System.out.print(hour + "시간 ");
        System.out.print(minute + "분 ");
        System.out.print(second + "초입니다. ");

        sc.close();
    }
} */

//2-7: 대입 연산자와 증감 연산자 사용
/* public class lec2 {
    public static void main(String[] args) {
        int a = 3, b = 3, c = 3;

        a += 3;// 6
        b *= 3;// 9
        c %= 2;// 1
        System.out.println(a + " " + b + " " + c);

        int d = 3;
        a = d++;
        System.out.println(a + " " + d);
        a = ++d;
        System.out.println(a + " " + d);
        a = d--;
        System.out.println(a + " " + d);
        a = --d;
        System.out.println(a + " " + d);
    }
} */

//2-10: if 문 사용하기
/* public class lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("점수를 입력하시오: ");
        int score = sc.nextInt();
        if (score >= 80) {
            System.out.println("축하합니다! 합격입니다.");
        }
        sc.close();
    }
} */

//2-11: if-else 사용하기
/* public class lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("수를 입력하시오: ");
        int num = sc.nextInt();

        if (num % 3 == 0) {
            System.out.println("3의 배수입니다.");
        } else {
            System.out.println("3의 배수가 아닙니다.");
        }
    }
} */

//2-12: 다중 if-else 사용하기
/* public class lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("점수를 입력하세요(0-100): ");
        int score = sc.nextInt();
        char grade;

        if (score >= 90)
            grade = 'A';
        else if (score >= 80)
            grade = 'B';
        else if (score >= 70)
            grade = 'C';
        else
            grade = 'F';

        System.out.println("학점은 " + grade + "입니다.");
    }
} */

//2-13: 중첩 if-else 문
/* public class lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score;
        int grade;

        System.out.print("점수를 입력하세요(0-100): ");
        score = sc.nextInt();
        System.out.print("학년을 입력하세요(1-4): ");
        grade = sc.nextInt();

        if (score >= 60) {//60점 이상
            if (grade != 4) {//4학년 아니면 합격
                System.out.println("합격!");
            } else if (score >= 70) {//70점 이상이면 합격
                System.out.println("합격!");
            } else {//4학년이 70점 미만이면 불합격
                System.out.println("불합격!");
            }
        } else {//60점 미만 불합격
            System.out.println("불합격!");
        }
    }
} */

/* public class lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score;
        char grade;
        System.out.print("점수를 입력하세요(0-100): ");
        score = sc.nextInt();

        switch (score / 10) {// 76점이라고 하면 case 76이 있어야함
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
        System.out.println("학점은 " + grade + "입니다");
        sc.close();
    }
} */

//2-15: switch 문 활용
public class lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("무슨 커피 드릴까요? ");
        String order;
        order = sc.next();
        switch (order) {
            case "에스프레소":
            case "카푸치노":
            case "카페라떼":
                System.out.println(order + "는 3500원입니다.");
                break;
            case "아메리카노":
                System.out.println(order + "는 2000원입니다.");
                break;
        }// 이렇게 말고 케이스 별로 변수를 만들어서 가격을 넣고 마지막에 order랑 price 사용하는
         // 문장을 만들 수도 있음
        sc.close();
    }
}