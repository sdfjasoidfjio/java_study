package 시험다시풀기_java;

import java.util.*;

// TV 인터페이스는 수정하지 마시오.
interface TV {
    void volumeUp(); // 볼륨 값을 하나 증가시키고 변경된 볼률 값을 화면에 보여 준다.

    void display(String message);
    // 화면에 " TV클래스이름: message"를 한 줄로 출력한다.
    // 예: display("X")로 호출할 경우 " SamsungTV: X" 또는 " LGTV: X"로 출력
}

// SamsungTV와 LGTV는 interface TV를 구현한다.
class SamsungTV implements TV { // 문제: 위 계층구조 그림을 참조하여 상속 및 구현 등의 적절한 조치를 취하라.
    private int volume; // 현재의 TV 볼륨 값
    // 문제: 생성자 및 필요한 멤버 함수들 구현하라.
    // 생성자의 매개변수는 아래 main() 함수 내의 객체 생성을 참조하라.

    SamsungTV(int volume) {
        this.volume = volume;
    }

    public void volumeUp() {
        System.out.println("    SamsungTV: volume changed from " + volume + " to " + ++volume);
    }

    public void display(String message) {
        System.out.println("    SamsungTV: " + message);
    }
}

class LGTV implements TV { // 문제: 위 계층구조 그림을 참조하여 상속 및 구현 등의 적절한 조치를 취하라.
    private int volume; // 현재의 TV 볼륨 값

    // 문제: 생성자 및 필요한 멤버 함수들 구현하라.
    // 생성자의 매개변수는 아래 main() 함수 내의 객체 생성을 참조하라.
    LGTV(int volume) {
        this.volume = volume;
    }

    public void volumeUp() {
        System.out.println("    LGTV: volume set to " + ++volume);
    }

    public void display(String message) {
        System.out.println("    SamsungTV: " + message);
    }
}

// -----------------------------------------------------------------------------
// SetTopBox 클래스는 수정하지 마시오.
abstract class SetTopBox {
    private TV tv; // SetTopBox와 결합된 TV: SetTopBox가 TV를 제어한다.
    private String ipAddress; // 인터넷 주소: SetTopBox는 인터넷과 연결되었음

    SetTopBox(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    void setTV(TV tv) {
        this.tv = tv;
    } // SetTopBox가 제어할 TV를 결합한다

    abstract String getBrandName(); // SetTopBox의 브랜드 이름 리턴

    abstract String getOTTbanner(); // SetTopBox에서 OTT 서버와 연결되었을 때 출력할 메시지 리턴

    void OTTservice() {
        tv.display(getBrandName() + "(" + ipAddress + ") is connecting to the OTT server.");
        tv.display(getOTTbanner());
    }

    void run(Scanner scan) {
        while (true) {
            System.out.print("SetTopBox Menu:   0.exit   1.tvVolumUp   2.OTTservice >> ");
            int input = scan.nextInt();
            if (input == 0)
                break;
            else if (input == 1)
                tv.volumeUp();
            else if (input == 2)
                OTTservice();
        }
    }
}

// SKSetTopBox와 KTSetTopBox는 SetTopBox를 상속한다.
class SKSetTopBox extends SetTopBox { // 문제: 위 계층구조 그림을 참조하여 상속 또는 구현 등의 적절한 조치를 취하라.
    String brandName;

    SKSetTopBox(String brandName, String ipAddress) {
        super(ipAddress);
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getOTTbanner() {
        return "Welcome to " + brandName + "!!";
    }

    // 문제: 생성자 및 필요한 멤버 함수들 구현하라.
    // 생성자의 매개변수는 아래 main() 함수 내의 객체 생성을 참조하라.
}

class KTSetTopBox extends SetTopBox { // 문제: 위 계층구조 그림을 참조하여 상속 또는 구현 등의 적절한 조치를 취하라.
    String brandName;

    KTSetTopBox(String brandName, String ipAddress) {
        super(ipAddress);
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getOTTbanner() {
        return "Welcome to " + brandName + "!!";
    }

    // 문제: 생성자 및 필요한 멤버 함수들 구현하라.
    // 생성자의 매개변수는 아래 main() 함수 내의 객체 생성을 참조하라.
}

// -----------------------------------------------------------------------------
public class jb2024_52 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ipAddr = "192.9.20.1";
        SamsungTV SStv = new SamsungTV(10); // TV 볼륨 값을 10으로 초기화함
        LGTV LGtv = new LGTV(10); // TV 볼륨 값을 10으로 초기화함
        SetTopBox stb = null;
        System.out.print("select SetTopBox:   1.SKsetTopBox   2.KTsetTopBox >> ");
        int input = scan.nextInt(); // 사용할 SetTopBox 선택
        System.out.print("SetTopBox brand name? ");
        String brandName = scan.next(); // 선택된 SetTopBox의 브랜드 이름 입력 받음
        if (input == 1)
            stb = new SKSetTopBox(brandName, ipAddr); // 브랜드 이름과 IP 주소를 초기화함
        else if (input == 2)
            stb = new KTSetTopBox(brandName, ipAddr);

        System.out.print("select TV       :   1.SamsungTV   2.LGTV >> ");
        input = scan.nextInt(); // SetTopBox와 결합할 TV 선택
        // SetTopBox가 제어할 TV를 설정(결합)
        if (input == 1)
            stb.setTV(SStv); // 문제: 삼성TV의 interface TV 레퍼런스를 넘겨 주어라.
        else if (input == 2)
            stb.setTV(LGtv); // 문제: LGTV의 interface TV 레퍼런스를 넘겨 주어라.
        stb.run(scan); // SetTopBox 실행
        scan.close();
    }
}