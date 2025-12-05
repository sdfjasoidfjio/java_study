package oj_java;
import java.util.Scanner;

/**
 * 전체 합을 관리하는 공유 객체
 * - 여러 스레드가 동시에 add()를 호출하므로 synchronized로 보호
 */
class SharedSum {
    private int sum = 0;

    /**
     * 부분합을 더하는 메서드
     * synchronized: 한 번에 한 스레드만 sum을 수정하도록 함
     */
    public synchronized void add(int partial) {
        sum += partial;   // 공유 변수 sum에 부분합을 더함
    }

    public int getSum() {
        return sum;
    }
}

/**
 * 1개의 스레드가 일정 구간 [start, end]의 합을 계산하는 클래스
 */
class SumWorker extends Thread {
    private final int start;           // 이 스레드가 맡은 구간의 시작값
    private final int end;             // 이 스레드가 맡은 구간의 끝값
    private final SharedSum sharedSum; // 전체 합을 담는 공유 객체

    public SumWorker(int start, int end, SharedSum sharedSum) {
        this.start = start;
        this.end = end;
        this.sharedSum = sharedSum;
    }

    public void run() {
        // 1) 구간 [start, end]의 합 계산
        int temp = 0;
        for (int i = start; i <= end; i++) {
            temp += i;
        }
        // 2) 계산한 부분합을 공유 객체에 더하기
        sharedSum.add(temp);
    }
}

/**
 * 문제 1 메인 클래스
 * - N, T를 입력받아 T개의 스레드로 1~N 합을 계산
 * - 최종 합만 한 줄 출력
 */
public class java_oj121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: N, T
        int N = sc.nextInt(); // 1 ~ N까지의 합
        int T = sc.nextInt(); // 사용할 스레드 개수
        sc.close();

        SharedSum sharedSum = new SharedSum();
        SumWorker[] workers = new SumWorker[T];

        // 구간 나누기:
        // - 기본 구간 크기: N / T
        // - 나머지: 앞에서부터 1씩 추가 배분
        int baseSize = N / T;
        int remainder = N % T;

        int currentStart = 1; // 다음 스레드의 시작 값

        for (int i = 0; i < T; i++) {
            int size = baseSize;
            if (i < remainder) {
                // 나머지 개수만큼 앞쪽 스레드에 1씩 더 배분
                size++;
            }
            int currentEnd = currentStart + size - 1;
            if (currentEnd > N) {
                currentEnd = N;
            }

            workers[i] = new SumWorker(currentStart, currentEnd, sharedSum);

            // 다음 스레드의 시작 값 갱신
            currentStart = currentEnd + 1;
        }

        // 모든 스레드 시작
        for (int i = 0; i < T; i++) {
            workers[i].start();
        }

        // 모든 스레드가 끝날 때까지 대기
        for (int i = 0; i < T; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 최종 합만 한 줄 출력 
        System.out.println(sharedSum.getSum());
    }
}