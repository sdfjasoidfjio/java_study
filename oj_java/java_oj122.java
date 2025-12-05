package oj_java;

import java.util.Scanner;

/**
 * 두 스레드가 번갈아 문자를 추가하는 공유 버퍼
 * - 입력으로 받은 문자 c1, c2를 이용해 "c1c2c1c2..." 패턴 생성
 * - putFirst(), putSecond()는 synchronized + wait()/notifyAll()로 제어
 */
class PatternBuffer {
    private final StringBuilder sb = new StringBuilder();
    private final int maxPairs;     // N (쌍 개수) → 최종 길이 = 2 * N
    private int count = 0;          // 현재까지 추가된 문자 수
    private boolean firstTurn = true;   // true면 c1 차례, false면 c2 차례

    private final char c1;          // 첫 번째 문자
    private final char c2;          // 두 번째 문자

    public PatternBuffer(int n, char c1, char c2) {
        this.maxPairs = n;
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * c1을 추가하려는 스레드(ThreadFirst)가 호출하는 메서드
     * @return true면 계속 진행, false면 더 이상 추가할 필요 없음
     */
    public synchronized boolean putFirst() {
        // 이미 2N개를 다 채웠으면 종료
        if (count >= maxPairs * 2) {
            notifyAll();
            return false;
        }

        // c1 차례가 아니면 대기
        while (!firstTurn && count < maxPairs * 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                return false;
            }
        }

        // 기다리는 동안에 이미 다 채워졌을 수도 있으므로 다시 확인
        if (count >= maxPairs * 2) {
            notifyAll();
            return false;
        }

        // 여기까지 왔으면 c1을 넣을 차례
        sb.append(c1);
        count++;
        firstTurn = false;   // 다음은 c2 차례
        notifyAll();         // 대기 중인 다른 스레드를 깨움
        return true;
    }

    /**
     * c2를 추가하려는 스레드(ThreadSecond)가 호출하는 메서드
     * @return true면 계속 진행, false면 더 이상 추가할 필요 없음
     */
    public synchronized boolean putSecond() {

       if (count >= maxPairs * 2) {
        notifyAll();      // 혹시 대기 중인 스레드 깨워주기
        return false;
    }

    // c2 차례가 아니면 대기 (firstTurn == true 이면 c1 차례라서 기다려야 함)
    while (firstTurn && count < maxPairs * 2) {
        try {
            wait();
        } catch (InterruptedException e) {
            return false; // 인터럽트되면 그냥 종료
        }
    }

    // 기다리는 동안에 이미 다 채워졌을 수도 있으므로 다시 확인
    if (count >= maxPairs * 2) {
        notifyAll();
        return false;
    }

        sb.append(c2);
        count++;
        firstTurn = true;
        notifyAll();       
        return true;
    }

    /**
     * 최종적으로 만들어진 패턴 문자열을 반환
     */
    public synchronized String getResult() {
        return sb.toString();
    }
}

/**
 * 첫 번째 문자 c1을 넣는 스레드
 */
class ThreadFirst extends Thread {
    private final PatternBuffer buffer;

    public ThreadFirst(PatternBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.putFirst()) {
            // 계속 c1을 추가하다가, 더 이상 넣을 필요 없으면 putFirst()가 false 리턴
        }
    }
}

/**
 * 두 번째 문자 c2를 넣는 스레드
 */
class ThreadSecond extends Thread {
    private final PatternBuffer buffer;

    public ThreadSecond(PatternBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.putSecond()) {
            // 계속 c2를 추가하다가, 더 이상 넣을 필요 없으면 putSecond()가 false 리턴
        }
        // ⚠️ 출력 없음
    }
}

/**
 * 문제 2 메인 클래스 (수정 버전)
 * - N, C1, C2를 입력받아 두 스레드가 번갈아 "C1C2C1C2..." 패턴 생성
 * - 최종 문자열만 한 줄 출력
 */
public class java_oj122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 쌍 개수
        String s1 = sc.next();  // 첫 번째 문자 (문자열로 먼저 읽고)
        String s2 = sc.next();  // 두 번째 문자

        sc.close();

        char c1 = s1.charAt(0); // 실제 문자
        char c2 = s2.charAt(0);

        PatternBuffer buffer = new PatternBuffer(N, c1, c2);
        ThreadFirst t1 = new ThreadFirst(buffer);
        ThreadSecond t2 = new ThreadSecond(buffer);

        // 두 스레드 시작
        t1.start();
        t2.start();

        // 두 스레드가 끝날 때까지 대기
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  최종 패턴 문자열만 한 줄 출력
        String result = buffer.getResult();
        System.out.println(result);
    }
}
