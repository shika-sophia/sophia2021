package javaGoF.chap20Flyweight.hugeNumber;

import java.util.List;

public class HugeNumber {
    private int index;
    private String hugeStr;

    public HugeNumber(int index) {
        this.index = index;
        buildHuge();
    }

    public void buildHuge() {
        var data = new NumberData();
        List<int[]> hexAryList = data.getHexAryList();

        int[] hexAry = hexAryList.get(index);
        hugeStr = data.showNumber(hexAry);
    }//buildHuge()

    public String getHugeStr() {
        return hugeStr;
    }
}//class
