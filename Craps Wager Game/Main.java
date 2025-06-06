import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class Main {


    private static int diceRoll () {

        SecureRandom randomize = new SecureRandom();

        int roll1 = 1 + randomize.nextInt(6);
        int roll2 = 1 + randomize.nextInt(6);

        return roll1 + roll2;
    }

    private static  void gameController (int user_press) {

        Player user = new Player();

        do {

            int wager = Integer.parseInt(JOptionPane.showInputDialog("Enter your wager which don't exceed your account balance\nAccount Balance: "+user.getBankBalance()));

            GamePlaying.startGame();
            user.setWager(wager);

            if (wager <= user.getBankBalance()) {

                while (true) {

                    int roll = Integer.parseInt(JOptionPane.showInputDialog("Press any number to roll or 0 to get out of the game: "));

                    if (roll == 0) {
                        break;
                    }

                    int a_play = diceRoll();
                    GamePlaying.gamePlay(a_play,user);
                    boolean can_user_roll_again = GamePlaying.getIfUserCanRoll();
                    if (!can_user_roll_again) {
                        break;
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"You have Insufficient balance!");
            }
            user_press = Integer.parseInt(JOptionPane.showInputDialog("Press any number to roll or 0 to get out of the game\nRoll again if u got the mulla\nYour balance: "+user.getBankBalance()));
        }
        while (user_press != 0);

        user = null;

    }

    public static void main (String[] args) {

        int user_press;
        user_press = Integer.parseInt(JOptionPane.showInputDialog("Welcome to the game of chance\nWe play and roll the money!\nHow to play ??\nYou will roll the dice and at the first time if u roll 7 or 11, then u win the wage\nIf you roll 2 or 3 or 12 then you are done\nFor other numbers you will roll, you will continue the game, then the number you have rolled is the target \nBy continuing the game if u roll 7 you will fail, in order to win the wager you will need to roll the target\n Wage well, Good luck\nPress any number which is not 0 to start:"));

        if (user_press != 0)
            gameController(user_press);

        JOptionPane.showMessageDialog(null,"Be back soon!");
    }
}
