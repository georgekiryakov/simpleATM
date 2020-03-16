import java.util.Scanner;

public class bankingApp {
    public static void main(String[] args) {
        bankAccount object = new bankAccount();
        object.showMenu();


    }
}

class bankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(int amount) {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }
    }

    void showMenu() {
        char option = '\0';

        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your ID " + customerID + ".");
        System.out.println("\n");
        System.out.println("A. Check Balance.");
        System.out.println("B. Deposit.");
        System.out.println("C. Withdraw.");
        System.out.println("D. Previous Transaction.");
        System.out.println("E. Exit.");


        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("================");
            System.out.println("Enter an option.");
            System.out.println("================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'A':
                    System.out.println("------------------");
                    System.out.println("Balance = "+balance);
                    System.out.println("------------------");
                    break;
                case 'B':
                    System.out.println("----------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("----------------------------");
                    int amountDeposit = scanner.nextInt();
                    if(amountDeposit > 0){
                        deposit(amountDeposit);
                        System.out.println("----------------------------------------");
                        System.out.println("Your deposit has been successfully made.");
                        System.out.println("----------------------------------------");
                    }else{
                        System.out.println("---------------");
                        System.out.println("Invalid amount!");
                        System.out.println("---------------");
                    }
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("---------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("---------------------------");
                    int amountWithdraw = scanner.nextInt();
                    if(amountWithdraw > 0 && amountWithdraw <= balance){
                        withdraw(amountWithdraw);
                        System.out.println("-------------------------------------------");
                        System.out.println("You have successfully withdrawn the amount.");
                        System.out.println("-------------------------------------------");
                    }else{
                        System.out.println("----------------------------------");
                        System.out.println("Invalid amount or invalid balance.");
                        System.out.println("----------------------------------");
                    }
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("---------------------------");
                    getPreviousTransaction(previousTransaction);
                    System.out.println("---------------------------");
                    break;
                case 'E':
                    System.out.println("***************************");
                    break;
                default:
                    System.out.println("Invalid request! Please enter again.");
                    break;
            }
        }while (option !='E');
        System.out.println("Thank you for using our services!");
    }
}



