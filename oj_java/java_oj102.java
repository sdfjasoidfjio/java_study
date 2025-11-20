package oj_java;
import java.util.*;

// ===== Dummy GUI System (수정 금지) =====

interface DummyActionListener {
    void onClick();
}

class DummyButton {
    String text;
    DummyActionListener listener;

    DummyButton(String text) { this.text = text; }

    void addActionListener(DummyActionListener l) {
        this.listener = l;
    }
}

class DummyPanel {
    HashMap<String, DummyButton> map = new HashMap<>();

    void add(String name, DummyButton btn) {
        map.put(name, btn);
    }
}

// ===== 작성해야 하는 부분 =====
public class java_oj102 {

    static DummyPanel build() {
        DummyPanel p = new DummyPanel();
        DummyButton addBtn = new DummyButton("add");
        DummyButton subBtn = new DummyButton("sub");
        DummyButton mulBtn = new DummyButton("mul");

        addBtn.addActionListener(new DummyActionListener() {
            public void onClick(){
                System.out.println("ADD CLICKED");
            }
        });

        subBtn.addActionListener(new DummyActionListener() {
            public void onClick(){
                System.out.println("SUB CLICKED");
            }
        });

        mulBtn.addActionListener(new DummyActionListener() {
            public void onClick(){
                System.out.println("MUL CLICKED");
            }
        });

        p.add("add", addBtn);
        p.add("sub", subBtn);
        p.add("mul", mulBtn);

        return p;
    }

    public static void main(String[] args) {

        // OJ empty test-data 방지용: 입력 한 줄 소비
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) sc.nextLine();

        DummyPanel p = build();

        // build() 결과에서 버튼을 꺼내 리스너를 호출
        DummyButton bAdd = p.map.get("add");
        DummyButton bSub = p.map.get("sub");
        DummyButton bMul = p.map.get("mul");

        if (bAdd != null && bAdd.listener != null) bAdd.listener.onClick();
        if (bSub != null && bSub.listener != null) bSub.listener.onClick();
        if (bMul != null && bMul.listener != null) bMul.listener.onClick();
    }
}

