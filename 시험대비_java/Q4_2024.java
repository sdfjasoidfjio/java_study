import java.util.*;

class BankAccount{
    private String accountHolderName;
    private double balance; 
    private static double totalBankBalance = 0;
    private static int totalAccounts = 0; 
    
    public BankAccount(String name){
        accountHolderName = name;
        balance = 0;
        totalAccounts++;
    }

    public BankAccount(String name, double initialDeposit){
        accountHolderName = name;
        balance = initialDeposit;
        totalBankBalance += initialDeposit;
        totalAccounts++;
    }

    public BankAccount(String name, double initialDeposit, double extraDeposit){
        accountHolderName = name;
        balance = initialDeposit + extraDeposit;
        totalBankBalance += balance;
        totalAccounts++;
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            totalBankBalance += amount;
            System.out.println(amount + " deposited successfully."); 
        }else{
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Withdrawal amount must be positive."); 
        }else if (amount > balance){
            System.out.println("Insufficient balance. You cannot withdraw more than the available balance.");
        } else{
            balance -= amount;
            totalBankBalance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    public void detail(){
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }

    public static double total_balance(){
        return totalBankBalance;
    }

    public static int totalAccounts(){
        return totalAccounts;
    }

}
public class Q4_2024 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[100];
        int accountCount = 0;

        while (true) { 
            System.out.println("\n=== Bank Menu ===");  // 은행 메뉴 출력
            System.out.println("1. Create new account");  // 계좌 생성 옵션 출력
            System.out.println("2. Deposit money");  // 돈 입금 옵션 출력
            System.out.println("3. Withdraw money");  // 돈 인출 옵션 출력
            System.out.println("4. View account details");  // 계좌 세부정보 보기 옵션 출력
            System.out.println("5. View total bank balance");  // 총 은행 잔고 보기 옵션 출력
            System.out.println("6. View total number of accounts");  // 총 계좌 수 보기 옵션 출력
            System.out.println("7. Exit");  // 프로그램 종료 옵션 출력
            System.out.print("Choose an option: ");  // 옵션 선택 안내 출
            int num = sc.nextInt();

            switch(num){
                case 1:
                    System.out.println("Enter the account holder's name: ");  // 계좌 소유자 이름 입력 요청
                    String name = sc.next();  // 계좌 소유자 이름 입력 받기
                    System.out.println("Enter initial deposit (or 0 for none): ");  // 초기 입금 요청
                    double initialDeposit = sc.nextDouble();  // 초기 입금 입력 받기
                    System.out.println("Enter extra deposit (or 0 if none): ");  // 추가 입금 요청
                    double extraDeposit = sc.nextDouble();  // 추가 입금 입력 받기

                    if (extraDeposit > 0) {
                        accounts[accountCount] = new BankAccount(name, initialDeposit, extraDeposit);
                    } else if (initialDeposit > 0) {
                        accounts[accountCount] = new BankAccount(name, initialDeposit);
                    } else {
                        accounts[accountCount] = new BankAccount(name);
                    }
                    accountCount++;
                    System.out.println("Account created successfully.");
                    break;
                case 2:
                    System.out.print("Enter account number (0 to " + (accountCount - 1) + "): ");
                    int accNo = sc.nextInt();
                    if (accNo >= 0 && accNo < accountCount) {
                        System.out.print("Enter deposit amount: ");
                        double amount = sc.nextDouble();
                        accounts[accNo].deposit(amount);
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;
                 case 3: // 출금
                    System.out.print("Enter account number (0 to " + (accountCount - 1) + "): ");
                    accNo = sc.nextInt();
                    if (accNo >= 0 && accNo < accountCount) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = sc.nextDouble();
                        accounts[accNo].withdraw(amount);
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;

                case 4: // 계좌 세부정보 보기
                    System.out.print("Enter account number (0 to " + (accountCount - 1) + "): ");
                    accNo = sc.nextInt();
                    if (accNo >= 0 && accNo < accountCount) {
                        accounts[accNo].detail();
                    } else {
                        System.out.println("Invalid account number.");
                    }
                    break;
                case 5:  // 총 은행 잔고 보기 선택
                    System.out.println("Total bank balance: " + BankAccount.total_balance());  // 총 은행 잔고 출력
                    break;
                case 6:  // 총 계좌 수 보기 선택
                    System.out.println("Total number of accounts: " + BankAccount.totalAccounts());  // 총 계좌 수 출력
                    break;
                case 7:  // 프로그램 종료 선택
                    System.out.println("Exiting the program.");  // 종료 메시지 출력
                    sc.close();  // Scanner 닫기
                    return;  // 프로그램 종료
                default:  
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
