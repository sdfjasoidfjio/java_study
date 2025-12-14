package 기말대비_java;
import java.util.*;
import java.io.*;

public class a83 {
    private static boolean compareFile(FileInputStream a, FileInputStream b)throws IOException{
        byte[] src = new byte[1024];
        byte[] dest = new byte[1024];

        int srcCnt = 0, destCnt = 0;
        while(true){
            srcCnt = a.read(src, 0, src.length);
            destCnt = b.read(dest, 0, dest.length);
            if(srcCnt != destCnt) return false;
            if(srcCnt == -1) break;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FileInputStream src = null;
        FileInputStream dest = null;

        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("첫번째 파일 이름을 입력하세요. >> ");
        String input1 = sc.nextLine();
        System.out.print("두번째 파일 이름을 입력하세요. >> ");
        String input2 = sc.nextLine();
        System.out.println(input1 + "와 " +input2 + "를 비교합니다.");

        try{
            src = new FileInputStream(input1);
            dest = new FileInputStream(input2);
            if(compareFile(src, dest)) System.out.println("파일이 같습니다.");
            else System.out.println("파일이 다릅니다.");
            if (src != null) src.close();
            if (dest != null) dest.close();
        }catch(Exception e){
            System.out.println("error");
        }sc.close();
    }
}
