/**
 * @title utility / ReadFile.java
 * @content pathを指定し、そのファイルの読み込み
 * @reference 結城浩『Java言語プログラミングレッスン(下)』SB Creative,2012 / p224
 * @author shika
 * @date 2021-01-24
 */

package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public String readPathFile(String path) {
        var bld = new StringBuilder();

        try(var reader = new BufferedReader(new FileReader(path))){

            String line;
            while((line = reader.readLine()) != null) {
                bld.append(line).append("\n");
            }//while

        } catch(FileNotFoundException e) {
            System.out.println(path + "が見つかりません。");
        } catch(IOException e) {
            e.printStackTrace();
        }

        return bld.toString();
    }//readPathFile()

//    public static void main(String[] args) {
//        //このクラスのクラス名を取得
//        String className = new Object(){ }.getClass()
//            .getName().replace('.','\\').replace("$1", ".java");
//
//        //カレントディレクトリを取得
//        String cd = new CmdExecute("").cmdExecutor("@cd");
//
//        //このクラスをインスタンス。絶対パスを渡して実行。
//        var here = new ReadFile();
//        String fileContent = here.readPathFile(cd + "\\src\\" + className);
//
//        //---- Test print ----
//        System.out.println("herePath: " + className);
//        System.out.println(fileContent);
//    }//main()

}//class

/*
//======実行結果======
herePath: utility\ReadFile.java

/＊＊
 * @title utility / ReadFile.java
 * @content pathを指定し、そのファイルの読み込み
        :
        :
    }//main()

}//class

【考察】
FileReaderは絶対パスを指定しないと、ファイルを見つけてくれないようです。

*/