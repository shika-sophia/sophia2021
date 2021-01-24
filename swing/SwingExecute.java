package swing;

import utility.cmdDiv.CmdJavaExe;

public class SwingExecute extends CmdJavaExe{
    public SwingExecute(){ }

    public SwingExecute(String className) {
        super(className);
        cmdJavaEclipse();
    }//constructor

}//class

/*
//====== Test Result ======
className: swing.sample.SampleWindow.java
 */
