package javaGold;

public class AnswerEditor
    implements IAnsNeedInstance, IReference {

    public AnswerEditor() {
        run();
    }//constructor

    public void run() {
        String className = ioFileExe.getClassName();
        String reference = IReference.seekRef(className);

        ioFileExe.buildJavaDoc(reference);
        ioFileExe.buildFilePage();
    }//run()

}//class

