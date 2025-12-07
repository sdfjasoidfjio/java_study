package 기말대비_java;
import java.util.*;

class game{
    String name;
    int sec;
    public game(String name){
        this.name = name;
    }
    public void go(){
        System.out.print(name+"시작<Enter>키 >>");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        Calendar c = Calendar.getInstance();
        int r1 = c.get(Calendar.SECOND);
        System.out.println("\t현재 초 시간 = "+ r1);
        System.out.print("10초 예상 후 <Enter>키 >>");;
        sc.nextLine();
        c = Calendar.getInstance();
        int r2 = c.get(Calendar.SECOND);
        System.out.println("\t현재 초 시간 = "+r2);
        sec = r2<r1?r2+60-r1:r2-r1;
    }
    public void print(){
        System.out.print(name+"의 결과 " + sec + ".");
    }
}

public class a62 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
        game a = new game("박나윤");
        game b = new game("김선우");
        a.go();
        b.go();

        a.print();
        b.print();
        if(Math.abs(10-a.sec)>Math.abs(10-b.sec)){
            System.out.println("승자는 " + b.name);
        }
        else if(Math.abs(10-a.sec)<Math.abs(10-b.sec)){
            System.out.println("승자는 "+a.name);
        }
        else{
            System.out.println("비겼습니다.");
        }
    }
}
