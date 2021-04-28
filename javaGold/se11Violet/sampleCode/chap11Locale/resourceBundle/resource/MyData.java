package javaGold.se11Violet.sampleCode.chap11Locale.resourceBundle.resource;

import java.util.ListResourceBundle;

public class MyData extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Long data1 = 1000L;
        Integer data2 = 500;
        int[] data3 = {10, 20, 30};

        Object[][] dataAry = {
            {"data1", data1},
            {"data2", data2},
            {"data3", data3}
        };

        return dataAry;
    }//getContents()

}//class
