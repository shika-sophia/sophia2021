package javaGold;

public class AnswerEditor implements InterAnswerSetting {

    public AnswerEditor() {
        run();
    }//constructor

    public void run() {
        String reference =
            "山本道子『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021 \n"
          + " *            米山 学 『徹底攻略 Java Gold SE8 問題集 [1Z0-809]』 インプレス, 2020";

        ioFileExe.buildJavaDoc(reference);
        ioFileExe.buildFilePage();
    }//run()

}//class

