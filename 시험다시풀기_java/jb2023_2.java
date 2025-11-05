package 시험다시풀기_java;

import java.util.*;

public class jb2023_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String com[] = { "Scissors", "Rock", "Paper" };
        int index = 0;

        System.out.println("Two people (A user, B user(computer) play a S-R-P game");
        while (true) {
            System.out.print("Scissors, Rock, Paper >> ");
            String user = sc.nextLine();

            if (user.equals("quit")) {
                System.out.println("game end ...");
                break;
            }
            try {
                String computer = com[index];
                if (user.equals("paper")) {
                    System.out.println("A user = " + user + " , B user(computer) = " + computer + ", Try again");
                    continue;
                } else if (user.equals("Paper")) {
                    System.out.println(
                            "A user = " + user + " , B user(computer) = " + computer + ", B user(computer) win.");
                } else if (user.equals("Rock")) {
                    System.out.println(
                            "A user = " + user + " , B user(computer) = " + computer + ", Same");
                } else if (user.equals("Scissors")) {
                    System.out.println(
                            "A user = " + user + " , B user(computer) = " + computer + ", A user win.");
                }
                if (index >= com.length)
                    throw new ArrayIndexOutOfBoundsException();

                index++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("OutOfBounds Exception!! Enter quit to end game");
            }
        }
    }
}
