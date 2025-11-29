package oj_java;

import java.util.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;


public class java_oj111 extends JFrame {
    JTextField idField;
    JPasswordField pwField;
	JButton loginBtn;
	
    public java_oj111() {
        setTitle("Example of LoginUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ------------------------------------
        // 이 부분에 Label, TextField, PasswordField, Listener 코드 추가
        // ------------------------------------

        Container c = getContentPane();
        c.setLayout(new GridLayout(3, 2, 5, 5));

        JLabel idLabel = new JLabel("ID");
        JLabel pwLabel = new JLabel("Password");

        idField = new JTextField(10);
        pwField = new JPasswordField(10);
        loginBtn = new JButton("Login");

        c.add(idLabel);
        c.add(idField);
        c.add(pwLabel);
        c.add(pwField);
        c.add(new JLabel(""));
        c.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String pw = new String(pwField.getPassword());

                if (id.equals("admin") && pw.equals("1234")) {
                    JOptionPane.showMessageDialog(java_oj111.this, "Login Success!");
                } else {
                    JOptionPane.showMessageDialog(java_oj111.this, "Login Failure!");
                }
            }
        });

        setSize(300, 150);
        setVisible(true);
        
        // ------------------------------------
        // 1. UI 생성 후 자동 테스트 코드 실행
        // ------------------------------------
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("[TEST] Click the Login button");

                // 필요한 경우 자동 입력
                idField.setText("admin");
                pwField.setText("1234");

                // 자동 클릭
                loginBtn.doClick();
            }
        });
    }

    public static void main(String[] args) {
        // ------------------------------------
        // 2. main에서 UI 스레드로 프로그램 실행
        // ------------------------------------
    	Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) sc.nextLine();
        
        new java_oj111();
    }
}