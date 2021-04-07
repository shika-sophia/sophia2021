/**
 * @title javaGoF / chap02JG / ioFileAdapter / MainIoFileAdapter.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第２章 Adapter / 練習問題 2-2
 * @content Fileの読み書きを 既存の java.util.Propatiesをもとに
 * 			ここで必要な IFileIOへ、カスタマイズする Adapterを作成。
 * @author shika
 * @date 2021-04-06
 */
package javaGoF.chap02JG.ioFileAdapter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainIoFileAdapter {

    public static void main(String[] args) {
        IFileIO fileIo = new FileProperty();
        String directory = "src/javaGoF/chap02JG/ioFileAdapter/";
        try {
            fileIo.readFile(directory +"inFile.txt");
            fileIo.setValue("year", "2021");
            fileIo.setValue("month", "04");
            fileIo.setValue("day", "06");
            fileIo.writeFile(directory + "outFile.txt");

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("outFile.txt: 書き込み完了");
    }//main()

}//class

/*
outFile.txt: 書き込み完了

//---- outFile.txt ----
#written by FileProperty
#Wed Apr 07 10:51:43 JST 2021
month=04
year=2021
day=06

【考察】
解答は FilePropertiy extends Properties implements IFileIOとしていた。
ファイル名からして extendsしたほうがクラスの意図が はっきりする。
私はフィールドでインスタンスした。

getProperty(),setProperty()はフィールドに保存しなくても
Propertiesクラスの中で勝手に保存される。
load(),store()も読み込んだ内容や書き込む内容を Stringなどで保存しなくても、
Propertiesクラスの中に load()し、そこから store()してくれる。
*/