package swing;

import utility.cmdDiv.CmdJavaExe;

public class SwingExecute extends CmdJavaExe{
    public SwingExecute(){ }

    public SwingExecute(String className) {
        super(className);
        cmdJavaEclipse();
    }//constructor

    public static void main(String[] args) {
        new SwingExecute("swing.sample.SampleWindow$1");
    }
}//class

/*
//====== 考察 / 2021-01-25 ======
eclipseでこのクラスを直接実行できないときのために、
実行したいクラスに このような main()を用意し、
swing部分はメソッド or コンストラクタにして、
コマンドプロンプトで実行することを考えてみたが

public static void main(String[] args) {
    if(className == null){
        String className = new Object(){ }.getClass().getName();
        new SwingExecute(className);
    } else {
        sampleWnd()
    }
}//main()

これを記述すると
main() -> SwingExecute -> java SampleWind -> main() とループしてしまう。
if文を付けて メソッド呼び出し or コンストラクタ呼び出しにしても同様

「自動でコマンドプロンプト実行」という発想だったが、
SwingExecute(=ここのクラス)の main() に
完全修飾クラス名を手打ちして実行するしかなさそう。(無念・・)

ただ、クラス名からコマンドプロンプトを呼び出す cmdDivクラス群は
ちゃんと機能しているので、今後 使ってみよう。「$1」のところは改良が必要だな。
 */
