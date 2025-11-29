package oj_java;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class java_oj112 extends JFrame {

    private Vector data = new Vector<>();
    private JList todoList = new JList<>(data);

    public java_oj112() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ------------------------------------
        // 이 부분에 Button 2개, TextField, List, Listener 코드 추가
        // ------------------------------------
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JTextField inputField = new JTextField(15);
        JButton addBtn = new JButton("Add");
        JButton removeBtn = new JButton("Remove");
        JPanel topPanel = new JPanel();

        topPanel.add(inputField);
        topPanel.add(addBtn);
        c.add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(todoList);
        c.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(removeBtn);
        c.add(bottomPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText().trim();
                if (!text.isEmpty()) {
                    data.add(text);             
                    todoList.setListData(data); 
                    inputField.setText("");    
                }
            }
        });

        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = todoList.getSelectedIndex();
                if (index != -1) {          
                    data.remove(index);
                    todoList.setListData(data);  
                }
            }
        });

        setSize(350, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
    	        sc.nextInt();
    	
                new java_oj112();
    }
}