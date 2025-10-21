import java.util.*;

class Personn {
    String name;

    Personn(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("이름: " + name);
    }
}

class Students extends Personn {
    int grade;

    Students(String name, int grade) {
        super(name);
        this.grade = grade;
    }

    public void introduce() {
        System.out.println("이름: " + name + ", 학년: " + grade);
    }
}

public class jfo {
    public static void main(String[] args) {
        Students s = new Students("나윤", 2);
        s.introduce();
    }
}