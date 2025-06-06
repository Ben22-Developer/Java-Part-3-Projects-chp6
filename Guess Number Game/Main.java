import javax.swing.JOptionPane;

public class Main {

    public static void gamePlay () {

        int continuee = 1;
        boolean game_starts = true;

        do {

            User.startGame();
            GuessNumberLogic.setNumberToGuess();

            while (true) {
                int the_guess = Integer.parseInt(JOptionPane.showInputDialog("Guess the number: "));
                boolean has_user_won = User.getUserGuessedNumber(the_guess);
                if (has_user_won) {
                    break;
                }
            }

            continuee = Integer.parseInt(JOptionPane.showInputDialog("Press any number to continue playing or 0 to stop the game: "));

        }
        while (continuee != 0);
    }


    public static void main (String[] args) {

        JOptionPane.showMessageDialog(null,"Hello welcome to the guessing game\nYou will guess for a random number between 1 and 1000\nIf u guess a high number you will get a message that you are high\nElse if you guess a low number you will get a message that you are low\nElse you will get congs\nGood Luck!");

        gamePlay();

        JOptionPane.showMessageDialog(null,"Byee thank you for using our app");

    }
}
