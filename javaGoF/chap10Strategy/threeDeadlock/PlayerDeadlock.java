package javaGoF.chap10Strategy.threeDeadlock;

public class PlayerDeadlock {
    private String playerName;
    private IThreeStrategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    public PlayerDeadlock(
            String playerName, IThreeStrategy strategy) {
        this.playerName = playerName;
        this.strategy = strategy;
    }

    public ThreeHand nextHand() {
        return strategy.nextHand();
    }

    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even() {
        gameCount++;
    }

    public String toString() {
        var bld = new StringBuilder();
        bld.append("[ ").append(playerName).append(": ");
        bld.append(String.format("Game %d, ", gameCount));
        bld.append(String.format("Win %d, ", winCount));
        bld.append(String.format("Lose %d", loseCount));
        bld.append(" ]");

        return bld.toString();
    }//toString()
}//class
