package 기말대비_java;
import java.util.*;
import java.io.*;

public class a82 {
    public static void main(String[] args){
        System.out.println("c:\\temp\\phone.txt를 출력합니다.");
        try{
            FileReader fin = new FileReader("c:\\temp\\phone.txt");
            int c;
            while ((c = fin.read()) != -1){
                System.out.print((char)c);
            }fin.close();
        }catch(Exception e){
            System.out.println("입출력 오류");
        }
    }
}
