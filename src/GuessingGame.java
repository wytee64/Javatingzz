import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    static String toUpper;
    static boolean guessedCorrectly;
    static Scanner scanner;
    static boolean play;
    static int number;
    static Random random = new Random();

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        play = true;


        while (play) {
            number = random.nextInt(1, 11);
            guessedCorrectly = false;
            System.out.print("Guess a number between 1 and 10: ");

            while (!guessedCorrectly) {
                check();
            }
        }
        System.out.println("Thanks for playing!");
    }
    static void correct() {
        guessedCorrectly = true;
        System.out.println("Shiiii! You got it");
    }
    static void playAgain() {
        System.out.print("Wanna play again? (y/n): ");
        String doYouWantToPlayAgain = scanner.next();
        toUpper = doYouWantToPlayAgain.toUpperCase();
        if (toUpper.equals("Y")) {
            play = true;
        } else if (toUpper.equals("N")) {
            play = false;
        }
    }
    static void check() {
        int guess = scanner.nextInt();
        if (guess < number) {
            System.out.print("Too low! Try again: ");
        }
        else if (guess > number) {
            System.out.print("Too high! Try again: ");
        }
        else {
            correct();
            playAgain();
        }
    }
}