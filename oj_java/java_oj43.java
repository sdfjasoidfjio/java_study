package oj_java;
/*Main 클래스 위에 다음과 같은 요소들을 포함하는 Counter 클래스를 작성하시오.
- private static int count 변수를 선언 (생성된 객체 수 저장)
- 생성자: 객체가 생성될 때마다 count를 1 증가시킴
- public static int getCount() 메소드: 현재까지 생성된 객체 수 반환
- final static double PI = 3.14; 를 선언하고, 반지름을 받아 원의 넓이를 계산하는 getCircleArea(double r) 정적 메소드를 작성

다음과 같이 동작하는 Main 클래스를 작성하시오.
1. main 메소드에서 Counter 객체를 5개 생성
2. 객체 수를 출력
3. 반지름이 10인 원의 넓이를 출력

출력 예시 1)
# of objects: 5
Circle area with radius 10: 314.0 */

class Counter {
    private static int count = 0;
    public final static double PI = 3.14;

    public Counter() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static double getCircleArea(double r) {
        return PI * r * r;
    }
}

public class java_oj43 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Counter();
        }
        System.out.println("# of objects: " + Counter.getCount());
        System.out.println("Circle area with radius 10: " + Counter.getCircleArea(10));
    }
}
