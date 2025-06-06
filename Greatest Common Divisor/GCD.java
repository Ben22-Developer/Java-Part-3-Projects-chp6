public class GCD {

    private int num1,num2;

    public GCD (int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int calculateGCD () {

        int big_num = Math.max(this.num1,this.num2);
        int small_num = Math.min(this.num1,this.num2);
        int quotient = big_num/small_num;
        int remainder = big_num%small_num;
        int next_operand = (big_num - remainder)/quotient;

        while (remainder != 0) {

            quotient = next_operand/remainder;
            remainder = next_operand % remainder;
            next_operand = (next_operand - remainder)/quotient;

        }
        return next_operand;
    }
}
