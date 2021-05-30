package javaGoF.chap07jgBuilder.buildOrdered;

import javaGoF.chap07jgBuilder.abstractBuilder.GofBuilder;

public abstract class GofBuilderOrdered extends GofBuilder {
    private volatile boolean initialized = false;

    public void makeTitle(String title) {
        if(!initialized) {
            buildTitle(title);
            initialized = true;
        }
    }//makeTitle()

    public void makeString(String str) {
        if(initialized) {
            buildString(str);
        }
    }//makeString()

    public void makeItem(String[] itemAry) {
        if(initialized) {
            buildItem(itemAry);
        }
    }//makeItem

    public void close() {
        if(initialized) {
            buildDone();
        }
    }//close()

    public abstract void buildTitle(String title);
    public abstract void buildString(String str);
    public abstract void buildItem(String[] item);
    public abstract void buildDone();
}//class
