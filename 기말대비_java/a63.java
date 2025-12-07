package 기말대비_java;
import java.util.*;

public class a63 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 가능합니다.");
        String str = sc.nextLine();
        int len = str.length();
        for(int i = 0; i < len; i++){
            System.out.print(str.substring(i+1,len));
            System.out.print(str.substring(0,i+1));
            System.out.println();
        }
    }
}
