package oj_java;

import javax.swing.*;
import java.awt.*;

public class java_oj91 {
    // ==== 아래 메서드만 학생이 작성 ====
    static Container build() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout(30,20));

        p.add(new JButton("Calculate"), BorderLayout.CENTER);
        p.add(new JButton("add"), BorderLayout.NORTH);
        p.add(new JButton("sub"), BorderLayout.SOUTH);
        p.add(new JButton("mul"), BorderLayout.EAST);
        p.add(new JButton("div"), BorderLayout.WEST);

        return p;
    }

    // ==== 변경 금지 ====
    public static void main(String[] args) {
        try {
            Container c = build();

            LayoutManager lm = c.getLayout();
            assertTrue(lm instanceof BorderLayout, "not BorderLayout");
            BorderLayout bl = (BorderLayout) lm;
            assertTrue(bl.getHgap() == 30, "hgap must be 30");
            assertTrue(bl.getVgap() == 20, "vgap must be 20");

            checkBtn(c, BorderLayout.CENTER, "Calculate");
            checkBtn(c, BorderLayout.NORTH,  "add");
            checkBtn(c, BorderLayout.SOUTH,  "sub");
            checkBtn(c, BorderLayout.EAST,   "mul");
            checkBtn(c, BorderLayout.WEST,   "div");

            System.out.println("SUCCESS-BorderLayout");
        } catch (AssertionError e) {
            System.out.println("FAIL: " + e.getMessage());
        }
    }

    private static void checkBtn(Container c, String pos, String text) {
        Component comp = ((BorderLayout) c.getLayout()).getLayoutComponent(c, pos);
        assertTrue(comp instanceof JButton, pos + " must be JButton");
        String t = ((JButton) comp).getText();
        assertTrue(text.equals(t), pos + " text must be '" + text + "'");
    }

    private static void assertTrue(boolean cond, String msg) {
        if (!cond) throw new AssertionError(msg);
    }
}
