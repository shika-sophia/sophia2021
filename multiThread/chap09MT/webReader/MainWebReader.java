/**
 * @title multiThread / chap09MT / webReader / MainWebReader.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第９章 Futureパターン / 練習問題 9-3, List 9-8, 9-9, 9-10, 9-11, 解 A9-1, A9-2
 * @class ◆MainWebReader    //◆main() Retriever呼び出し。 toSaveFile()
 * @class ◇Retriever        //読み込みクラスのインスタンス生成(◇Sync,Asyncを切り替え)
 * @class AbsContent       //Contentの基底インターフェイス。
 * @class SyncContentImpl implements AbsContent
 *                        //シングルスレッドの同期Webページ読み込み
 * @class AsyncContentImpl
 * 			extends SyncContentImpl implements AbsContent
 *                        //マルチスレッドの非同期Webページ読み込み
 * @class AsyncCallable
 *          extends FutureTask implements AbsContent
 *                        //マルチスレッド、FutureTaskクラスで実現
 *
 * @page /content/ hyuki.html, google.html, yahoo.html
 *                       //書き込みのために content内に htmlファイルを配置する。
 *                       //「html内の変数が参照不可」という警告が出るので htmlファイルを削除。
 * @author shika
 * @date 2021-03-16, 03-17
 */
package multiThread.chap09MT.webReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainWebReader {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        AbsContent content1 = Retriever.retrieve("http://www.yahoo.com/");
        AbsContent content2 = Retriever.retrieve("http://www.google.com/");
        AbsContent content3 = Retriever.retrieve("http://www.hyuki.com/");

        saveToFile("src/multiThread/chap09MT/webReader/content/yahoo.html", content1);
        saveToFile("src/multiThread/chap09MT/webReader/content/google.html", content2);
        saveToFile("src/multiThread/chap09MT/webReader/content/hyuki.html", content3);

        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start) + " msec");
    }//main()

    private static void saveToFile(String fileName, AbsContent content) {
        byte[] byteAry = content.getByteAry();

        try (var out = new FileOutputStream(fileName)){
            System.out.printf(
                "%s: Saving to %s \n", Thread.currentThread().getName(), fileName);

            for(int i = 0; i < byteAry.length; i++) {
                out.write(byteAry[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//saveToFile

}//class

/*
//====== SyncContentImple ONLY / singleThread ======
  :
main: Getting form http://www.yahoo.com/
main: Getting form http://www.google.com/
main: Getting form http://www.hyuki.com/
main: Saving to src/multiThread/chap09MT/webReader/content/yahoo.html
main: Saving to src/multiThread/chap09MT/webReader/content/google.html
main: Saving to src/multiThread/chap09MT/webReader/content/hyuki.html
Elapsed time: 1519 msec

//====== AsyncContentImpl / multiThread ======
Thread-2: Getting form http://www.hyuki.com/
Thread-1: Getting form http://www.google.com/
Thread-0: Getting form http://www.yahoo.com/
main: Saving to src/multiThread/chap09MT/webReader/content/yahoo.html
main: Saving to src/multiThread/chap09MT/webReader/content/google.html
main: Saving to src/multiThread/chap09MT/webReader/content/hyuki.html
Elapsed time: 695 msec

//====== AsyncCallable / multiThread, FutureTask ======
Thread-2: Getting form http://www.hyuki.com/
Thread-0: Getting form http://www.yahoo.com/
Thread-1: Getting form http://www.google.com/
main: Saving to src/multiThread/chap09MT/webReader/content/yahoo.html
main: Saving to src/multiThread/chap09MT/webReader/content/google.html
main: Saving to src/multiThread/chap09MT/webReader/content/hyuki.html
Elapsed time: 828 msec

//====== hyuki.html (already deleted) ======
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="書籍『数学ガール』作者、結城浩の個人サイト。数学、プログラミング、
        文章書きに関する情報と、気軽な読み物。">
    <meta name="author" content="結城浩 / Hiroshi Yuki">
    <meta name="keywords" content="結城浩,Hiroshi Yuki,プログラミング,コンピュータ,数学,アルゴリズム,
        Java,Perl,C,キリスト教,クリスチャン,文章,メンタルヘルス" >
             :
 */