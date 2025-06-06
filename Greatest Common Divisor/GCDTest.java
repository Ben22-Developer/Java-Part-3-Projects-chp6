import java.util.Scanner;

public class GCDTest {

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        int lets_go = 1;

        while (lets_go != 0) {

            System.out.println();

            System.out.print("Enter the 1st nbr: ");
            int num1 = input.nextInt();
            System.out.print("Enter the 2nd nbr: ");
            int num2 = input.nextInt();

            GCD gcd = new GCD(num1,num2);
            System.out.println("The Greatest common factor is: "+gcd.calculateGCD());
            gcd = null;

            System.out.print("Press any number to calculate GCD or 0 to stop: ");
            lets_go = input.nextInt();
        }
    }
}
