package 시험다시풀기_java;

import java.util.*;

class S {
    int id, kor, eng, mat, sum, avg;
    String name;

    S(int id, String name, int kor, int eng, int mat) {
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        calcSum();
        calcAvg();
    }

    public void calcSum() {
        sum = kor + eng + mat;
    }

    public void calcAvg() {
        avg = sum / 3;
    }

    public void info() {
        System.out.println("[" + id + "] " + name + " : " + kor + " / " + eng + " / " + mat + " (" + sum + " / "
                + avg + ")");
    }
}

public class jb2023_41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("The number of students : ");
        int num = sc.nextInt();

        S[] s = new S[num];
        for (int i = 0; i < num; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int mat = sc.nextInt();
            s[i] = new S(id, name, kor, eng, mat);
        }

        System.out.println("[Student Information]");
        for (S i : s) {
            i.info();
        }

        S first = s[0];
        S last = s[0];

        for (int i = 1; i < num; i++) {
            if (first.sum < s[i].sum) {
                first = s[i];
            }
        }
        for (int i = 1; i < num; i++) {
            if (last.sum > s[i].sum) {
                last = s[i];
            }
        }

        System.out.print("The first place : ");
        first.info();
        System.out.print("The last place : ");
        last.info();
    }
}
