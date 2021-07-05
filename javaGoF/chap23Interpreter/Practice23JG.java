package javaGoF.chap23Interpreter;

import javaGold.PracticeEditor;

public class Practice23JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class

/*
(1) 練習問題 23-1 / ミニ言語の実行プログラム
    => 問 サンプル parseNodeパッケージは、ミニ言語を解析するプログラム。
    *  それを実行して、GUIに表示する。
    *  practiceNodeパッケージに記述。
    => 【降参】
    *  parseNodeを そのまま利用。 Stringを入れると nodeで返すので、
    *  そのnodeを String解析して、各 orderにしようと思ったが複雑すぎて失敗。
    *
    *  parse()でメソッドチェーンするので、そこに Listを引数にして、
    *  orderListを作ろうと思ったが、どこまで repeatなのか不明なデータとなり、却下。
    *
    *  actionPerfored()内 txArea.getText()で orderを取得
    *  -> parseNodeの解析: サンプルコードのパッケージ
    *  -> ParseOrder: nodeの String解析
    *  -> CommandPractice: 基本命令の振り分けと、その処理
    *  -> Canvas.repaint(): JFrameに再描画
    *  という流れにする予定だったが、
    *  JFrame, Canvas, データ解析系のクラスをちゃんと繋げることができず、
    *  すでに４日間 考えつつ作ってみたが、まだ力不足を認めて Give up。
    *  解答コードを確認す。

*/