package javaGoF.chap02jgAdapter.adapterDevolve;

import javaGoF.chap02jgAdapter.adapterInheritance.Banner;

public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String str) {
        this.banner = new Banner(str);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }

}//class
