/**
 * @title utility / cmdDiv / cmdExecute.java
 * @content コマンドプロンプトを javaから実行
 * @see // sepJavaRecurrent // javaSilver.FileSystem.java
 * @reference ◆JavaのProcessBuilderを使ってバッチファイルを実行する方法【初心者向け】
 * @URL          https://techacademy.jp/magazine/19751
 * @reference ◆Windowsコマンドプロンプト 文字コード設定
 * @URL          https://qiita.com/user0/items/a9116acc7bd7b70ecfb0
 * @author shika
 * @date 2021-01-22 ～ 2021-01-24
 */
package utility.cmdDiv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CmdExecute extends AbsCmdExe{
    {
        setCd();
        setPathSrc();
    }

    public CmdExecute() { }

    public CmdExecute(String className) {
        super(className);
    }

    public CmdExecute(String className, String command) {
        super(className);
        cmdExecutor(command);
    }

    public String cmdExecutor(String command){
        var bld = new StringBuilder();

        List<String> cmdList = new ArrayList<>(
                Arrays.asList("cmd","/c", command));

        ProcessBuilder prcBld = new ProcessBuilder(cmdList);
        prcBld.redirectErrorStream(true);

        Process prc = null;
        BufferedReader reader = null;
        try {
            prc = prcBld.start();

            reader = new BufferedReader(
                       new InputStreamReader(
                        prc.getInputStream(), Charset.forName("UTF-8") ));

            String line;
            while ((line = reader.readLine()) != null) {
                bld.append(line);
            }//while

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//try-catch-finally

        //---- Test print ----
        //int result = prc.exitValue();
        //System.out.printf("result=%d%n", result);

        return bld.toString();
    }//commandExecutor


    //====== setter ======
    @Override
    protected void setCd() {
        super.cd = cmdExecutor("@cd");
    }

    @Override
    protected void setPathSrc() {
        super.pathSrc = cd + "\\src\\" + classNameCpl;
    }

//    //====== Test main() ======
//    public static void main(String[] args) {
//        var cmdExe = new CmdExecute();
//        String result =cmdExe.cmdExecutor("java -cp ./build/classes swing.sample.SampleWindowListener");
//        //String result = cmdExe.cmdExecutor("javac @filename");
//        System.out.println(result);
//    }//main()

}//class

/*
//====== Result ======
cmdExecutor("@cd");
C:\Program Files\pleiades\workspace-web\janJava2021
result=0

cmdExecutor("chcp 65001");//chcp 65001 -> UTF-8
Active code page: 65001

cmdExecutor("chcp 932");  //chcp 932 -> Shift-JIS
���݂̃R�[�h �y�[�W: 932
(現在のコード ページ: 932)

cmdExecutor("java -version --chcp 65001");
openjdk version "11.0.5" 2019-10-15
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.5+10)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.5+10, mixed mode)

//文字化け問題(未解決)
cmdExecutor("java Fake --chcp 65001");

�G���[: ���C���E�N���XFake�����o����у��[�h�ł��܂���ł���
����: java.lang.ClassNotFoundException: Fake
(エラー: メイン・クラスFakeを検出およびロードできませんでした
原因: java.lang.ClassNotFoundException: Fake)

◆絶対パスの問題
cmdExecutor(
    "java -cp C:\\Program Files/pleiades/workspace-web/janJava2021/build/classes/swing/sample
    swing.sample.SampleWindow");
    エラー: メイン・クラスFiles\\pleiades\\workspace-web\\janJava2021\\build\\classes\\swing\\sample
    を検出およびロードできませんでした
    原因: java.lang.ClassNotFoundException:
    Files\\pleiades\\workspace-web\\janJava2021\\build\\classes\\swing\\sample

【考察】2021-01-23
Windowsの「Program Files」に半角スペースが空いているので、
-cp (class-path)オプションを利用すると、「Files～」以下を クラスファイル名と認識している。

それで、C直下に pleiadesを置くんか。
このエクリプスは「Program Files」下に置いてあり、改善するなら C直下に入れ直しが必要。
(註: Program Filesのファイル名をいじるのは禁じ手。この下のコンテンツ全てのPathが狂うので動作しなくなる可能性がある)
↑前にやった。少なくとも eclipseは全てのファイルのビルドパスが崩れて、壊れます。

引っ越しするなら、現在のプロジェクトを全て warファイル(jarも可?)にして
新しい eclipseに入れ直す必要がある。
    ↓
相対パスにすればいい。(ふりだしに戻る)
cmdExecutor("@cd");
C:\Program Files\pleiades\workspace-web\janJava2021
    ↓
それか、 -cpをクラス名の後ろに記述すればいいのかも
◆コマンドラインで検証
cd で カレントをここにする。
(eclipseでコンパイルは済んでいて、classファイルがここにある)
C:\Program Files\pleiades\workspace-web\janJava2021\build\classes>

>java swing.sample.SampleWindow
で実行できる。

ただし、CmdExecute(=このクラス)は一文ずつしか実行できず、
２文を実行すると、その都度、コマンドプロンプトのデフォルトに戻されるようだ。
つまり cdでカレントを移動できないので -cp (= --class-path) 相対パスで一文で実行するしかない。

◆成功！
cmdExecutor("java -cp ./build/classes swing.sample.SampleWindow");

おお、javaからコマンドプロンプト経由で swingプログラムを実行できた！
これで、いちいちデスクトップにソースファイルをコピーしてコマンドプロンプトで実行せんでも
CmdExecuteを呼び出せば、行けるぞ～

(ちなみに私のこのeclipseは
旧バージョン[pleiades-2019-12-java-win-64bit-jre_20200213]

JDKは
C:\Users\sophia>java -version
openjdk version "11.0.7" 2020-04-14
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.7+10)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.7+10, mixed mode)

のため、そのままeclipseで swingを実行できるのであった。eclipseの引っ越しできないやん。
この CmdExecuteは 最新のeclipseだと、そのまま実行できないため、それ用のクラスです。)
*/