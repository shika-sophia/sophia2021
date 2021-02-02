/**
 * @title utility / scanDiv / AbsScan.java
 * interface InterCalcTime            //時間計算機能の追加
 * @class AbsScan                     //abstract 共通するフィールドを定義
 * @class ScanConfirm extends AbsScan //YES,NOで答える確認入力する機能
 * @class ScanStr extends ScanConfirm //Stringを入力する質問機能
 * @class ScanInt extends ScanStr     //intを入力。不正値ループ機能
 *
 * @author shika
 * @date 2021-01-22
 */
package utility.scanDiv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbsScan implements InterCalcTime {
    protected Scanner scan;
    protected Scanner scanSub;
    protected List<String> questList; //質問内容のリスト
    protected List<String> inListStr; //inputStr を記録
    protected List<Integer> inListInt;//inputInt を記録
    protected final String SUFFIX = "入力して下さい。";
    protected final String FINKEY = "[ -99: 終了]";
    protected final String CONFIRMKEY = " [Y] YES / [N] NO ";

    public AbsScan() {
        questList = new ArrayList<String>();
        inListStr = new ArrayList<String>();
        inListInt = new ArrayList<Integer>();
    }//constructor

    //====== getter, setter ======
    public List<String> getInListStr() {
        return inListStr;
    }

    protected void setInListStr(List<String> inListStr) {
        this.inListStr = inListStr;
    }

    protected void setInListStr(String inputStr) {
        this.inListStr.add(inputStr);
    }

    public List<Integer> getInListInt() {
        return inListInt;
    }

    protected void setInListInt(List<Integer> inListInt) {
        this.inListInt = inListInt;
    }

    protected void setInListInt(int inputInt) {
        this.inListInt.add(inputInt);
    }
}//abatract class
