import java.util.Scanner;

public class Numbers {

    private static String generateHexadecimalLetter (int remainder) {

        String letter;

        switch (remainder) {
            case 10:
                letter = "A";
            break;
            case 11:
                letter = "B";
            break;
            case 12:
                letter = "C";
            break;
            case 13:
                letter = "D";
            break;
            case 14:
                letter = "E";
            break;
            case 15:
                letter = "F";
            break;
            default:
                letter = "";
        }
        return letter;
    }

    private static String generateHexadecimal (int number) {

        String generatedNbr = "";
        int bound = 16;

        if (number < 10) {
            return "The number must be greater than te bound\nBut now "+number+" < "+bound+" which is an error";
        }
        else if (number >= 10 && number <= 15) {
            return generateHexadecimalLetter(number);
        }

        while (true) {

            String remainder_char = "";
            int quotient,remainder;

            quotient = number/bound;
            remainder = number % bound;

            remainder_char += remainder >= 10 ? generateHexadecimalLetter(remainder) : remainder;

            if (quotient < bound) {

                generatedNbr = remainder_char + generatedNbr;
                generatedNbr = quotient + generatedNbr;

                return generatedNbr;
            }
            else {
                generatedNbr = remainder_char + generatedNbr;
                number = quotient;
            }

        }

    }

    private static String generateOctalAndBinary (int number,int bound) {

        String generatedNbr = "";

        if (number < bound) {
            return "The number must be greater than te bound\nBut now "+number+" < "+bound+" which is an error";
        }

        while (true) {

            int quotient,remainder;

            quotient = number/bound;
            remainder = number % bound;

            if (quotient < bound) {

                generatedNbr = remainder + generatedNbr;
                generatedNbr = quotient + generatedNbr;

                return generatedNbr;
            }
            else {
                generatedNbr = remainder + generatedNbr;
                number = quotient;
            }
        }
    }

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        int generate = 1;

        do {
            System.out.print("Enter any number and get it's equivalent binary, octal and hexadecimal number: ");
            int number = input.nextInt();

            String generatedBinary = generateOctalAndBinary(number,2);
            String generatedOctal = generateOctalAndBinary(number,8);
            String generatedHexadecimal = generateHexadecimal(number);

            System.out.println("Binary number of "+number+" = "+generatedBinary);
            System.out.println("Octal number of "+number+" = "+generatedOctal);
            System.out.println("Hexadecimal number of "+number+" = "+generatedHexadecimal);
            System.out.println();

            System.out.print("Enter 0 to stop the program execution or any number to continue: ");
            generate = input.nextInt();
            System.out.println();
        }
        while (generate != 0);
    }
}
