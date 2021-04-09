/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainDirectory.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p433 / List 9-21
 * @content Files.createDirectory(), createDirectories(),
 *          delete, deleteIfExists()
 * @see ./ dataDir / imageMainDirectory.jpg
 * @author shika
 * @date 2021-04-09
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainDirectory {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        Path pathDir = Paths.get(dir + "dataDir");
        Path pathDeep = Paths.get(dir + "dirX/dirY/temp.txt");

        //ディレクトリ作成
        try {
            //Files.createDirectory(pathDir); //二度目は FileAlreadyExistsException
            //Files.createDirectories(pathDeep);
            //Files.delete(pathDeep);         //存在しないと NoSuchFileException
            Files.deleteIfExists(Paths.get("dirZ" + pathDeep));
                                           //存在しなくても例外なし
            Files.deleteIfExists(pathDir); //空でないと DirectoryNotEmptyException

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- Result Image ----
@see ./ dataDir / imageMainDirectory.jpg

dirX/dirY/temp.txt なぜか二重にできているが・・
*/