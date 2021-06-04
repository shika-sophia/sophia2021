package javaGoF.chap09Bridge.bridgeImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileDisplayImpl extends SimpleDisplayImpl {
    private String fileName;

    public ReadFileDisplayImpl(String fileName) {
        super();
        this.fileName = fileName;
        readFile();
    }

    protected void readFile() {
        String dir = "src/javaGoF/chap09Bridge/bridgeImplementation/";

        //---- readFile ----
        String str = "";
        Path filePath = Paths.get(dir, fileName);
        try(BufferedReader reader
                = Files.newBufferedReader(filePath)){
            str = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //---- SimpleDisplayImpl.setStr() ----
        setStr(str);
    }//readFile()

}//class

/*
//---- Test main() ----
public static void main(String[] args) {
    new ReadFileDisplayImpl("textData.txt");
}//main()

//---- seek this directory ----
    String className = System.getProperty("sun.java.command");
    String dir = "src/"
        + className.substring(0, className.lastIndexOf("."))
        .replace('.', '/') + "/";
//System.out.println(dir);
//src/javaGoF/chap09Bridge/bridgeImplementation/

【考察】 上記 seek this directory
Mainから startすると
src\javaGoF\chap09Bridge\textData.txt
というPathになり、java.nio.file.NoSuchFileException

System.getProperty("sun.java.command")は
javaを実行したクラスの完全修飾名を持ってくる。
固定値に変更。
String dir = "src/javaGoF/chap09Bridge/bridgeImplementation/";

//System.out.println(str);
//Hello TextFile
*/