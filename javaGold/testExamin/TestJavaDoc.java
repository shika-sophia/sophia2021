package javaGold.testExamin;

import javaGold.AnswerEditor;

public class TestJavaDoc {
    public static void main(String[] args) {
        new AnswerEditor();
        System.out.println("TestJavaDoc終了");
    }//main()
}//class

/*
//###### javaGold.testExamin.TestJavaDoc / 2021-02-01 ######
TestJavaDoc.main() -> new AnswerEditor() ->
InterAnswerSetting -> new BuildFilePage() の結果

「null
/＊＊
 * @title javaGold / testExamin / TestJavaDoc.java
 * @reference 山本道子『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 *            米山 学 『徹底攻略 Java Gold SE8 問題集[1Z0-809]』 インプレス, 2020
 * @content
 * @author shika
 * @date 2021-02-01
 ＊/
null 」 となる問題。-> ioFileAnalysis.txtに続く
 */
