import java.util.*;

public class FC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter a temperature (-999 to exit) >> ");
                double tem = sc.nextDouble();
                sc.nextLine();

                if (tem == -999) {
                    System.out.println("Program terminated.");
                    break;
                }

                System.out.println("Enter operator (# to F, @ to C) >>");
                String oper = sc.nextLine();

                System.out.print("Converted temperature: ");
                double F = (tem * 9 / 5) + 32;
                double C = (tem - 32) * 5 / 9;

                switch (oper) {
                    case "#":
                        System.out.printf("%.1f°F\n", F);
                        break;
                    case "@":
                        System.out.printf("%.1f°C\n", C);
                        break;
                    default:
                        break;
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("try again!");
        }
    }
}
