package oj_java;
import java.util.*;

class DummyButton {
    String text;
    DummyButton(String text) { this.text = text; }
}

class DummyBorderLayout {
    static final String CENTER = "CENTER";
    static final String NORTH  = "NORTH";
    static final String SOUTH  = "SOUTH";
    static final String EAST   = "EAST";
    static final String WEST   = "WEST";

    int hgap, vgap;
    DummyBorderLayout(int h, int v) { this.hgap = h; this.vgap = v; }
}

class DummyPanel {
    DummyBorderLayout layout;
    HashMap<String, DummyButton> map = new HashMap<>();

    void setLayout(DummyBorderLayout l) { this.layout = l; }
    void add(DummyButton b, String pos) { map.put(pos, b); }
}

// ===== 작성해야 하는 부분 =====
public class java_oj101 {

    static DummyPanel build() {
        DummyPanel p = new DummyPanel();

        p.setLayout(new DummyBorderLayout(30, 20));

        p.add(new DummyButton("Calculate"), DummyBorderLayout.CENTER);
        p.add(new DummyButton("add"),       DummyBorderLayout.NORTH);
        p.add(new DummyButton("sub"),       DummyBorderLayout.SOUTH);
        p.add(new DummyButton("mul"),       DummyBorderLayout.EAST);
        p.add(new DummyButton("div"),       DummyBorderLayout.WEST);

        return p;
    }

    // ===== 자동 채점 코드 (수정 금지) =====
    public static void main(String[] args) {

        // empty test-data 방지용: 입력 1줄 소비
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) sc.nextLine();

        DummyPanel p = build();

        if (p == null) {
            System.out.println("FAIL: panel is null");
            return;
        }

        if (p.layout == null) {
            System.out.println("FAIL: layout missing");
            return;
        }

        if (p.layout.hgap != 30 || p.layout.vgap != 20) {
            System.out.println("FAIL: wrong gap");
            return;
        }

        check(p, DummyBorderLayout.CENTER, "Calculate");
        check(p, DummyBorderLayout.NORTH,  "add");
        check(p, DummyBorderLayout.SOUTH,  "sub");
        check(p, DummyBorderLayout.EAST,   "mul");
        check(p, DummyBorderLayout.WEST,   "div");

        System.out.println("SUCCESS");
    }

    static void check(DummyPanel p, String pos, String text) {
        DummyButton b = p.map.get(pos);
        if (b == null || !text.equals(b.text)) {
            System.out.println("FAIL");
            System.exit(0);
        }
    }
}