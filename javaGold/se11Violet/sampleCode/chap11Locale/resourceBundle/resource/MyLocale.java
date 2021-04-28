package javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle.resource;

import java.util.ListResourceBundle;

public class MyLocale extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
            {"send", "送信"},
            {"cancel", "取消"}
        };

        return contents;
    }//getContents()

}//class
