import javax.swing.JOptionPane;

public class User {

    private static int the_guessed_nbr_of_user;
    private static int user_total_guesses;

    public static void startGame () {
        user_total_guesses = 0;
        the_guessed_nbr_of_user = 0;
    }

    private static  void incrementUserGuesses () {
        user_total_guesses += 1;
    }

    private static void displayWinningMessage () {

    if (user_total_guesses < 10) {
        JOptionPane.showMessageDialog(null,"Congratulations you made "+user_total_guesses+" moves\nto get on the track\nEither you know the secret or u got luck!");
    }
    else if (user_total_guesses == 10) {
        JOptionPane.showMessageDialog(null,"Congratulations you made "+user_total_guesses+" moves\nto get on the track\nAhaa you know the secret I bet!");
    }
    else {
        JOptionPane.showMessageDialog(null,"Congratulations you made "+user_total_guesses+" moves\nto get on the track\nYou should do better! Why should it take no more than 10 guesses!?");
    }
    }


    private static boolean checkIfUserGotTheNumber (int number) {
        boolean bool = GuessNumberLogic.checkIfUserGotTheNumber(number);
        if (bool) {
            displayWinningMessage();
            return true;
        }
        else {
            incrementUserGuesses();
            return false;
        }
    }

    public static boolean getUserGuessedNumber (int number) {
        the_guessed_nbr_of_user = number;
        boolean bool = checkIfUserGotTheNumber (number);
        return bool;
    }
}
