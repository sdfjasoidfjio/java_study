package 시험다시풀기_java;

import java.util.*;

class BankAccount {
    private String accountHolderName; // 계좌 소유자의 이름을 저장하는 인스턴스 필드
    private double balance; // 계좌 잔액을 저장하는 인스턴스 필드
    private static double totalBankBalance = 0; // 총 은행 잔고를 저장하는 정적 필드
    private static int totalAccounts = 0; // 총 계좌 수를 저장하는 정적 필드
    // accountHolderName을 초기화하고 초기 잔액을 0으로 설정하는 생성자

    BankAccount(String name) {
        accountHolderName = name; // 계좌 소유자의 이름을 설정
        balance = 0; // 초기 잔액을 0으로 설정
        totalAccounts++; // 총 계좌 수를 증가시킴
    }

    // accountHolderName과 제공된 초기 입금으로 잔액을 초기화하는 생성자
    public BankAccount(String name, double initialDeposit) {
        accountHolderName = name; // 계좌 소유자의 이름을 설정
        balance = initialDeposit; // 잔액을 초기 입금으로 설정
        totalBankBalance += initialDeposit; // 총 은행 잔고를 업데이트
        totalAccounts++; // 총 계좌 수를 증가시킴
    }

    // accountHolderName과 초기 입금 및 추가 입금의 합으로 잔액을 초기화하는 생성자
    public BankAccount(String name, double initialDeposit, double extraDeposit) {
        accountHolderName = name; // 계좌 소유자의 이름을 설정
        balance = initialDeposit + extraDeposit; // 잔액을 초기 입금과 추가 입금의 합으로 설정
        totalBankBalance += (initialDeposit + extraDeposit); // 총 은행 잔고를 업데이트
        totalAccounts++; // 총 계좌 수를 증가시킴
    }

    // 돈을 입금하는 메서드 (부정적인 입금은 허용되지 않음)
    public void deposit(double amount) {
        if (amount > 0) { // 입금 금액이 양수인 경우
            balance += amount; // 잔액에 입금 금액을 추가
            totalBankBalance += amount; // 총 은행 잔고를 업데이트
            System.out.println(amount + " deposited successfully."); // 성공 메시지 출력
        } else {
            System.out.println("Deposit amount must be positive."); // 오류 메시지 출력
        }
    }

    // 돈을 인출하는 메서드 (부정적인 인출은 허용되지 않으며, 인출은 현재 잔액을 초과할 수 없음)
    public void withdraw(double amount) {
        if (amount <= 0) { // 인출 금액이 0 이하인 경우
            System.out.println("Withdrawal amount must be positive."); // 오류 메시지 출력
        } else if (amount > balance) { // 인출 금액이 현재 잔액을 초과하는 경우
            System.out.println("Insufficient balance. You cannot withdraw more than the available balance."); // 오류 메시지
                                                                                                              // 출력
        } else {
            balance -= amount; // 잔액에서 인출 금액을 차감
            totalBankBalance -= amount; // 총 은행 잔고를 업데이트
            System.out.println(amount + " withdrawn successfully."); // 성공 메시지 출력
        }
    }

    // 계좌 세부정보를 출력하는 메서드
    public void Info() {
        System.out.println("Account Holder: " + accountHolderName); // 계좌 소유자 이름 출력
        System.out.println("Current Balance: " + balance); // 현재 잔액 출력
    }

    // 총 은행 잔고를 가져오는 정적 메서드
    public static double getTotalBankBalance() {
        return totalBankBalance; // 총 은행 잔고 반환
    }

    // 총 계좌 수를 가져오는 정적 메서드
    public static int getTotalAccounts() {
        return totalAccounts; // 총 계좌 수 반환
    }
}

public class jb2024_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        BankAccount[] accounts = new BankAccount[100]; // 여러 계좌(100)를 저장할 배열
        int accountCount = 0; // 현재 계좌 수를 추적하는 변수
        while (true) { // 무한 루프 시작
            System.out.println("\n=== Bank Menu ==="); // 은행 메뉴 출력
            System.out.println("1. Create new account"); // 계좌 생성 옵션 출력
            System.out.println("2. Deposit money"); // 돈 입금 옵션 출력
            System.out.println("3. Withdraw money"); // 돈 인출 옵션 출력
            System.out.println("4. View account details"); // 계좌 세부정보 보기 옵션 출력
            System.out.println("5. View total bank balance"); // 총 은행 잔고 보기 옵션 출력
            System.out.println("6. View total number of accounts"); // 총 계좌 수 보기 옵션 출력
            System.out.println("7. Exit"); // 프로그램 종료 옵션 출력
            System.out.print("Choose an option: "); // 옵션 선택 안내 출력
            int num = scanner.nextInt(); // 사용자 입력 받기
            switch (num) { // 사용자 선택에 따라 분기
                case 1: // 계좌 생성 선택
                    System.out.println("Enter the account holder's name: "); // 계좌 소유자 이름 입력 요청
                    String name = scanner.nextLine(); // 계좌 소유자 이름 입력 받기
                    System.out.println("Enter initial deposit (or 0 for none): "); // 초기 입금 요청
                    double initialDeposit = scanner.nextDouble(); // 초기 입금 입력 받기
                    System.out.println("Enter extra deposit (or 0 if none): "); // 추가 입금 요청
                    double extraDeposit = scanner.nextDouble(); // 추가 입금 입력 받기
                    // 추가 입금이 있는 경우
                    if (extraDeposit > 0) {
                        accounts[accountCount] = new BankAccount(name, initialDeposit, extraDeposit); // 계좌 생성
                    }
                    // 초기 입금만 있는 경우
                    else if (initialDeposit > 0) {
                        accounts[accountCount] = new BankAccount(name, initialDeposit); // 계좌 생성
                    }
                    // 입금이 없는 경우
                    else {
                        accounts[accountCount] = new BankAccount(name); // 계좌 생성
                    }
                    accountCount++; // 계좌 수 증가
                    System.out.println("Account created successfully."); // 계좌 생성 성공 메시지 출력
                    break;
                case 2: // 돈 입금 선택
                    System.out.println("Enter account number (0 to " + (accountCount - 1) + "): "); // 계좌 번호 입력 요청
                    int accNo = scanner.nextInt(); // 계좌 번호 입력 받기
                    if (accNo >= 0 && accNo < accountCount) { // 유효한 계좌 번호인 경우
                        System.out.print("Enter deposit amount: ");
                        double amount = scanner.nextDouble();
                        accounts[accNo].deposit(amount); // 계좌 세부정보 메서드 호출
                    } else {
                        System.out.println("Invalid account number."); // 유효하지 않은 계좌 번호 메시지 출력
                    }
                    break;
                case 3:
                    System.out.println("Enter account number (0 to " + (accountCount - 1) + "): "); // 계좌 번호 입력 요청
                    int accNo1 = scanner.nextInt(); // 계좌 번호 입력 받기
                    if (accNo1 >= 0 && accNo1 < accountCount) { // 유효한 계좌 번호인 경우
                        System.out.print("Enter withdraw amount: ");
                        double amount = scanner.nextDouble();
                        accounts[accNo1].withdraw(amount); // 계좌 세부정보 메서드 호출
                    } else {
                        System.out.println("Invalid account number."); // 유효하지 않은 계좌 번호 메시지 출력
                    }
                    break;
                case 4:
                    System.out.println("Enter account number (0 to " + (accountCount - 1) + "): "); // 계좌 번호 입력 요청
                    int accNo2 = scanner.nextInt(); // 계좌 번호 입력 받기
                    if (accNo2 >= 0 && accNo2 < accountCount) { // 유효한 계좌 번호인 경우
                        accounts[accNo2].Info();
                    } else {
                        System.out.println("Invalid account number."); // 유효하지 않은 계좌 번호 메시지 출력
                    }
                    break;
                case 5: // 총 은행 잔고 보기 선택
                    System.out.println("Total bank balance: " + BankAccount.getTotalBankBalance()); // 총 은행 잔고 출력
                    break;
                case 6: // 총 계좌 수 보기 선택
                    System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts()); // 총 계좌 수 출력
                    break;
                case 7: // 프로그램 종료 선택
                    System.out.println("Exiting the program."); // 종료 메시지 출력
                    scanner.close(); // Scanner 닫기
                    return; // 프로그램 종료
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
