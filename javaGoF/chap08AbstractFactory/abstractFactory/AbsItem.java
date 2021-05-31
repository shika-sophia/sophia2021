package javaGoF.chap08AbstractFactory.abstractFactory;

public abstract class AbsItem {
    protected String caption;

    public AbsItem(String caption) {
        this.caption = caption;
    }

    public abstract String makeHtml();

}//class
