package javaGoF.chap10Strategy.threeDeadlock;

public class ThreeHand {
    public static final int HAND_GUU = 0; //グー
    public static final int HAND_CHO = 1; //チョキ
    public static final int HAND_PAA = 2; //パー
    private static String[] handName = {"グー","チョキ","パー"};
    public static final ThreeHand[] handAry = {
        new ThreeHand(HAND_GUU),
        new ThreeHand(HAND_CHO),
        new ThreeHand(HAND_PAA)
    };

    private int handValue;
    private ThreeHand(int handValue) {
        this.handValue = handValue;
    }

    public static ThreeHand getHand(int handValue) {
        return handAry[handValue];
    }

    public boolean isStrongerThan(ThreeHand hand) {
        return fight(hand) == 1;
    }

    public boolean isWeakerThan(ThreeHand hand) {
        return fight(hand) == -1;
    }

    private int fight(ThreeHand hand) {
        if(this == hand) {
            return 0;
        } else if ((this.handValue + 1) % 3 == hand.handValue) {
            return 1;
        } else {
            return -1;
        }
    }//fight()

    public String toString() {
        return handName[handValue];
    }
}//class
