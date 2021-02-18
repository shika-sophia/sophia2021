/**
 * @title utility / ioFileDiv / AbsFileSystem.java
 * @content Fileの読み書きをする汎用クラス群。javaDocの自動生成も追加。
 * @package utility.ioFileDiv
 * @class AbsFileSystem extends Thread   //共通フィールド。呼び出しクラスのプロパティを取得
 * @class ReadFile extends AbsFileSystem //pathから そのファイルを読み取り
 * @class WriteFile extends ReadFile     //pathから そのファイルに書き込み
 * @class BuildJavaDoc extends WriteFile //javaDocの自動生成機能
 * @class BuildFilePage extends BuildJavaDoc //javaDocを含むファイルページの作成。
 *
 * @reference ◆スタックトレースから呼び出し元の情報を取得する（java）
 * @URL          https://qiita.com/Qui/items/467bb09211772e343c59
 * @reference ◆Javaコード入門 / System.getProperties()メソッド
 * @URL          https://java-code.jp/290
 *
 * @author shika
 * @date 2021-01-25
 */

package utility.ioFileDiv;

import utility.interfaceUT.IReference;

public abstract class AbsFileSystem extends Thread implements IReference {
    protected String className; //呼び出し元のクラス名
    protected String currentDir;//カレント(eclipseはプロジェクト)絶対パス
    protected String filePath;  //呼び出しクラスの絶対フルパス
    protected String readText;  //ReadFileクラスで読み込んだ現ファイルの記述内容
    protected String javaDoc;   //BuildJavaDocクラスで生成した javaDocの内容
    protected String reference; //JavaDocの @referenceを classNameから自動読み込み

    protected AbsFileSystem() {
        setClassName();
        setCurrentDir();
        setFilePath();
        setReference();
    }//constructor

    //====== setter ======
    protected void setClassName() {
        StackTraceElement[] stackAry
            = Thread.currentThread().getStackTrace();

        if(stackAry.length == 0) {
            ;
        } else {
            this.className = stackAry[stackAry.length - 1].getClassName();
        }
    }//setClassName()

    protected void setCurrentDir() {
        this.currentDir = System.getProperties().getProperty("user.dir");
    }//setCurrentDir()

    protected void setFilePath() {
        this.filePath = currentDir + "\\src\\"
            + className.replace('.','\\') + ".java";
    }//setFilePath()

    public void setReference() {
        this.reference = IReference.seekRef(className);
    }//setReference()

    public void setReference(String reference) {
        this.reference = reference;
    }

    //====== getter ======
    public String getClassName() {
        return className;
    }

    public String getCurrentDir() {
        return currentDir;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getReadText() {
        return readText;
    }

    public String getJavaDoc() {
        return javaDoc;
    }

    public String getReference() {
        return reference;
    }


    //====== abstract ======
    protected abstract void setReadText(String readText);

    protected abstract void setJavaDoc(String javaDoc);

//    //====== Test main() ======
//    public static void main(String[] args) {
//        var extendHere = new ReadFile();
//        System.out.println("className: " + extendHere.className);
//        System.out.println("currentDir: " + extendHere.currentDir);
//        System.out.println("filePath: " + extendHere.filePath);
//        System.out.println("readText: \n" + extendHere.readText);
//    }//main()

}//class

/*
className: utility.ioFileDiv.AbsFileSystem
currentDir: C:\Program Files\pleiades\workspace-web\janJava2021
filePath: C:\Program Files\pleiades\workspace-web\janJava2021\src￥utility\ioFileDiv\AbsFileSystem.java
readText:
/＊＊
 * @title utility / ioFileDiv / AbsFileSystem.java
 * @content Fileの読み書きをする汎用クラス群。javaDocの自動生成も追加。
 *     :
 * (このページの最後まで)
*/