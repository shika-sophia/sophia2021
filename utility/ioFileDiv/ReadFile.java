/**
 * @title utility / ioFileDiv/ ReadFile.java
 * @content pathを指定し、そのファイルの読み込み
 * @reference 結城浩『Java言語プログラミングレッスン(下)』SB Creative,2012 / p224
 * @author shika
 * @date 2021-01-24, 01-26
 */

package utility.ioFileDiv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile extends AbsFileSystem {
    public ReadFile(){ }

    public ReadFile(String path) {
        super.readText = readPathFile(path);
    }

    public String readPathFile(String path) {
        var bld = new StringBuilder();

        try(var reader = new BufferedReader(new FileReader(path))){

            String line;
            while((line = reader.readLine()) != null) {
                bld.append(line).append("\n");
            }//while

            reader.close();
        } catch(FileNotFoundException e) {
            System.out.println(path + "が見つかりません。");
        } catch(IOException e) {
            e.printStackTrace();
        }

        String readText = bld.toString();
        setReadText(readText);
        return readText;
    }//readPathFile()

    @Override
    protected void setReadText(String readText) {
        super.readText = readText;
    }//setReadText()

    //@abstract
    protected void setJavaDoc(String javaDoc){
        ;  //BuildJavaDocクラスで定義
    }

}//class

