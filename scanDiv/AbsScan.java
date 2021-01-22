/**
 * @title utility / scanDiv / AbsScan.java
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

public abstract class AbsScan {
    protected Scanner scan;
    protected Scanner scanSub;
    protected List<String> inListStr; //inputを記録
    protected List<Integer> inListInt;//inputを記録
    protected final String SUFFIX = "入力して下さい。";

    public AbsScan() {
        inListStr = new ArrayList<String>();
        inListInt = new ArrayList<Integer>();
    }//constructor

}//abatract class
