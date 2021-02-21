package javaGold;

import utility.interfaceUT.IReference;

public class AnswerEditor
    implements IAnsNeedInstance, IReference {

    public AnswerEditor() {
        run();
    }//constructor

    public void run() {

        @SuppressWarnings("unused")
        String className = ioFileExe.getClassName();
        String content = "";

        ioFileExe.buildJavaDoc(content);
        ioFileExe.buildFilePage();
    }//run()

}//class

