/*
 * @title utility / cmdExecute.java
 * @content コマンドプロンプトを javaから実行
 * @see // sepJavaRecurrent // javaSilver.FileSystem.java
 * @author shika
 * @date 2021-01-22
 */
package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdExecute {

    public void cmdExecutor(String cmd){
        List<String> cmdList = new ArrayList<>(
                Arrays.asList("cmd","/c"));
        cmdList.add(cmd);

        ProcessBuilder prcBld = new ProcessBuilder(cmdList);
        prcBld.redirectErrorStream(true);

        Process prc = null;
        try {
            prc = prcBld.start();

            BufferedReader reader =
                new BufferedReader(new InputStreamReader(prc.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = prc.exitValue();
        System.out.printf("result=%d%n", result);
    }//commandExecutor

    //====== Test main() ======
    public static void main(String[] args) {
        var cmdExe = new CmdExecute();
        cmdExe.cmdExecutor("@cd");
        //カレントディレクトリを問うコマンド
        //   -> 現プロジェクトの絶対pathが出力される
    }//main()

}//class

/*
//====== Result ======
C:\Program Files\pleiades\workspace-web\janJava2021
result=0
*/