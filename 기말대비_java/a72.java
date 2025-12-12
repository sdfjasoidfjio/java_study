package 기말대비_java;
import java.util.*;

public class a72 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> a = new ArrayList<>();
        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/E/F)>> ");
        for(int i = 0; i < 6; i++){
            char n = sc.next().charAt(0);
            a.add(n);
        }
        double sum = 0.0;
        double aver;
        for (int i = 0; i < a.size(); i++){
            switch(a.get(i)){
                case 'A':
                    sum += 4.0;
                    break;
                case 'B':
                    sum += 3.0;
                    break;
                case 'C':
                    sum += 2.0;
                    break;
                case 'D':
                    sum += 1.0;
                    break;
                case 'F':
                    break;
            }
        }
        aver = sum/6;
        System.out.printf("%.2f", aver);
    }
}
