// 문제 2 — 오버라이딩과 super 메서드
// 📘 문제 설명

// Employee 클래스의 work() 메서드는 "일반 직원이 일합니다."를 출력한다.
// 이 클래스를 상속받는 Manager 클래스는 work()를 오버라이딩하되,
// 부모의 work()를 먼저 호출한 뒤, "매니저가 팀을 관리합니다."를 출력하시오.

package prac_java;

import java.util.*;

class Employee {
    void work() {
        System.out.println("일반 직원이 일합니다.");
    }
}

class Manager extends Employee {
    void work() {
        super.work();
        System.out.println("매니저가 팀을 관리합니다.");
    }
}

public class b {
    public static void main(String[] args) {
        Employee em = new Employee();
        Manager ma = new Manager();

        em.work();
        ma.work();
    }
}
