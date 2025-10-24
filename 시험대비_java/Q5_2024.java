import java.util.*;

abstract class Animal {
    private int id;  // 동물의 id 값
    Animal(int id) { this.id = id; }

    // 해당 동물에 대한 정보를 출력한다.
    void show() { System.out.println("["+id+getShowMessage()+"]"); };

    // 위 show()에서 출력할 메시지를 구해 온다.
    abstract String getShowMessage();

    // 동물의 id를 문자열로 변환해서 리턴한다.
    public String toString() { return ""+id; };
}
 
 // 문제: Animal 클래스를 상속하여 Bird 클래스를 작성하라.
class Bird extends Animal{
    private int wingSize; // 왼쪽 위쪽 점 좌표 x1, y1
    
    // 생성자 및 필요한 멤버 메소드를 구현하라
    // 생성자의 매개변수는 아래 Manager 클래스 내의 객체 생성을 참조하라.
    Bird(int id, int wingSize){
        super(id);
        this.wingSize = wingSize;
    }
    String getShowMessage(){
        return "," + wingSize+ ":Bird";
    }
    public String toString(){
        return "(Bird:"+ super.toString() + "," + wingSize + ")";
    }
    
}
 // 문제: Animal 클래스를 상속하여 Human 클래스를 작성하라.
class Human extends Animal {
    private String name; // 사람이름
  
    // 생성자 및 필요한 멤버 메소드를 구현하라
    // 생성자의 매개변수는 아래 Manager 클래스 내의 객체 생성을 참조하라.
    Human(int id, String name){
        super(id);
        this.name = name;
    }

    String getShowMessage(){
        return ","+name+ ":Human";
    }
    public String toString(){
        return "(Human"+ super.toString() + "," + name + ")";
    }
}
 // 주의: 아래 Manager, Main 클래스들은 절대 수정하지 마라.
class Manager {
    Animal animals[] = { 
        // 생성자 인자는 Bird의 경우 (id, wingSize)이며, Human의 경우 (id, name)이다.  
        new Bird(101, 45),    new Human(501, "Choi"),
        new Bird(102, 25),    new Human(502, "Park"),
    };
    // animals[] 원소들의 순서를 임의로 바꿈; 
    // Manager(Scanner scan)를 이해하지 못해도 되니 코드를 해석하려 하지마라.
    Manager(Scanner scan) { 
        System.out.print("start index[0~99]? ");
        int i = scan.nextInt() % animals.length;
        int j = (i+3) % animals.length;
        Animal tmp = animals[i]; animals[i] = animals[j]; animals[j] = tmp;
    }
    void show() {
        for (Animal p: animals) 
            p.show();
    }
    void print() {
        for (Animal p: animals) 
            System.out.println(p.toString());
    }
}

public class Q5_2024 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Manager manager = new Manager(scan);
        while(true) {
            System.out.print("\n0.exit 1.show 2.print >> ");
            int input = scan.nextInt();
            if (input == 0)         break;
            else if (input == 1)    manager.show();
            else if (input == 2)    manager.print();
        }
        scan.close();
    }
 }