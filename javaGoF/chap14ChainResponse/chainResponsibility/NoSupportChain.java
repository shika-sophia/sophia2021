package javaGoF.chap14ChainResponse.chainResponsibility;

public class NoSupportChain extends AbsSupportChain {

    public NoSupportChain(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(TroubleChain trouble) {
        return false;
    }

}//class
