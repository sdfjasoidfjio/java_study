import java.util.*;

class BankAccount {
    int accountNumber;
    String owner;
    int balance;

    BankAccount(int accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    } // 생성자

    void deposit(int amount) {
        this.balance += amount;
    } // 입금 메소드

    void withdraw(int amount) {
        this.balance -= amount;
    } // 출금 메소드

    public void printAccount() {
        System.out.println(owner + "'s Balance : " + balance);
    } // 계좌정보 출력을 위한 메소드
}

public class Q42_2023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount user[] = { new BankAccount(1, "Kim"), new BankAccount(2, "Lee"), new BankAccount(3,
                "Park") };

        while (true) {
            System.out.print("[Menu]\n1. Account Information / 2. Deposit / 3. Withdraw / 4. Transfer / 5. Exit\n>> ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Input the account number (<Account No.>)\n>>");
                    int S = sc.nextInt();
                    if (S < 1 || S > user.length) {
                        System.out.println("Unknown Account");
                    } else {
                        user[S - 1].printAccount();
                    }
                    break;
                case 2:
                    System.out.print("Input the account number and amount (<Account No.> <Amount>)\n>>");
                    int in_num = sc.nextInt();
                    int in_amo = sc.nextInt();

                    BankAccount target = null;
                    for (BankAccount s : user) {
                        if (s.accountNumber == in_num) {
                            target = s;
                        }
                    }

                    if (target == null) {
                        System.out.println("Unknown Account");
                    } else if (in_amo < 0) {
                        System.out.println("The amount should be a positive number.");
                    } else {
                        target.deposit(in_amo);
                        target.printAccount();
                    }
                    break;
                case 3:
                    System.out.print("Input the account number and amount (<Account No.> <Amount>)\n>> ");
                    int out_num = sc.nextInt();
                    int out_amo = sc.nextInt();

                    BankAccount target2 = null;
                    for (BankAccount s : user) {
                        if (s.accountNumber == out_num) {
                            target2 = s;
                            break;
                        }
                    }

                    if (target2 == null) {
                        System.out.println("Unknown Account");
                    } else if (out_amo < 0) {
                        System.out.println("The amount should be a positive number.");
                    } else if (out_amo > target2.balance) {
                        System.out.println("The balance is insufficient.");
                    } else {
                        target2.withdraw(out_amo);
                        target2.printAccount();
                    }
                    break;
                case 4:
                    System.out.print(
                            "Input the account number and amount (<Account No.(from)> <Amount> <Account No.(to)>)\n>> ");
                    int from_num = sc.nextInt();
                    int from_to_amo = sc.nextInt();
                    int to_num = sc.nextInt();

                    BankAccount target_from = null; // 보내는 계좌
                    for (BankAccount s : user) {
                        if (s.accountNumber == from_num) {
                            target_from = s;
                            break;
                        }
                    }
                    BankAccount target_to = null; // 받는 계좌
                    for (BankAccount s : user) {
                        if (s.accountNumber == to_num) {
                            target_to = s;
                            break;
                        }
                    }

                    if (target_from == null || target_to == null) {
                        System.out.println("Unknown Account");
                    } else if (from_to_amo < 0) {
                        System.out.println("The amount should be a positive number.");
                    } else if (from_to_amo > target_from.balance) {
                        System.out.println("The balance is insufficient.");
                    } else {
                        target_from.withdraw(from_to_amo);
                        target_to.deposit(from_to_amo);
                        target_from.printAccount();
                        ;
                        target_to.printAccount();
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    sc.close();
                    return;
            }

        }
    }
}