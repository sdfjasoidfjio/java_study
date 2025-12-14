package 기말대비_java;
import java.util.*;
import java.io.*;

public class a84 {
    public static void main(String[] args){
        File a, b;
        FileInputStream fin;
        FileOutputStream fout;
        long n, total;
        try{
            a = new File("c:\\temp\\a.jpg");
            b = new File("c:\\temp\\b.jpg");

            System.out.println(a.getName() + "를 "+ b.getName() +"로 복사합니다.");
            System.out.println("10%마다 *을 출력합니다.");
            fin = new FileInputStream(a);
            fout = new FileOutputStream(b);

            int c = 0;
            n = 0;
            total = a.length();

            while((c=fin.read()) != -1){
                fout.write((byte)c);
                n = (n+1);
                if(n==total/10){
                    System.out.print("*");
                    n=0;
                }
            }
            fin.close();
            fout.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
