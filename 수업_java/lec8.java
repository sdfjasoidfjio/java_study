package 수업_java;
import java.io.*;
import java.util.*;

class FileReader {
    public static void main(String[] args){
        InputStreamReader in = null;
        FileInputStream fin = null;
        try{
            fin = new FileInputStream("c:\\Users\\82105\\Desktop\\hangul.txt");
            in = new InputStreamReader(fin, "MS949");
            int c;

            System.out.println("인코딩 문자 집합은 " +  in.getEncoding());
            while ((c = in.read()) != -1){
                System.out.print((char)c);
            }
            in.close();
            fin.close();
        }catch(IOException e){
            System.out.println("입출력 오류");
        }
    }
}

class FileWrite{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FileWriter fout = null;
        int c;
        try{
            fout = new FileWriter("c:\\Users\\82105\\Desktop\\test.txt");
            while (true){
                String line = sc.nextLine();
                if(line.length() == 0) break;
                fout.write(line, 0, line.length());
                fout.write("\r\n", 0, 2);
            }
            fout.close();
        }catch (IOException e){
            System.out.println("입출력 오류");
        }
        sc.close();
    }
}


class FileOutputStreamEx{
    public static void main(String[] args){
        byte b[] = {7, 51, 3, 4, -1, 24};
        try{
            FileOutputStream fout =  new FileOutputStream("c:\\Users\\82105\\Desktop\\test.txt");
            for(int i = 0; i< b.length; i++){
                fout.write(b[i]);
            }
            fout.close();
        }
        catch(IOException e){
            System.out.println("경로명을 확인해주세요");
            return;
        }
        System.out.println("저장하였습니다.");
    }
}

class FileInputStreamEx{
    public static void main(String[] args){
        byte b[] = new byte[6];
        try{
            FileInputStream fin = new FileInputStream("c:\\Users\\82105\\Desktop\\test.txt");
            int n = 0, c;
            while((c = fin.read()) != -1){
                b[n] = (byte)c;
                n++;
            }
            System.out.println("배열을 출력합니다.");
            for(int i = 0; i < b.length; i++)System.out.print(b[i] + " ");
            System.out.println();
            fin.close();
        }catch (IOException e){
            System.out.println("경로명을 체크해보세요");
        }
    }
}

class BufferdIOEx{
    public static void main(String[] args){
        FileReader fin = null;
        int c;
        try{
            fin = new FileReader("c:\\Users\\82105\\Desktop\\test.txt");
            BufferedInputStream out = new BufferedInputStream(System.out, 5);
            while((c=fin.read()) != -1) out.write(c);

            new Scanner(System.in).nextLine();
            out.flush();
            fin.close();
            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}