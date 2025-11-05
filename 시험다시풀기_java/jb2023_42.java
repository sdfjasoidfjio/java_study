package 시험다시풀기_java;

import java.util.*;

class BankAccount {
    int accountNumber;
    String owner;
    int balance;

    BankAccount(int accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
    } // 생성자

    void deposit(int amount) {
        balance += amount;
    } // 입금 메소드

    void withdraw(int amount) {
        balance -= amount;
    } // 출금 메소드

    public void printAccount() {
        System.out.println(owner + "'s Balance : " + balance);
    } // 계좌정보 출력을 위한 메소드
}

public class jb2023_42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount user[] = { new BankAccount(1, "Kim"), new BankAccount(2, "Lee"),
                new BankAccount(3, "Park") };

        while (true) {
            System.out.print("[Menu]\n1. Account Information / 2. Deposit / 3. Withdraw / 4. Transfer/ 5. Exit\n>> ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Input the account number (<Account No.>)\n>>");
                    int num1 = sc.nextInt();

                    BankAccount target1 = null;
                    for (BankAccount s : user) {
                        if (s.accountNumber == num1) {
                            target1 = s;
                        }
                    }
                    if (target1 == null) {
                        System.out.println("Unknown Account");
                    } else {
                        target1.printAccount();
                    }
                    break;
                case 2:
                    System.out.print("Input the account number and amount (<Account No.> <Amount>)\n>> ");
                    int num2 = sc.nextInt();
                    int amount2 = sc.nextInt();

                    BankAccount target2 = null;
                    for (BankAccount s : user) {
                        if (s.accountNumber == num2) {
                            target2 = s;
                        }
                    }

                    if (target2 == null) {
                        System.out.println("Unknown Account");
                    } else if (amount2 < 0) {
                        System.out.println("The amount should be a positive number.");
                    } else {
                        target2.deposit(amount2);
                        target2.printAccount();
                    }
                    break;
                case 3:
                    System.out.print("Input the account number and amount (<Account No.> <Amount>)\n>> ");
                    int num3 = sc.nextInt();
                    int amount3 = sc.nextInt();

                    BankAccount target3 = null;
                    for (BankAccount s : user) {
                        if (s.accountNumber == num3) {
                            target3 = s;
                        }
                    }

                    if (target3 == null) {
                        System.out.println("Unknown Account");
                    } else if (amount3 < 0) {
                        System.out.println("The amount should be a positive number.");
                    } else if (amount3 > target3.balance) {
                        System.out.println("The balance is isnsufficient.");
                    } else {
                        target3.withdraw(amount3);
                        target3.printAccount();
                    }
                    break;
                case 4:
                    System.out.print(
                            "Input the account number and amount  (<Account No.(from)> <Amount> <Account No.(to)>)\n>> ");
                    int from_num4 = sc.nextInt();
                    int amount4 = sc.nextInt();
                    int to_num4 = sc.nextInt();

                    BankAccount from_target4 = null;
                    BankAccount to_target4 = null;
                    for (BankAccount s : user) {
                        if (s.accountNumber == from_num4) {
                            from_target4 = s;
                        }
                        if (s.accountNumber == to_num4) {
                            to_target4 = s;
                        }
                    }

                    if (from_target4 == null || to_target4 == null) {
                        System.out.println("Unknown Account");
                    } else if (amount4 < 0) {
                        System.out.println("The amount should be a positive number.");
                    } else if (amount4 > from_target4.balance) {
                        System.out.println("The balance is isnsufficient.");
                    } else {
                        from_target4.withdraw(amount4);
                        to_target4.deposit(amount4);
                        from_target4.printAccount();
                        to_target4.printAccount();
                    }
                    break;
                case 5:
                    System.out.print("Exit");
                    sc.close();
                    return;
            }
        }
    }
}
