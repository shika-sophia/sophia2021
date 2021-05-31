package javaGoF.chap08AbstractFactory.abstractFactory;

public abstract class AbsLink extends AbsItem {
    protected String url;

    public AbsLink(String caption, String url) {
        super(caption);
        this.url = url;
    }
}//class
