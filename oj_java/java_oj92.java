package oj_java;

import javax.swing.*;
import java.awt.*;

public class java_oj92 {
    // 학생이 작성할 부분
    static JPanel build() {
        JPanel p = new JPanel();

        p.setBackground(Color.CYAN);
        p.setLayout(new GridLayout(2, 1));

        p.add(new JLabel("Header"));
        p.add(new JTextField("Type here"));

        return p;
    }

    // 변경 금지
    public static void main(String[] args) {
        try {
            JPanel p = build();

            if (!Color.CYAN.equals(p.getBackground()))
                throw new AssertionError("background must be CYAN");

            if (!(p.getLayout() instanceof GridLayout))
                throw new AssertionError("layout must be GridLayout");
            GridLayout gl = (GridLayout) p.getLayout();
            if (gl.getRows() != 2 || gl.getColumns() != 1)
                throw new AssertionError("GridLayout must be 2x1");

            Component[] comps = p.getComponents();
            if (comps.length != 2)
                throw new AssertionError("must have 2 components");

            if (!(comps[0] instanceof JLabel))
                throw new AssertionError("first must be JLabel");
            if (!"Header".equals(((JLabel) comps[0]).getText()))
                throw new AssertionError("first label text must be 'Header'");

            if (!(comps[1] instanceof JTextField))
                throw new AssertionError("second must be JTextField");

            System.out.println("SUCCESS-BorderLayout");
        } catch (AssertionError e) {
            System.out.println("FAIL: " + e.getMessage());
        }
    }
}