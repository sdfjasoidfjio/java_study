package 수업_java;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class InnerClassListener extends JFrame { //내부 클래스로 이벤트 리스너 만들기
    public InnerClassListener(){
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        setSize(350, 150);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton b = (JButton)e.getSource();
            if(b.getText().equals("Action")) b.setText("액션");
            else b.setText("Action");

            InnerClassListener.this.setTitle(b.getText());
        }
    }

    public static void main(String[] args){
        new InnerClassListener();
    }
}


class AnonymousClassListener extends JFrame{//익명 클래스로 이벤트 리스너 만들기
    public AnonymousClassListener(){
        setTitle("이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action")) b.setText("액션");
                else b.setText("Action");
                setTitle(b.getText());
            }
        });
        setSize(350, 150);
        setVisible(true);
    }

    public static void main(String[] args){
        new AnonymousClassListener();
    }
}

//10-3까지함