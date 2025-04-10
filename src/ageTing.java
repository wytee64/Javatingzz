import java.util.Scanner;

public class ageTing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("how old are you: ");
        int age = scanner.nextInt();

        if (age == 100) {
            System.out.println("You are a centary old!");
        }
        else if (age > 100 && age < 200) {
            int calc = age - 100;
            int left = 200 - age;
            if (left == 1) {
                System.out.println("You are a centary and "+calc+" years old!!!");
                System.out.println("only "+left+" more year then are 2 centarie old!!!");
            }
            else {
                System.out.println("You are a centary and "+calc+" years old!!!");
                System.out.println("Only "+left+" more years then you are centaries old!!!");
            }

        }
        else if (age >= 18 && age < 100) {
            System.out.println("You are an adult.");
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Do you own a car? ");
            String answer = scanner1.nextLine();
            String car = answer.toLowerCase();

            if (car.equals("yes")) {
                System.out.println("If it aint a hellcat then it aint a car dawg.");
            }
            else if (car.equals("no")) {
                System.out.println("Go buy you a car dawg.");
            }

        }
        else if (age < 18) {
            System.out.println("You are a child.");
        }
        else {
            System.out.println("Dead ass nigga.");
        }
    }
}
