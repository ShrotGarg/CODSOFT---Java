import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        balance = initialBalance;
    }

    public void deposit(double amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            System.out.println("Invalid withdrawal amount.");
        else if (amount > balance)
            System.out.println("Insufficient balance.");
        else{
            balance -= amount;
            System.out.println("Please collect ₹" + amount);
        }
    }

    public void checkBalance(){
        System.out.println("Current Balance: ₹" + balance);
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner sc;

    public ATM(BankAccount account){
        userAccount = account;
        sc = new Scanner(System.in);
    }

    public void showMenu(){
        int choice;

        do {
            System.out.println("\n\t\t ATM MENU");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    userAccount.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while(choice != 4);
    }
}


public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        ATM atmMachine = new ATM(account);
        atmMachine.showMenu();
    }
}
