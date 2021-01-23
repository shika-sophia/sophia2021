package swing;

import utility.CmdExecute;

public class SwingExecute {

    public SwingExecute(String className) {
        swgExecutor(className);
    }//constructor

    public void swgExecutor(String className) {
        String classNameCp = className
            .replace('.', '\\').replace("$1", ".java");

        //---- get current directory path ('cd')----
        var cmdExe = new CmdExecute();
        String cd = cmdExe.cmdExecutor("@cd");

        String path = cd + "\\src\\" + classNameCp;

        System.out.println("className: " + classNameCp);
        System.out.println("path: " + path);

        //---- conpile, execute ----
        cmdExe.cmdExecutor("cd " + path);
        String result = cmdExe.cmdExecutor(
            "javac -encoding UTF-8 " + classNameCp);

        System.out.println("result: \n" + result);
    }//swgExecutor()
}//class

/*
//====== Test Result ======
className: swing.sample.SampleWindow.java
 */
