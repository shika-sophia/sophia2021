package javaGold;

import java.util.ArrayList;
import java.util.List;

public interface ICalcCorrect {
    public default CorrectData toStringZero(List<Integer> inListInt) {
        List<String> correctList = new ArrayList<>(inListInt.size());

        int correctNum = 0;
        for(int zeroOne : inListInt) {
            if(zeroOne == 0) {
                correctNum++;
                correctList.add("〇");
            } else if (zeroOne == 1) {
                correctList.add("×");
            }
        }//for

        CorrectData data = new CorrectData(correctNum, correctList);
        return data;
    }//toStringZero()

}//interface

class CorrectData {
    protected int correctNum;
    protected List<String> correctList;

    public CorrectData(
            int correctNum, List<String> correctList) {
        this.correctNum = correctNum;
        this.correctList = correctList;
    }//constructor

    //====== getter, setter ======
    public int getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(int correctNum) {
        this.correctNum = correctNum;
    }

    public List<String> getCorrectList() {
        return correctList;
    }

    public void setCorrectList(List<String> correctList) {
        this.correctList = correctList;
    }

}//class CorrectData
