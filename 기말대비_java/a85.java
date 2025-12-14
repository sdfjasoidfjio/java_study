package 기말대비_java;
import java.util.*;
import java.io.*;

public class a85 {
    public static void main(String[] args){
        File f; //기준이 되는 폴더
        File sub[]; //c:\\ 안에 들어있는 파일
        try{
            f = new File("c:\\");
            sub = f.listFiles(); //c:\\안에 있는 모든 항목을 file객체 배열로 가져옴

            long max = -1;
            int Max = -1;
            for (int i = 0; i < sub.length; i++){ //비교
                if (max < sub[i].length()){
                    max = sub[i].length();
                    Max = i;
                }
            }
            System.out.println("가장 큰 파일은 " + sub[Max].getPath() + " " + sub[Max].length() + "바이트");
        } catch(Exception e){

        }
    }
}
