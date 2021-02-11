package utility.interfaceUT;

import java.util.List;

public class CorrectData {
    protected int answerNum;  //回答数
    protected int correctNum; //正答数
    protected double correctRate; //正答率
    protected String correctResult;// "正答率 __.__ ％(〇__問 / 全__問)"の文字列
    protected List<String> correctList; //(0,1)を〇×に置換したリスト

    public CorrectData(
            int answerNum,
            int correctNum,
            double correctRate,
            String correctResult,
            List<String> correctList) {
        this.answerNum = answerNum;
        this.correctNum = correctNum;
        this.correctRate = correctRate;
        this.correctResult = correctResult;
        this.correctList = correctList;
    }//constructor

    //====== getter ======
    public int getAnswerNum() {
        return answerNum;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public double getCorrectRate() {
        return correctRate;
    }

    public String getCorrectResult() {
        return correctResult;
    }

    public List<String> getCorrectList() {
        return correctList;
    }

}//class CorrectData
