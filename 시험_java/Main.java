import java.util.*;

interface Car {
    String getLogo(); // 현재 자동차 로고 리턴

    int consumeFuel(); // 차가 달리는데 필요한 적절한 연료량을 감소, 현재 남아있는 연료량 리턴

    default void run() {
        System.out.println(getLogo() + " Car is running: " + consumeFuel() + "%");
    }
}

abstract class Battery {
    private int capacity; // 충전량

    Battery(int capacity) {
        this.capacity = capacity;
    }

    int getCapacity() {
        return capacity;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    abstract void charge();
}

abstract class EvCar extends Battery implements Car {

    // 문제: 생성자 및 필요한 멤버 함수 구현

    private String logo;

    EvCar(String logo, int capacity) {
        super(capacity);
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public String setLogo(String logo) {
        return this.logo = logo;
    }
}

// 문제: 위 계층 구조 그림을 참조하여 적절한 클래스를 상속하라
class IONIC6 extends EvCar {
    // 문제: 생성자 및 필요한 멤버 함수들 구현하라

    IONIC6(String logo, int capacity) {
        super(logo, capacity);
    }

    public int consumeFuel() {
        int cap = getCapacity();
        cap -= 10;
        if (cap < 0)
            cap = 0;
        setCapacity(cap);
        return cap;
    }

    void charge() {
        int cap = getCapacity();
        cap += 10;
        if (cap > 100)
            cap = 100;
        setCapacity(cap);
        System.out.println(getLogo() + ": charging battery: " + cap + "%");
    }
}

// 문제: 위 계층구조 그림을 참조하여 적절한 클래스를 상속하라
class EV6 extends EvCar {
    // 문제: 생성자 및 필요한 멤버 함수들 구현하라
    EV6(String logo, int capacity) {
        super(logo, capacity);
    }

    public int consumeFuel() {
        int cap = getCapacity();
        cap -= 5;
        if (cap < 0)
            cap = 0;
        setCapacity(cap);
        return cap;
    }

    void charge() {
        int cap = getCapacity();
        cap += 5;
        if (cap > 100)
            cap = 100;
        setCapacity(cap);
        System.out.println("Battery is being charged " + cap + "% : " + getLogo());
    }
}

// mainEvCar(EvCar ec)를 제외하고는 절대 수정하지말라
public class Main {
    static IONIC6 io6 = new IONIC6("IONIC6", 70);
    static EV6 ev6 = new EV6("KiaEV6", 15);

    static void evCarRun(Car c) {
        c.run();
    }

    static void evCarCharge(Battery b) {
        b.charge();
    }

    static void mainEvCar(EvCar ec) {
        // 문제: 위 evCarRun(Car c)와 evCarCharge(Battery b)를 순서적으로 직접 호출하라
        // 경고: ec.run(); ec.charge();로 호출하여 출력되게 하면 0점 처리함
        evCarRun(ec);
        evCarCharge(ec);
    }

    static void display() {
        System.out.println(io6.getLogo() + ": " + io6.getCapacity() + "%");
        System.out.println(ev6.getLogo() + ": " + ev6.getCapacity() + "%");
    }

    public static void mainMenu(Scanner scan) {
        display();

        while (true) {
            System.out.print("\n0.exit 1.run 2.charge 3.inferface 4.logo >> ");
            int input = scan.nextInt();
            if (input == 0)
                break;
            switch (input) {
                case 1:
                    io6.run();
                    ev6.run();
                    break;
                case 2:
                    io6.charge();
                    ev6.charge();
                    break;
                case 3:
                    mainEvCar(io6);
                    System.out.println("-----------");
                    mainEvCar(ev6);
                    break;
                case 4:
                    System.out.print("IONIC6 logo? ");
                    io6.setLogo(scan.next());
                    System.out.print("KiaEV6 logo? ");
                    ev6.setLogo(scan.next());
                    System.out.println("-----------");
                    display();
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