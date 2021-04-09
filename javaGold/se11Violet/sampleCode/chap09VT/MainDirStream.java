/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainDirStream.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p441 / List 9-27
 * @content FileSystems.getDefault() -> FileSystem
 *          FileSystem.getRootDirectories() -> Iterable<Path>
 *          Files.newDirectoryStream() -> DirectoryStream<Path>
 * @author shika
 * @date 2021-04-09
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainDirStream {

    public static void main(String[] args) {
        String dir = "src/javaGold/se11Violet/sampleCode/chap09VT/";
        FileSystem fileSystem = FileSystems.getDefault();
        Iterable<Path> itrDir = fileSystem.getRootDirectories();

        for(Path root : itrDir) {
            System.out.println("Root: " + root);
        }//for
        System.out.println();

        Path path1 = Paths.get(dir);
        try(DirectoryStream<Path> dirStream =
                Files.newDirectoryStream(path1) ) {

            for(Path file : dirStream) {
                System.out.println(file.getFileName());
            }//for

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();


    }//main()
}//class

/*
Root: C:\

data.txt
data2.txt
data3.txt
data4.txt
dataDir
MainBuffered.java
MainCopyMove.java
MainDataStream.java
MainDirectory.java
MainDirStream.java
MainFileAttribute.java
MainFileReaderWriter.java
MainFilesBoolean.java
MainFileStream.java
MainTryWithResource.java

*/
