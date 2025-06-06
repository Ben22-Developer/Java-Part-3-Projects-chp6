import java.util.Scanner;

public class Main {

    private static void runTheApp () {
        final Scanner input = new Scanner(System.in);

        int insert = 1;
        while (insert != 0) {

            System.out.print("Enter a digit of your choice: ");
            int digit = input.nextInt();

            if (digit < 0) {
                System.out.println("Can't print a negative number");
            }
            else {
                DigitSeparate a_digit = new DigitSeparate(digit);
                a_digit.digitSeparate();
            }

            System.out.print("Enter 0 to stop or any number to continue: ");
            insert = input.nextInt();
        }
    }

    public static void main (String[] args) {

        System.out.println("Welcome on this app we receive a digit and print it separately\nNote that only positive digits are allowed");
        System.out.println();
        runTheApp();
    }
}
