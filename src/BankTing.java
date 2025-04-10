import java.util.Scanner;

public class BankTing {
    public static void main(String[] args) {
        System.out.println("welcome");
        int charge = 2;
        int pin = 1234;
        int tryCount = 0;
        int tryLimit = 3;
        Scanner scanner = new Scanner(System.in);

        while (tryCount < tryLimit) {
            System.out.print("enter pin: ");
            int enteredPin = scanner.nextInt();
            if (enteredPin != pin) {
                System.out.println("pin incorrect, Try again!");
                tryCount++;
            } else if (enteredPin == pin) {
                System.out.println("correct");
                int balance = 1000;
                int count = 0;
                int limit = 3;
                boolean bank = true;
                System.out.println("your balance: N$"+balance);
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Withdrawal (w) or Deposit(d)");
                String action = scanner1.nextLine();
                String actionToUpper = action.toUpperCase();
                if (actionToUpper.equals("W")) {
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.print("how much would you like to withdraw: ");
                    int amount = scanner2.nextInt();
                    count++;
                    if (amount > balance) {
                        System.out.println("insufficient funds");
                    }
                    else {
                        if (amount >= 20) {
                            int newBalance = balance - amount - charge;
                            Scanner scanner3 = new Scanner(System.in);
                            System.out.println("Would you like to check your balance?");
                            System.out.println("yes(y) No(n)");
                            String balanceCheck = scanner3.nextLine();
                            if (balanceCheck.equals("n")) {
                                System.out.println("Thank you, come again.");
                            } else if (balanceCheck.equals("y")) {
                                if (newBalance > 0) {
                                    System.out.println("Balance: N$"+newBalance);
                                }
                                else {
                                    System.out.println("balance: N$"+newBalance);
                                    newBalance = Math.abs(newBalance);
                                    System.out.println("you owe the bank n$"+newBalance);
                                    Scanner repeat = new Scanner(System.in);
                                }
                            }
                        }
                        else {
                            System.out.println("cant withdraw less then 20");
                        }
                    }
                } else if (actionToUpper.equals("D")) {
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("How much would you like to deposit?");
                    int amount = scanner4.nextInt();
                    count++;
                    int newBalance = balance + amount - charge;
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("Would you like to check your balance?");
                    System.out.println("yes(y) No(n)");
                    String balanceCheck = scanner5.nextLine();
                    if (balanceCheck.equals("n")) {
                        System.out.println("Thank you, come again.");
                    }
                    else {
                        System.out.println("Balance: N$"+newBalance);
                    }
                }
                break;
            }
        }
    }
}
