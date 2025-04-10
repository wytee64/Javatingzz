import java.util.Scanner;

public class GenderCounterTing {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("How many people are there: ");
        int numberOfPeople = a.nextInt();
        int m = 0;
        int f = 0;
        for (int total = 0; total < numberOfPeople; total++) {
            Scanner x = new Scanner(System.in);
            System.out.print("gender: ");
            String gender = x.nextLine();


            switch (gender.toLowerCase()) {
                case "m":
                    m++;
                    break;
                case "f":
                    f++;
                    break;
                default:
                    System.out.println("enter a valid gender");
                    total--;
            }
        }
        System.out.println("the total number of males are "+m);
        System.out.println("the total number of females are "+f);
    }
}
