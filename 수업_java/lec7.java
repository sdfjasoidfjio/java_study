package 수업_java;
import java.util.*;

class Point0{
    private int x, y;
    public Point0(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
}

class lec7 {
    public static void main(String[] args){
        Vector<Point0> v = new Vector<Point0>();

        v.add(new Point0(2,3));
        v.add(new Point0(-5,20));
        v.add(new Point0(30,-8));

        v.remove(1);

        for(int i = 0; i < v.size();i++){
            Point0 p = v.get(i);
            System.out.println(p);
        }
    }
}

class ArrayListEx{
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++){
            System.out.print("이름을 입력하세요>>");
            String s = sc.next();
            a.add(s);
        }

        for(int i = 0; i <a.size();i++){
            String name = a.get(i);
            System.out.print(name+" ");
        }
        int longestIndex = 0;
        for(int i = 1; i <a.size();i++){
            if(a.get(longestIndex).length() < a.get(i).length()){
                longestIndex = i;
            }
        }
        System.out.println("\n가장 긴 이름은: "+ a.get(longestIndex));
        sc.close();
    }
}

class IteratorEx{
    public static void main(String[] args){
        Vector<Integer> v = new Vector<Integer>();

        v.add(5);
        v.add(4);
        v.add(-1);
        v.add(2,100);

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
        System.out.println("벡터에 있는 정수 합: "+sum);
    }
}

class HashMapDicEx{
    public static void main(String[] args){
        HashMap<String, String> dic = new HashMap<String,String>();

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
        HashMap<String,Integer> scoreMap = new HashMap<String, Integer>();

        scoreMap.put("김은비", 97);
		scoreMap.put("하여린", 88);
		scoreMap.put("전아린", 98);
		scoreMap.put("이동건", 70);
		scoreMap.put("양승연", 99);

        System.out.println("HashMap의 요소 개수: "+ scoreMap.size());

        Set<String> keys = scoreMap.keySet();

        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name + " : " + score);
        }
    }
}

class Student0{
    int id;
    String tel;
    public Student0(int id, String tel){
        this.id = id; this.tel = tel;
    }
    public int getId() {
        return id;
    }
    public String getTel(){
        return tel;
    }
}

class HashMapStudentEx{
    public static void main(String[] args){
        HashMap<String, Student0> map = new HashMap<String, Student0>();

        map.put("황기태", new Student0(1, "010-111-1111"));
        map.put("이재문", new Student0(2, "010-222-2222"));
        map.put("정인환", new Student0(3, "010-333-3333"));

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("검색할 이름?");
            String name = sc.nextLine();
            if(name.equals("exit")) break;

            Student0 student = map.get(name);
            if(student == null) System.out.println(name + "는(은) 없는 사람입니다.");
            else System.out.println("id: " + student.getId() + ", 전화: "+ student.getTel());
        }
        sc.close();
    }
}

class ToeicScoreManager{
    public static void main(String[] args){
        HashMap<String,Vector<Integer>> map = new HashMap<String, Vector<Integer>>();
        Scanner sc = new Scanner(System.in);

        map.put("한지운" , new Vector<Integer>());
		map.put("김하진" , new Vector<Integer>());
		map.put("하여린" , new Vector<Integer>());
		map.put("윤단비" , new Vector<Integer>());

        System.out.println("등록된 학생: 한지운, 김하진, 하여린, 윤단비 4명입니다.");
        while(true){
            System.out.print("이름과 점수들>>");
            String line = sc.nextLine();
            if(line.equals("그만")) break;
            String [] tokens = line.split(" ");
            String name = tokens[0];
            Vector<Integer> v = map.get(name);
            if(v==null){
                System.out.println(name +"은 없는 학생입니다.");
                continue;
            }
            for(int i = 0; i < tokens.length-1; i++){
                v.add(Integer.parseInt(tokens[i+1]));
            }
            if(v.size() == 0){
                System.out.println(name + "은 토익 점수가 없습니다.");
                continue;
            }
            for(int score : v) System.out.print(score + " ");
            System.out.println();
        }
        sc.close();
    }
}

class CollectionEx{
    static void printList(LinkedList<String> I){
        Iterator <String> iterator = I.iterator();
        while(iterator.hasNext()){
            String e = iterator.next();
            String separator;
            if(iterator.hasNext()) separator = "->";
            else separator = "\n";
            System.out.print(e+separator);
        }
    }
    public static void main(String[] args){
        LinkedList<String> myList = new LinkedList<String>();
        myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0,"터미네이터");
		myList.add(2,"아바타");

        Collections.sort(myList);
        printList(myList);

        Collections.reverse(myList);
        printList(myList);

        int index = Collections.binarySearch(myList, "아바타") + 1;
        System.out.println("아바타는 " + index + "번째 요소입니다. ");
    }
}

class GStack<T>{
    int tos;
    Object [] stck;
    public GStack() {
        tos = 0;
        stck = new Object[10];
    }
    public void push(T item){
        if(tos == 10) return;
        stck[tos] = item;
        tos ++;
    }
    public T pop(){
        if(tos == 0) return null;
        tos--;
        return (T)stck[tos];
    }
}

class MyStack{
    public static void main(String[] args){
        GStack <String> stringStack = new GStack<String>();
        stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");

        for(int i = 0; i < 3; i++){
            System.out.println(stringStack.pop());
        }

        GStack<Integer> intStack = new GStack<Integer>();
        intStack.push(1);
        intStack.push(3);
		intStack.push(5);

        for(int i = 0; i < 3; i++){
            System.out.println(intStack.pop());
        }
    }
}

class GenericMethodEx{
    public static <T> GStack <T> reverse(GStack<T> a){
        GStack<T> s = new GStack<T>();
        while(true){
            T tmp;
            tmp = a.pop();
            if(tmp == null) break;
            else s.push(tmp);
        }
        return s;
    }
    public static void main(String[] args){
        GStack<Double> gs = new GStack<Double>();

        for(int i = 0; i < 5; i++){
            gs.push(new Double(i));
        }

        gs = reverse(gs);
        for(int i = 0; i < 5; i++){
            System.out.println(gs.pop());
        }
    }
}