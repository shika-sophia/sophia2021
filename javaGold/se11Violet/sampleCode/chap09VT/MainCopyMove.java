/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainCopyMove.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p434 / List 9-22
 * @content Files.copy(), move()
 * @author shika
 * @date 2021-04-09
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MainCopyMove {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        Path path1 = Paths.get(dir + "data.txt");
        Path path2 = Paths.get(dir + "data_copy.txt");
        Path path3 = Paths.get(dir + "data2.txt");
        Path path4 = Paths.get(dir + "dataDir/data_move.txt");

        try {
            Files.copy(path1, path2);
            Files.move(path3, path4,
                    StandardCopyOption.REPLACE_EXISTING);
            Files.delete(path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
【考察】
    copy(path1, path2)
    move(path1, path4,
        StandardCopyOption.REPLACE_EXISTING);
のとき、copy(path1, path2)のほうにも
REPLACE_EXISTINGが適用され上書きされていた。

    copy(path1, path2)
    move(path3, path4,
        StandardCopyOption.REPLACE_EXISTING);
に変更すると copy()は上書きせずに、
別のファイル(存在しない場合はPathで指定したファイル名を作成)に
コピーしてました。

path1を複数で利用する場合、他で REPLACE_EXISTINGすると
無指定のときも REPLACE_EXISTINGが適用されるようです。

*/