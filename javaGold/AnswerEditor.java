package javaGold;

public class AnswerEditor implements InterAnswerSetting {

    public AnswerEditor() {
        run();
    }//constructor

    public void run() {
        String reference =
            "山本道子『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021 \n"
          + " *            米山 学 『徹底攻略 Java Gold SE8 問題集[1Z0-809]』 インプレス, 2020";

        ioFileExe.buildJavaDoc(reference);
        ioFileExe.buildFilePage();
    }//run()

}//class

/*
package javaGold.testExamin;

import javaGold.AnswerEditor;

public class TestJavaDoc {
    public static void main(String[] args) {
        new AnswerEditor();
        System.out.println("TestJavaDoc終了");
    }//main()
}//class
*/