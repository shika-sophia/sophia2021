package javaGoF.chap14ChainResponse.chainResponsibility;

public class TroubleChain {
    private int number;

    public TroubleChain(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return "[Trouble " + number + "]";
    }
}//class
