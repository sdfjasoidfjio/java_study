package 수업_java;

import java.util.*;

//3-1: for문을 이용하여 1부터 10까지 합 출력
/* public class lec3 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
            System.out.print(i);

            if (i <= 9)
                System.out.print("+");
            else {
                System.out.print("=");
                System.out.print(sum);
            }
        }
    }
} */

//3-2: -1이 입력될 때까지 입력된 수의 평균 구하기
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        double sum = 0;

        System.out.println("정수를 입력하고 마지막에 -1을 입력하세요.");
        int n = sc.nextInt();
        while (n != -1) {
            sum += n;
            count++;
            n = sc.nextInt();
        }
        if (count == 0)
            System.out.println("입력된 수가 없습니다.");
        else {
            System.out.print("정수의 개수는 " + count + "개이며 ");
            System.out.println("평균은 " + (double) sum / count + "입니다");
        }
        sc.close();
    }
} */

//3-3: a-z까지 출력
/* public class lec3 {
    public static void main(String[] args) {
        char c = 'a';

        do {
            System.out.print(c);
            c = (char) (c + 1);
        } while (c <= 'z');
    }
}
 */

//3-4: 2중 중첩을 이용한 구구단
/* public class lec3 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(j + "*" + i + "=" + i * j);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
} */

//3-5: continue문을 이용하여 양수 합 구하기
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 5개 입력하세요.");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            if (n <= 0)
                continue;
            else
                sum += n;
        }
        System.out.println("양수의 합은 " + sum);

        sc.close();
    }
} */

//3-6: break문을 이용하여 while문 벗어나기
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("exit을 입력하면 종료합니다.");
        while (true) {
            System.out.print(">>");
            String text = sc.nextLine();
            if (text.equals("exit"))
                break;
        }
        System.out.println("종료합니다..");

        sc.close();
    }
} */

//3-7: 배열에 입력받은 수 중 제일 큰 수 찾기
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inArray[] = new int[5];

        int max = 0;
        System.out.println("양수 5개를 입력하세요.");
        for (int i = 0; i < 5; i++) {
            inArray[i] = sc.nextInt();
            if (inArray[i] > max)
                max = inArray[i];
        }
        System.out.println("가장 큰 수는 " + max + "입니다.");
        sc.close();
    }
} */

//3-8: 배열 원소의 평균 구하기
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int array[] = new int[5];
        int sum = 0;

        System.out.print(array.length + "개의 정수를 입력하세요>> ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            sum += array[i];
        }
        System.out.println("평균은 " + (double) sum / array.length);
        sc.close();
    }
} */

//3-9: 2차원 배열로 4년 평점 구하기
/* public class lec3 {
    enum Week {
        월, 화, 수, 목, 금, 토, 일
    }

    public static void main(String[] args) {
        int[] n = { 1, 2, 3, 4, 5 };
        String names[] = { "사과", "배", "바나나", "체리", "딸기", "포도" };

        int sum = 0;
        for (int k : n) {
            System.out.print(k + " ");
            sum += k;
        }
        System.out.println("합은 " + sum);

        for (String s : names) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (Week day : Week.values()) {
            System.out.print(day + "요일  ");
        }
        System.out.println();
    }
} */

//3-10: 비정방형 배열의 생성과 접근
/* public class lec3 {
    public static void main(String[] args) {
        double score[][] = { { 3.3, 3.4 },
                { 3.5, 3.6 },
                { 3.7, 4.0 },
                { 4.1, 4.2 } };
        double sum = 0;
        for (int year = 0; year < score.length; year++) {
            for (int term = 0; term < score[year].length; term++) {
                sum += score[year][term];
            }
        }

        int n = score.length;
        int m = score[0].length;
        System.out.println("4년 전체 평점 평균은 " + sum / (n * m));
    }
} */

//3-12: 배열 리턴
/* public class lec3 {
    static int[] makeArray() {
        int temp[] = new int[4];
        for (int i = 0; i < temp.length; i++)
            temp[i] = i;
        return temp;
    }

    public static void main(String[] args) {
        int intArray[];
        intArray = makeArray();
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
    }
} */

//3-13: main()에서 명령행 인자의 합 계산
/* public class lec3 {//run메뉴에서 main()메소드의 인자를 나열해줘야 함
    public static void main(String[] args) {
        double sum = 0.0;

        for (int i = 0; i < args.length; i++)
            sum += Double.parseDouble(args[i]);

        System.out.println("합계: " + sum);
    }
} */

//3-14: 0으로 나누기 예외 발생 프로그램이 강제 종료되는 경우
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int divid;
        int divisor;

        System.out.print("나뉨수를 입력하시오: ");
        divid = sc.nextInt();
        System.out.print("나눗수를 입력하시오: ");
        divisor = sc.nextInt();
        System.out.println(divid + "를 " + divisor + "로 나누면 몫은 " + divid / divisor + "입니다.");
        sc.close();

    }
} */

//3-15: 0으로 나눌 때 발생하는 ArithmeticException예외 처리
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("나뉨수를 입력하세요: ");
            int divid = sc.nextInt();
            System.out.print("나눗수를 입력하세요: ");
            int divisor = sc.nextInt();

            try {
                System.out.println(divid + "를 " + divisor + "로 나누면 몫은 " + divid / divisor + "입니다.");
                break;
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다! 다시 입력하세요.");
            }
        }
        sc.close();
    }
} */

//3-16: 범위를 벗어난 배열의 접근
/* public class lec3 {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        intArray[0] = 0;
        try {
            for (int i = 0; i < 5; i++) {
                intArray[i + 1] = i + 1 + intArray[i];
                System.out.println("intArray[" + i + "]" + "=" + intArray[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 인덱스가 범위를 벗어났습니다.");
        }
    }
} */

//3-17: 입력 오류 시 발생하는 예외(InputMismatchException)
/* public class lec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 3개를 입력하세요");
        int sum = 0, n = 0;
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + ">>");
            try {
                n = sc.nextInt();
            } catch (InputMismatchException e) {
                String ex = sc.nextLine();

                System.out.println(ex + "은 정수가 아닙니다. 다시 입력하세요!");
                i--;
                continue;
            }
            sum += n;
        }
        System.out.println("합은 " + sum);
        sc.close();
    }
} */

//3-18: 정수가 아닌 문자열을 정수로 변환할 때 예외 발생
public class lec3 {
    public static void main(String[] args) {
        String[] stringNumber = { "21", "12", "3.141592", "998" };

        int i = 0;
        try {
            for (i = 0; i < stringNumber.length; i++) {
                int j = Integer.parseInt(stringNumber[i]);
                System.out.println("숫자로 변환된 값은 " + j);
            }
        } catch (NumberFormatException e) {
            System.out.println(stringNumber[i] + "는 정수로 변환할 수 없습니다.");
        }
    }
}