/**
 * @title utility / cmdExecute.java
 * @content コマンドプロンプトを javaから実行
 * @see // sepJavaRecurrent // javaSilver.FileSystem.java
 * @reference ◆JavaのProcessBuilderを使ってバッチファイルを実行する方法【初心者向け】
 * @URL          https://techacademy.jp/magazine/19751
 * @author shika
 * @date 2021-01-22, 2021-01-23
 */
package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdExecute {

    public String cmdExecutor(String cmd){
        var bld = new StringBuilder();

        List<String> cmdList = new ArrayList<>(
                Arrays.asList("cmd","/c"));
        cmdList.add(cmd);

        ProcessBuilder prcBld = new ProcessBuilder(cmdList);
        prcBld.redirectErrorStream(true);

        Process prc = null;
        try {
            prc = prcBld.start();

            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(
                        prc.getInputStream(), Charset.forName("UTF-8") ));

            String line;
            while ((line = reader.readLine()) != null) {
                bld.append(line).append("\n");
            }//while
        } catch (IOException e) {
            e.printStackTrace();
        }

        //---- Test print ----
        //int result = prc.exitValue();
        //System.out.printf("result=%d%n", result);

        return bld.toString();
    }//commandExecutor


    //====== Test main() ======
    public static void main(String[] args) {
        var cmdExe = new CmdExecute();
        String result = cmdExe.cmdExecutor("javac @filename");
        System.out.println(result);
    }//main()

}//class

/*
//====== Result ======
C:\Program Files\pleiades\workspace-web\janJava2021
result=0

//文字化け問題(未解決)
�G���[: �t�@�C����������܂���: filename

*/