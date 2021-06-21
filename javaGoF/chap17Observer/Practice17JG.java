package javaGoF.chap17Observer;

import javaGold.PracticeEditor;

public class Practice17JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class

/*
(1) 練習問題 17-1
    => IncrementNumberGeneratorを追加。
    => 〔回答〕 My Answer
    *  public void execute() {
    *    for(number = begin; number < end; number += step) {
    *        notifyObserver();
    *    }//for
    *  }//execute()
    *
    => 【解答】 Text Answer
    *  ※ コンストラクタで number = begin;
    *
    *  while(number < end){
    *    notifyObserver();
    *    number += step;
    *  }//while
    *
    => 【考察】
    *  for文より、while文のがシンプル。
    *  私もコンストラクタで begin代入を考えたが、
    *  他のロジックに転用できなくなるので、メソッド内で begin代入とした。

(2) 17-2
    => package swingObserver
    => 【解答】 CircleGraphObserver
    *  swing登場以前の java.awtのクラス群で円グラフを作っているので
    *  写経しておく。
    *
    *  それと、私は間に DataListObserverを挟まないと
    *  swing描画に持っていけなかったが、解答は直で 描画している。
    *
    *  Obserberパターンは毎回、状態が変わるたびに処理ができる。
    *  解答では、最後のデータでのみ表示。
    *  repaint()により、最終結果には１枚しか現れないが、
    *  本当は回数分を描画している。
    *
    *  全体の結果から割合を円グラフで描画するなら、
    *  やはり、DataListObserverが必要。

*/
