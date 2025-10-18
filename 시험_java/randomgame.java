import java.util.*;

public class randomgame {
    public static void main(String[] args) {
        try {
            while (true) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Press Enter to spin (or type 'quit' to exit) >> ");
                String E = sc.nextLine();
                if (E.equals("quit")) {
                    System.out.println("Game over.");
                    break;
                }
                int num_1 = (int) (Math.random() * 9) + 1;
                int num_2 = (int) (Math.random() * 9) + 1;
                int num_3 = (int) (Math.random() * 9) + 1;

                System.out.println("Slot: " + num_1 + " " + num_2 + " " + num_3);

                if (num_1 == num_2 && num_2 == num_3) {
                    System.out.println("Jackpot!!!!!!!!");
                } else {
                    System.out.println("try again!");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Invaild Error!");
        }
    }
}