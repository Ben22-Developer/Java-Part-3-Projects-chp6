import javax.swing.*;
import java.security.SecureRandom;
import javax.swing.JOptionPane;

public class GuessNumberLogic {

    private static int number_to_guess;

    private static int getNumberToGuess () {

        SecureRandom randomize = new SecureRandom();
        int random_nbr =  1 + randomize.nextInt(1000);
        return  random_nbr;
    }

    public static void setNumberToGuess () {
        number_to_guess = getNumberToGuess();
    }

    private static boolean makeDecisionOnUserChoice (int user_guessed_number) {

        if (user_guessed_number > number_to_guess) {
            JOptionPane.showMessageDialog(null,"The guess is high");
            return false;
        }
        else if (user_guessed_number < number_to_guess) {
            JOptionPane.showMessageDialog(null,"The guess is low");
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkIfUserGotTheNumber (int user_guessed_number) {

        boolean bool = makeDecisionOnUserChoice(user_guessed_number);
        return bool;
    }
}
