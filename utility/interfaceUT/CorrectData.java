package utility.interfaceUT;

import java.util.List;

public class CorrectData {
    protected int answerNum;  //回答数
    protected int correctNum; //正答数
    protected double correctRate; //正答率
    protected List<String> correctList; //(0,1)を〇×に置換したリスト

    public CorrectData(
            int answerNum,
            int correctNum,
            double correctRate,
            List<String> correctList) {
        this.answerNum = answerNum;
        this.correctNum = correctNum;
        this.correctRate = correctRate;
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

    public List<String> getCorrectList() {
        return correctList;
    }

}//class CorrectData
