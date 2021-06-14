package javaGoF.chap14ChainResponse.chainResponsibility;

public class SpecialSupportChain extends AbsSupportChain {
    private int number;

    public SpecialSupportChain(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(TroubleChain trouble) {
        if(trouble.getNumber() == number) {
            return true;
        }
        return false;
    }//resolve()

}//class
