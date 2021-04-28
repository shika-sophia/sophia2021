package javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle.resource;

import java.util.ListResourceBundle;

public class MyLocale_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"send", "send"},
                {"cancel", "cancel"}
            };

            return contents;
    }//getContents()

}//class
