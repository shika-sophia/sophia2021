/**
 * @title javaGoF / chap18Memento / MainSerialize.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第18章 Memento / 練習問題 18-4
 *          Mementoを Serializableとし、
 *          ObjectStreamを用いて、外部ファイルに保存。
 *          ファイル "game.dat"が存在しないときは、所持金 100でゲームスタート
 *          ファイルが存在するときは、そのMementoから復元してスタート。
 *
 * @class MainSerialize / ◆main()
 *        -gameStart(GamerSerial, MementoSerial, Path),
 *        -readMemento(Path),
 *        -writeMemento(MementoSerial, Path)
 * @package ---- serialize ----
 * @class GamerSerial
 *        (MementSerialのクラス名以外、変更なし)
 * @class MementoSerial implements Serializable
 *        (implements Serializable以外、変更なし)
 * @file game.dat / Mementoの Serialize data
 *
 * @see MainFruitGame / class summary
 * @author shika
 * @date 2021-06-23
 */
package javaGoF.chap18Memento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javaGoF.chap18Memento.serialize.GamerSerial;
import javaGoF.chap18Memento.serialize.MementoSerial;

public class MainSerialize {

    public static void main(String[] args) {
        var gamer = new GamerSerial(100);
        var memento = gamer.createMemento();

        String dir = "src/javaGoF/chap18Memento/serialize/";
        String fileName = "game.dat";
        Path path = Paths.get(dir, fileName);

        if (Files.exists(path)) {
            memento = readMemento(path);
            gamer.restoreMemento(memento);
        }

        gameStart(gamer, memento, path);
    }//main()

    private static void gameStart(
            GamerSerial gamer, MementoSerial memento, Path path) {
        for(int i = 0; i < 50; i++) {
            System.out.println("==== " + i); //回数表示
            System.out.println("現状: " + gamer);

            gamer.bet(); //サイコロを振る

            System.out.println("所持金は " + gamer.getMoney() + " 円になりました。");

            //Mementoの処理
            if(gamer.getMoney() > memento.getMoney()) {
                System.out.println("　　　(だいぶ増えたので、現在の状態を保存しておこう)");
                memento = gamer.createMemento();
                writeMemento(memento, path);
            }

            //時間待ち
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println();
        }//for

    }//gameStart()

    private static MementoSerial readMemento(Path path) {
        MementoSerial memento = null;

        try(ObjectInput serialReader =
                new ObjectInputStream(
                    new FileInputStream(path.toFile()))) {
            memento = (MementoSerial) serialReader.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return memento;
    }//readMemento()

    private static void writeMemento(MementoSerial memento, Path path) {
        try(ObjectOutput serialWriter =
                new ObjectOutputStream(
                    new FileOutputStream(path.toFile()))) {
            serialWriter.writeObject(memento);
            System.out.println("wrote memento: " + path.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//writeMemento()

}//class

/*
###### １回目 ######
==== 0
現状: [money =  100, fruit = []]
なにも起こりませんでした。
所持金は 100 円になりました。

==== 1
現状: [money =  100, fruit = []]
フルーツ( おいしいリンゴ )をもらいました。
所持金は 100 円になりました。

==== 2
現状: [money =  100, fruit = [おいしいリンゴ]]
所持金が増えました。
所持金は 200 円になりました。
　　　(だいぶ増えたので、現在の状態を保存しておこう)
wrote memento: src\javaGoF\chap18Memento\serialize\game.dat
  :
  :
==== 18
現状: [money =  700, fruit = [おいしいリンゴ, おいしいみかん, おいしいバナナ, みかん, おいしいバナナ]]
所持金が増えました。
所持金は 800 円になりました。
　　　(だいぶ増えたので、現在の状態を保存しておこう)
wrote memento: src\javaGoF\chap18Memento\serialize\game.dat

==== 19
現状: [money =  800, fruit = [おいしいリンゴ, おいしいみかん, おいしいバナナ, みかん, おいしいバナナ]]
なにも起こりませんでした。
所持金は 800 円になりました。

###### ２回目 ######
==== 0
現状: [money =  800, fruit = [おいしいリンゴ, おいしいみかん, おいしいバナナ, おいしいバナナ]]
なにも起こりませんでした。
所持金は 800 円になりました。

==== 1
現状: [money =  800, fruit = [おいしいリンゴ, おいしいみかん, おいしいバナナ, おいしいバナナ]]
なにも起こりませんでした。
所持金は 800 円になりました。

==== 2
現状: [money =  800, fruit = [おいしいリンゴ, おいしいみかん, おいしいバナナ, おいしいバナナ]]
なにも起こりませんでした。
所持金は 800 円になりました。

==== 3
現状: [money =  800, fruit = [おいしいリンゴ, おいしいみかん, おいしいバナナ, おいしいバナナ]]
なにも起こりませんでした。
所持金は 800 円になりました。

==== 4
現状: [money =  800, fruit = [おいしいリンゴ, おいしいみかん, おいしいバナナ, おいしいバナナ]]
所持金が増えました。
所持金は 900 円になりました。
　　　(だいぶ増えたので、現在の状態を保存しておこう)
wrote memento: src\javaGoF\chap18Memento\serialize\game.dat

###### game.dat ######
(binary fileのため、開けるけど文字化けしてます)

【解答】
fileNameのみフィールドになっていた。あとは同じ。
確かに main(), gameStart(), readMemeto(), writeMemento()
の４つのメソッドを渡るのだから、引数ではなくフィールドにすべきだ。
*/