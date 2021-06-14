package javaGoF.chap14ChainResponse.chainResponsibility;

public class OddSupportChain extends AbsSupportChain {

    public OddSupportChain(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(TroubleChain trouble) {
        if(trouble.getNumber() % 2 == 1) {
            return true;
        }
        return false;
    }//resolve()

}//class
