import javax.swing.*;

public class Bank {

    static int amount;
    static int tryLimit;
    static int tryCount;
    static int newAmount;
    static int chancesLeft;
    static int balance = 1000;
    static int anotherTransaction;
    static int transferLoopCount = 0;
    static String action;
    static String account;
    static String enteredPin;
    static String withdrawalType;
    static boolean depositLoop = true;
    static boolean actionChoiceLoop = true;
    static boolean withdrawalTypeLoop = true;

    public static void main(String[] args) {

        String pin = "1234";
        tryCount = 0;
        tryLimit = 3;

        JOptionPane.showMessageDialog(null, "welcome to TANGI bank");

        while (tryCount <= tryLimit) {

            JPasswordField pField = new JPasswordField();
            JOptionPane.showConfirmDialog(null, pField, "Enter PIN", JOptionPane.OK_CANCEL_OPTION);
            enteredPin = new String(pField.getPassword());

            if (enteredPin.length() == 4) {
                if (!(enteredPin.equals(pin))) {
                    incorrectPin();
                }
                else {
                    actionChoice();
                    break;
                }
            }
            else {
                if (enteredPin.length() > 4) {
                    tryCount++;
                    if (tryCount == tryLimit) {
                        JOptionPane.showMessageDialog(null, "contact your bank pls");
                        tryCount = 100;
                    }
                    else {
                        chancesLeft = tryLimit - tryCount;
                        if (chancesLeft == 1) {
                            JOptionPane.showMessageDialog(null, "pin must only be 4 digits long.\nTry again.("+chancesLeft+" chance left)");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "pin must only be 4 digits long.\nTry again.("+chancesLeft+" chances left)");
                        }

                    }
                }
                else {
                    tryCount++;

                    if (tryCount == tryLimit) {
                        JOptionPane.showMessageDialog(null, "contact your bank pls");
                        tryCount = 100;
                    }
                    else if (enteredPin.isEmpty()){
                        tryCount--;
                        JOptionPane.showMessageDialog(null, "no entry made");
                    }
                    else {
                        chancesLeft = tryLimit - tryCount;
                        if (chancesLeft == 1) {
                            JOptionPane.showMessageDialog(null, "pin entered is too short\nTry again.("+chancesLeft+" chance left)");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "pin entered is too short\nTry again.("+chancesLeft+" chances left)");
                        }

                    }
                }
            }
        }
    }

    public static void balanceCheck() {

        if (balance > 0) {
            JOptionPane.showMessageDialog(null, "Current balance: N$" + balance);
            anotherTransactionStill();
        }
        else {
            balance = Math.abs(balance);
            JOptionPane.showMessageDialog(null, "You owe the bank N$" + balance);
            anotherTransactionStill();
        }
    }

    public static void anotherTransactionStill(){

        anotherTransaction = JOptionPane.showConfirmDialog(null, "would you like to do another transaction:");
        if (anotherTransaction == 0) {
            actionChoice();
        }
        else if (anotherTransaction == 1) {
            JOptionPane.showMessageDialog(null, "Thank you, come again.");
        }
        else {
            JOptionPane.showMessageDialog(null, "invalid response.");
            anotherTransactionStill();
        }
    }

    public static void actionChoice() {

        balance = balance - 5;

        while (actionChoiceLoop) {
            action = JOptionPane.showInputDialog("Select a transaction:\n(1)Withdrawal\n(2)Deposit\n(3)Transfer\n(4)Check balance\n(5)Cancel");
            if (action.equalsIgnoreCase("1") || action.equalsIgnoreCase("W")) {
                withdrawal();
                actionChoiceLoop = false;
            }
            else if (action.equalsIgnoreCase("2") || action.equalsIgnoreCase("D")) {
                deposit();
                actionChoiceLoop = false;
            }
            else if (action.equalsIgnoreCase("3") || action.equalsIgnoreCase("T")) {
                transfer();
                actionChoiceLoop = false;
            }
            else if (action.equalsIgnoreCase("4") || action.equalsIgnoreCase("B")) {
                balanceCheck();
                actionChoiceLoop = false;
            }
            else if (action.equalsIgnoreCase("5") || action.equalsIgnoreCase("c")) {
                JOptionPane.showMessageDialog(null, "Thank you, come again.");
                tryCount = 4;
                actionChoiceLoop = false;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid choice.");
                actionChoiceLoop = true;
            }
        }
    }

    public static void withdrawal() {

        JOptionPane.showMessageDialog(null, "service fee of N$9.99 on withdrawals above N$499");

        while (withdrawalTypeLoop) {

            withdrawalType = JOptionPane.showInputDialog("How much would you like to withdraw:\n(0)To enter specific amount\n(1)N$20\n(2)N$50\n(3)N$100\n(4)N$200");

            switch (withdrawalType) {
                case "0":
                    amount = Integer.parseInt(JOptionPane.showInputDialog("enter amount"));
                    while ((amount % 10 != 0) || (amount > balance) || (amount < 0) ) {
                        if (amount > balance && amount > 0) {
                            JOptionPane.showMessageDialog(null, "Insufficient funds.");
                            actionChoice();
                        }
                        else {
                            amount = Integer.parseInt(JOptionPane.showInputDialog("invalid amount, try again."));
                        }
                    }

                    if (amount > 499) {
                        balance = balance - amount - 10;
                        balanceCheck();
                    }
                    else {
                        balance = balance - amount;
                        balanceCheck();
                    }
                    withdrawalTypeLoop = false;
                    break;

                case "1":
                    balance = balance - 20 - 10;
                    balanceCheck();
                    withdrawalTypeLoop = false;
                    break;

                case "2":
                    balance = balance - 50 - 10;
                    balanceCheck();
                    withdrawalTypeLoop = false;
                    break;

                case "3":
                    balance = balance - 100 - 10;
                    balanceCheck();
                    withdrawalTypeLoop = false;
                    break;

                case "4":
                    balance = balance - 200 - 10;
                    balanceCheck();
                    withdrawalTypeLoop = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "invalid response","ERROR", JOptionPane.ERROR_MESSAGE);
                    withdrawalTypeLoop = true;
            }
        }
    }

    public static void deposit() {

        while (depositLoop) {
            amount = Integer.parseInt(JOptionPane.showInputDialog("service fee of N$5 on deposits\nHow much would you like to deposit?"));
            while (amount < 0) {
                amount = Integer.parseInt(JOptionPane.showInputDialog("invalid amount. try again."));
            }
            if (amount % 10 == 0) {
                JOptionPane.showMessageDialog(null, "counting complete\nAmount of N$"+amount+" confirmed");
                balance = balance + amount - 5;
                balanceCheck();
                depositLoop = false;
            }
            else {
                JOptionPane.showMessageDialog(null, "machine does not take coins");
                depositLoop = true;
            }
        }
    }

    public static void transfer() {

        while (transferLoopCount < 10) {
            account = JOptionPane.showInputDialog("service fee of N$15 on transfers.\nEnter account number");
            if (account.length() == 10) {
                amount = Integer.parseInt(JOptionPane.showInputDialog("amount"));
                if (amount % 10 == 0) {
                    if(amount > balance) {
                        JOptionPane.showMessageDialog(null, "Insufficient funds");
                        actionChoice();
                    }
                    else {
                        if (amount >= 20){
                            balance = balance - amount - 15;
                            JOptionPane.showMessageDialog(null,"N$"+amount+" transferred to account #"+account );
                            balanceCheck();
                            transferLoopCount = 100;
                        }
                        else {
                            while (amount < 20) {
                                newAmount = Integer.parseInt(JOptionPane.showInputDialog("Can't transfer less than N$20\ntry again"));
                                if (newAmount >= 20) {
                                    amount = newAmount;
                                    balance = balance - amount - 15;
                                    JOptionPane.showMessageDialog(null,"N$"+amount+" transferred to account #"+account );
                                    balanceCheck();
                                    transferLoopCount = 100;
                                }
                                else {
                                    amount = -9;
                                }
                            }

                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "invalid amount");
                    actionChoice();
                }
            }
            else if (account.length() > 10){
                JOptionPane.showMessageDialog(null,"Account number too long.\nAccount number must only be 10 digits");
            }
            else {
                JOptionPane.showMessageDialog(null,"Account number too short.\nAccount number must be 10 digits");
            }
        }
    }

    static void incorrectPin() {

        tryCount++;

        if (tryCount == tryLimit) {

            JOptionPane.showMessageDialog(null, "contact your bank pls");
            tryCount = 100;
        }
        else {
            chancesLeft = tryLimit - tryCount;
            if (chancesLeft == 1) {
                JOptionPane.showMessageDialog(null, "pin incorrect, try again,("+chancesLeft+" chance left)");
            }
            else {
                JOptionPane.showMessageDialog(null, "pin incorrect, try again,("+chancesLeft+" chances left)");
            }

        }
    }
}