import java.util.*;

public class Q3_2023 {
    public static void main(String[] args) {
        String com[] = { "Scissors", "Rock", "Paper" };
        System.out.println("Two people (A user, B user(computer) play a S-R-P game");
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (true) {
            try {
                System.out.print("Scissors, Rock, Paper >>");
                String user = sc.nextLine();

                if (user.equals("quit")) {
                    System.out.println("game end ...");
                    break;
                }

                String computer = com[index];
                System.out.print("A user = " + user + ", B user(computer) = " + computer + ", ");

                if (user.equals("paper")) {
                    System.out.println("Try again.");
                    continue;
                } else if (user.equals("Paper"))
                    System.out.println("B user(computer) win.");
                else if (user.equals("Rock"))
                    System.out.println("same.");
                else if (user.equals("Scissors"))
                    System.out.println("A user win");
                else
                    System.out.println("Invalid input");

                if (index > 2) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                index++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("OutOfBounds Exception!! Enter quit to end game");
            }
        }
        sc.close();
    }
}
