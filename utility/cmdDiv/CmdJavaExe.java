package utility.cmdDiv;

public class CmdJavaExe extends CmdExecute{
    public CmdJavaExe(){ }

    public CmdJavaExe(String className){
        super(className);
    }

    //cdでのコンパイル用
    public void cmdCompile() {
        cmdExecutor(String.format(
            "javac %s -cp %s -encoding UTF-8", classNameCpl, pathSrc));
    }//cmdCompile()

    //eclipseのsrcファイル専用、コマンド実行メソッド
    public String cmdJavaEclipse() {
        String exeResult = cmdExecutor(String.format(
            "java -cp ./build/classes %s", classNameExe));

        //System.out.println(exeResult);
        return exeResult;
    }//cmdJavaEclipse()


//    //====== Test main() ======
//    public static void main(String[] args) {
//        var here = new CmdJavaExe("swing.sample.SampleWindowListener$1");
//        String result = here.cmdJavaEclipse();
//        System.out.println(result);
//    }//main()
}//class
