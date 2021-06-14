package javaGoF.chap14ChainResponse.chainResponsibility;

public abstract class AbsSupportChain {
    private String name;
    private AbsSupportChain next;

    public AbsSupportChain(String name) {
        this.name = name;
    }

    public AbsSupportChain setNext(AbsSupportChain next) {
        this.next = next;
        return next;
    }

    public final void support(TroubleChain trouble) {
        if(resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }//support()

    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(TroubleChain trouble);

    protected void done(TroubleChain trouble) {
        System.out.printf(
            "%s is resolved by %s \n", trouble, this);
    }

    protected void fail(TroubleChain trouble) {
        System.out.printf(
            "%s cannot be resolved \n", trouble);
    }
}//class
