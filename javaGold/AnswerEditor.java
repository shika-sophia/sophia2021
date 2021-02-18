package javaGold;

import utility.interfaceUT.IReference;

public class AnswerEditor
    implements IAnsNeedInstance, IReference {

    public AnswerEditor() {
        run();
    }//constructor

    public void run() {
        String className = ioFileExe.getClassName();
        String content = "";

        ioFileExe.buildJavaDoc(content);
        ioFileExe.buildFilePage();
    }//run()

}//class

