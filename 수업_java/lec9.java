package 수업_java;
import javax.swing.*;
import java.awt.*;

class ContentPaneEx extends JFrame {
    public ContentPaneEx(){
        setTitle("ContentPane과 JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new BorderLayout(30, 20));
        c.add(new JButton("add"), BorderLayout.WEST);
        c.add(new JButton("sub"), BorderLayout.NORTH);
        c.add(new JButton("mul"), BorderLayout.SOUTH);
        c.add(new JButton("div"), BorderLayout.EAST);
        c.add(new JButton("Calculate"), BorderLayout.CENTER);

        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args){
        new ContentPaneEx();
    }
}

class GridLayoutEx extends JFrame{
    public GridLayoutEx(){
        setTitle("GridLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(4,2);
        grid.setVgap(5);

        Container c = getContentPane();
        c.setLayout(grid);
        c.add(new JLabel(" 이름"));
        c.add(new JTextField(""));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 과목"));
		c.add(new JTextField(""));
		setSize(300, 200);
		setVisible(true);
    }
    public static void main(String[] args){
        new GridLayoutEx();
    }
}

class NullContainerEx extends JFrame{
    public NullContainerEx(){
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("Hello, Press Buttons!");
        la.setLocation(130, 50);
        la.setSize(200, 20);
        c.add(la);

        for(int i = 1; i <= 9; i++){
            JButton b  =new JButton(Integer.toString(i));
            b.setLocation(i*15, i*15);
            b.setSize(50,20);
            c.add(b);
        }
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args){
        new NullContainerEx();
    }
}

class MultiplePanelEx extends JFrame{
    public MultiplePanelEx(){
        super("Multiple Panels and Layouts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new CenterPanel(), BorderLayout.CENTER);
        setSize(300,300);
        setVisible(true);
    }

    class NorthPanel extends JPanel{
        public NorthPanel(){
            setBackground(Color.LIGHT_GRAY);
            setLayout(new FlowLayout());
            add(new JButton("Open"));
            add(new JButton("Read"));
            add(new JButton("Close"));
        }
    }

    class CenterPanel extends JPanel{
        private JLabel [] labels = {new JLabel("Hello"), new JLabel("Java"), new JLabel("Love")};
        public CenterPanel(){
            setLayout(null);
            for(int i = 0; i < labels.length; i++){
                int x = (int)(Math.random()*200);
                int y = (int)(Math.random()*200);
                labels[i].setLocation(x,y);
                labels[i].setSize(100,20);
                add(labels[i]);
            }
        }
    }

    static public void main(String[] args){
        new MultiplePanelEx();
    }
}