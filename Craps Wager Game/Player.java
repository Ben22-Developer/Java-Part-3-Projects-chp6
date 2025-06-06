public class Player {

    private int wager;
    private int bankBalance = 1000;

    public int getBankBalance () {
        return bankBalance;
    }

    public void setWager (int wager) {
        this.wager = wager;
    }

    private void addBankBalance () {
        bankBalance += wager;
    }

    private void reduceBankBalance () {
        bankBalance -= wager;
    }

    public void updatePlayerBalance (boolean player_win) {
        if (player_win) {
            addBankBalance();
        }
        else {
            reduceBankBalance();
        }
    }
}
