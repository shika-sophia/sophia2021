package javaGoF.chap14ChainResponse.chainResponsibility;

public class LimitSupportChain extends AbsSupportChain {
    private int limit;

    public LimitSupportChain(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(TroubleChain trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        }
        return false;
    }//resolve()

}//class
