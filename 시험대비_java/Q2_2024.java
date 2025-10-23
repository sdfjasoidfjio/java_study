import java.util.*;

public class Q2_2024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of classes : ");
        int numberOfClasses = sc.nextInt();
        int [][] grades = new int[numberOfClasses][];

        for(int i = 0; i < grades.length; i++){
            System.out.print("Number of students of class " + (i+1) +": ");
            int numberOfStudents = sc.nextInt();
            grades[i] = new int[numberOfStudents];
        }
        int no = 1;
        for (int [] item: grades){
            System.out.println("Class " + no++ + " ==> ");
            for(int i = 0; i < item.length; i++){
                while (true) { 
                    try {
                        System.out.print(i+1 + "th student's score (0-100): ");
                        int score = sc.nextInt();

                        if(score < 0 || 100 < score){
                            System.out.println("Score should be between 0 and 100");
                            continue;
                        }else{
                            item[i] = score;
                            break;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Invaild input. Enter Integer number.");
                        sc.nextLine();
                    }
                }
            }
        }
        for(int[] item : grades){
            int sum = 0;
            for(int score : item){
                sum += score;
            }

            double average = (double) sum / item.length;
            System.out.printf("Average score: %.2f\n", average);
        }
    }
}
