package javaGoF.chap02JG.adapterDevolve;

import javaGoF.chap02JG.adapterInheritance.Banner;

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
