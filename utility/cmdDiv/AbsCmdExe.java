/**
 * @title utility / cmdDiv / AbsCmdExe.java
 * @content javaから コマンドプロンプトのコマンドを実行するクラス群。
 *
 * @package utility.cmdDiv
 * @class AbsCmdExe //共通フィールドを定義。classNameの加工。
 * @class CmdExecute extends AbsCmdExe   //コマンドプロンプトにコマンドを入れ、実行。
 * @class CmdJavaExe extends CmdExecute  // > java コマンドを実行。
 *            |  (ここから外部packageに extends)
 * @package swing
 * @class swing.SwingExecute extends CmdJavaExe  //swing実行用のクラス
 *
 * @author shika
 * @2021-01-24
 */
package utility.cmdDiv;

public abstract class AbsCmdExe {
    protected String className;   //実行ファイルのclass名。末尾に"$1"が付く
    protected String classNameCpl;// >javac コンパイル用のclass名。
    protected String classNameExe;// >java コマンドで実行用のclass名。
    protected String cd;  //カレントディレクトリ(eclipseはプロジェクトの絶対パス)
    protected String pathSrc;    //「C:\ ～ \src\ ～ \className.java」の絶対パス -> ReadFileで利用

    protected AbsCmdExe() { }

    protected AbsCmdExe(String className) {
        this.className = className;
        setClassNameCpl(className);
        setClassNameExe(className);
    }

    //====== getter, setter ======
    public String getClassName() {
        return className;
    }

    public String getClassNameCpl() {
        return classNameCpl;
    }

    protected void setClassNameCpl(String className) {
        this.classNameCpl = className
            .replace('.', '\\') + ".java";
    }

    public String getClassNameExe() {
        return classNameExe;
    }

    protected void setClassNameExe(String className) {
        this.classNameExe = className;
    }

    public String getCd() {
        return cd;
    }

    public String getPathSrc() {
        return pathSrc;
    }

    protected abstract void setCd();

    protected abstract void setPathSrc();


//    //====== Test main() ======
//    public static void main(String[] args) {
//        var cmdExe = new CmdExecute("swing.sample.SampleWindow$1");
//
//        System.out.println("className: " + cmdExe.className);
//        System.out.println("classNameCpl: " + cmdExe.classNameCpl);
//        System.out.println("classNameExe: " + cmdExe.classNameExe);
//        System.out.println("cd: " + cmdExe.cd);
//        System.out.println("pathSrc: " + cmdExe.pathSrc);
//   }//main()

}//class

/*
className: swing.sample.SampleWindow$1
classNameCpl: swing\sample\SampleWindow.java
classNameExe: swing.sample.SampleWindow
cd: C:\Program Files\pleiades\workspace-web\janJava2021
pathSrc: C:\Program Files\pleiades\workspace-web\janJava2021\src\swing\sample\SampleWindow.java
*/