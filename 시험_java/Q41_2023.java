import java.util.*;

class Student {
    String name;
    int id, K, E, M, sum, avg;

    Student(int id, String name, int K, int E, int M) {
        this.id = id;
        this.name = name;
        this.K = K;
        this.E = E;
        this.M = M;
        Sumcalculate();
        Avgcalculate();
    }

    public void Sumcalculate() {
        sum = K + E + M;
    }

    public void Avgcalculate() {
        avg = sum / 3;
    }

    public void showInfo() {
        System.out.println("[" + id + "] " + name + " : " + K + " / " + E + " / " + M +
                " ( " + sum + " / " + avg + " )");
    }
}

public class Q41_2023 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("The number of students : ");
        int n = sc.nextInt();

        Student[] s = new Student[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int K = sc.nextInt();
            int E = sc.nextInt();
            int M = sc.nextInt();
            s[i] = new Student(id, name, K, E, M);
        }

        System.out.println("[Student Information]");
        for (Student st : s) {
            st.showInfo();
        }

        Student first = s[0];
        Student last = s[0];

        for (int i = 1; i < n; i++) {
            if (s[i].sum > first.sum)
                first = s[i];
            if (s[i].sum < last.sum)
                last = s[i];
        }
        System.out.print("The first place : ");
        first.showInfo();
        System.out.print("The last place : ");
        last.showInfo();

    }
}
