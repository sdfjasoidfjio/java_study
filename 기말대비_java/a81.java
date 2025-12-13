package 기말대비_java;
import java.io.FileWriter;
import java.util.*;

public class a81 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("전화번호 입력 프로그램입니다.");
        try{
            FileWriter fout = new FileWriter("c:\\temp\\phone.txt");
            while(true){
                System.out.print("이름 전화번호 >> ");
                String input = sc.nextLine();
                if (input.equals("그만")) break;
                fout.write(input);
                fout.write("\n");
            }
            fout.close();
            System.out.println("c:\\temp\\phone.txt에 저장하였습니다.");
        }catch(Exception e){
            System.out.println("입출력 오류");
        }sc.close();
    }
}
