public class DigitSeparate {
    private int a_digit;

    public DigitSeparate (int digit) {
        this.a_digit = digit;
    }

    private void reverseDigits (int digit, int divisor) {

        if (divisor == 0) {
            return;
        }

        int quotient = digit/divisor;
        int remainder =  digit % divisor;
        divisor /= 10;
        reverseDigits(remainder,divisor);
        System.out.print(quotient+" ");
    }

    private void printDigits (int digit,int divisor) {

        System.out.println("Full Digit: "+digit);
        System.out.print("Separated digit: ");
        while (divisor != 0) {

            int a_digit_to_print = digit / divisor;
            System.out.print(a_digit_to_print+"  ");
            digit = digit - (a_digit_to_print * divisor);
            divisor = divisor/10;
        }
        System.out.println();
    }

    private int getDivisor () {

        int let_divisor = 10;

        int test = this.a_digit/let_divisor;

        while (test != 0) {

            let_divisor *= 10;
            test = this.a_digit/let_divisor;
        }

        return let_divisor/10;
    }

    public void digitSeparate () {

        int divisor = getDivisor();
        printDigits(this.a_digit,divisor);
        System.out.print("Reversed digit: ");
        reverseDigits(this.a_digit,divisor);
        System.out.println();
    }
}
