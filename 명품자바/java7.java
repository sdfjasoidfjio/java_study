package 명품자바;
import java.util.*;

class Point{
    private int x, y;
    public Point(int x, int y){
        this.x = x; this.y = y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}

class java7 {
    public static void main(String[] args){
        Vector<Point> v = new Vector<Point>();

        v.add(new Point(2, 3));
        v.add(new Point(-5,20));
        v.add(new Point(30, -8));

        v.remove(1);

        for(int i = 0; i < v.size(); i++){
            Point p = v.get(i);
            System.out.println(p);
        }
    }   
}

class ArrayListEx{
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++){
            System.out.print("이름을 입력하세요>>");
            String s = sc.next();
            a.add(s);
        }

        for(int i = 0; i < a.size();i++){
            String name = a.get(i);
            System.out.print(name + " ");
        }

        int longestIndex = 0;
        for(int i = 1; i < a.size(); i++){
            if(a.get(longestIndex).length() < a.get(i).length()){
                longestIndex = i;
            }
        }

        System.out.print("\n가장 긴 이름은 : " + a.get(longestIndex));
        sc.close();
    }
}

class IteratorEx{
    public static void main(String[] args){
        Vector<Integer> v = new Vector<>();
        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2, 100);

        Iterator<Integer> it = v.iterator();
        while(it.hasNext()){
            int n = it.next();
            System.out.println(n);
        }

        int sum = 0;
        it = v.iterator();
        while(it.hasNext()){
            int n = it.next();
            sum += n;
        }
        System.out.println("벡터에 있는 정수 합: " + sum);
    }
}

class HashMapDicEx{
    public static void main(String[] args){
        HashMap<String,String> dic = new HashMap<>();

        dic.put("baby", "아기");
        dic.put("love", "사랑");
        dic.put("apple", "사과");

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("찾고 싶은 단어는?");
            String eng = sc.next();
            if(eng.equals("exit")){
                System.out.println("종료합니다...");
                break;
            }
            String kor = dic.get(eng);
            if(kor == null) System.out.println(eng + "는 없는 단어입니다.");
            else System.out.println(kor);
        }
        sc.close();
    }
}

class HashMapScoreEx{
    public static void main(String[] args){
        HashMap<String, Integer> scoreMap = new HashMap<>();

        scoreMap.put("김은비", 97);
        scoreMap.put("하여린", 88);
        scoreMap.put("전아린", 98);
        scoreMap.put("이동건", 70);
        scoreMap.put("양승연", 99);

        System.out.println("HashMap의 요소 개수: " + scoreMap.size());

        Set<String> keys = scoreMap.keySet();
        Iterator<String> it = keys.iterator();

        while(it.hasNext()){
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name + " : " + score); //
        }
    }
}