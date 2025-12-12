package 기말대비_java;
import java.util.*;

public class a73 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> nation = new HashMap<>();
        System.out.println("나라 이름과 인구를 입력하세요. (예: Korea 5000)");
        while(true){
            System.out.print("나라 이름, 인구 >> ");
            String n = sc.next();
            if(n.equals("그만")) break;
            int a = sc.nextInt();
            nation.put(n,a);
        }
        while(true){
            System.out.print("인구 검색 >> ");
            String n = sc.next();
            if(n.equals("그만")) break;
            if(nation.containsKey(n)) System.out.println(n + "의 인구는 " + nation.get(n));
            else System.out.println(n + " 나라는 없습니다.");
        }
        sc.close();
    }
}
