import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class GamePlaying {

    private enum Status { WON_GAME , CONTINUE_GAME , LOSS_GAME };

    private static int target;
    private static int rolls;
    private static Status game_situation;
    private static SecureRandom randomize = new SecureRandom();

    public static void startGame () {
        rolls = 1;
    }

    private static void displayWinningMessage (int a_play) {

        int random = randomize.nextInt(3);
        int played = a_play;

        switch (random) {
            case 0 -> JOptionPane.showMessageDialog(null,"You got some new fricks homie!\nTurn again the vibe yoo\nYou have played "+played);
            case 1 -> JOptionPane.showMessageDialog(null,"Look at the new boss in the room\nWage it again to confirm it's not a mimic chance\nYou have played "+played);
            case 2 -> JOptionPane.showMessageDialog(null,"You are big now\nIt's time to cash in your chips champion\nYou have played "+played);
        }
    }

    private static void displayLossMessage (int a_play) {
        int random = randomize.nextInt(3);
        int played = a_play;

        switch (random) {
            case 0 -> JOptionPane.showMessageDialog(null,"Breath\nCome back later\nYou have played "+played);
            case 1 -> JOptionPane.showMessageDialog(null,"Ooh sorry you are going broke\nYou have played "+played);
            case 2 -> JOptionPane.showMessageDialog(null,"Warm up!\nBe comfort\nYou have played "+played);
        }
    }

    private static void displayPlayingMessage(int a_play) {
        int random = randomize.nextInt(3);
        int played = a_play;

        switch (random) {
            case 0 -> JOptionPane.showMessageDialog(null,"Aw c'mon, take a chance\nYou have played "+played);
            case 1 -> JOptionPane.showMessageDialog(null,"You gonna make it next\nYou have played "+played);
            case 2 -> JOptionPane.showMessageDialog(null,"Do it for sure\nYou have played "+played);
        }
    }

    private static void messageDisplay (int a_play) {

        if (game_situation == Status.WON_GAME)
            displayWinningMessage(a_play);
        else if (game_situation == Status.LOSS_GAME)
            displayLossMessage(a_play);
        else
            displayPlayingMessage(a_play);
    }

    private static void checkGameSituation (int a_play,Player user) {
        switch (game_situation) {
            case Status.WON_GAME:
                user.updatePlayerBalance(true);
                messageDisplay(a_play);
            break;
            case Status.LOSS_GAME:
                user.updatePlayerBalance(false);
                messageDisplay(a_play);
            break;
            case Status.CONTINUE_GAME:
                messageDisplay(a_play);
        }
    }

    private static void firstRoll (int a_play) {
        switch (a_play) {
            case 7:
            case 11:
                game_situation = Status.WON_GAME;
                break;
            case 2:
            case 3:
            case 12:
                game_situation = Status.LOSS_GAME;
                break;
            default:
                game_situation = Status.CONTINUE_GAME;
                target = a_play;
                break;
        }
    }

    private static void otherRolls (int a_play) {
        if (a_play == 7) {
            game_situation = Status.LOSS_GAME;
        }
        else if (a_play == target) {
            game_situation = Status.WON_GAME;
        }
    }

    private static void decideAfterUserFirstAttempt(int a_play,Player user) {
        firstRoll(a_play);
        checkGameSituation(a_play,user);
    }

    private static void otherUserPlays (int a_play,Player user) {

        otherRolls(a_play);
        checkGameSituation(a_play,user);

    }

    public static boolean getIfUserCanRoll () {
        return game_situation == Status.CONTINUE_GAME ? true : false;
    }

    public static void gamePlay (int a_play, Player user) {
        if (rolls == 1) {
            decideAfterUserFirstAttempt(a_play,user);
            rolls += 1;
        }
        else {
            otherUserPlays(a_play,user);
        }
    }

}
