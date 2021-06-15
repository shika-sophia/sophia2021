/**
 * @title javaGoF / chap14ChainResponse / Practice14JG.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content  第14章 練習問題 14-1, 14-2, 14-3, 14-4
 * @author shika
 * @date 2021-06-15
 */
/* Appendix 2021-06-15
 * @costTime 11:45 - 11:59 ( 14 分)
 * @correctRate 正答率 86.67 ％ ( 〇13問 / 全15問 )
 */
package javaGoF.chap14ChainResponse;

import javaGold.PracticeEditor;

public class Practice14JG {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-06-15 ======
 第14章 練習問題 14-1
〇 （1） 問 ウィンドウシステムにおいて、next()はどこに登場するか
〇 （2） swingで、マウスクリックやボタンクリックなどのイベントは EventListenerで認識、
〇 （3） その処理は EventDisptchThreadで一括に処理される。
〇 （4） イベント待ち行列に Queueが用いられ、待機しているイベントを取り出し、
〇 （5） それを処理クラスのチェーンに掛けていると思われ、
Ｘ （6） 適正な処理クラスに当たるまで、next()で順次たらい回ししている。
    => 【解答】
    *  コンポネントが乗っている ウィンドウクラスでは各処理は行わないので
    *  next()が多くなる。
    *  (実際の挙動ではなく、あくまでクラス構成に
    *  そのままChainパターンをあてはめて考える問題のよう)
    *
 14-2
〇 （1） 問 選択リストと、チェックボックスでフォーカスのある場所によって
〇 （2） 矢印keyの挙動が異なるのはなぜか
〇 （3） 選択リストは ListSelectionListenerであり、チェックボックスは
〇 （4） また別のListenerでイベント待機。
〇 （5） このパターンで言うと処理クラスが異なるため、矢印keyを押したときの挙動も異なる
    => 【解答】
    *  リスト選択で↑↓には、イベント処理が記述されている。
    *  チェックボックスに矢印は必要ないので、next()されて、
    *  ウィンドウの矢印イベントが呼び出されている。

 14-3
〇 （1） public support()は広く他クラスに公開し、メソッド利用を期待する。
Ｘ （2） protected resolve()は継承関係内もしくは同パッケージで外部には公開しない処理である。
    => 【解答】
    *  他クラスからの「トラブル解決」要求は support()を使ってほしいとの意思の現れ。
    *  resolve()を publicにすると、
    *  AbsSupportと関係のないクラスからも呼び出すことが可能となり、
    *  本来の期待していた使い方をされない危険性。
    *  また修正時にpublicだと、他クラスのあちこちに散らばってしまう。

 14-4
〇 （1） support()を再帰呼出ではなくループにする。
〇 （2）      サンプルコードに追加。
    => やっぱここに記述。
    *  AbsSupport.nextは１つずつ次の AbsSupportを保持しているだけなので
    *  フィールドに List<AbsSupport> nextList;が必要。
    *  setNext()内に nextList.add(AbsSupport);を記述。
    *  public void support() {
    *      nextList.forEach(next -> this.resolve(next));
    *  }
    *  あっ、 if文を忘れとった。
    *  support(Trouble), resolve(Trouble)やった。
    *  全然ちゃうやん。
    *
    *  => 解答は List定義してない。
    *  Listで全チェーンをループすると、毎回全部の処理クラスを回ることになり、
    *  サンプルでの support()の使い方は、各クラスで遷移のたびに呼び出すので、
    *  Listで全クラスをループさせたらあかん。こっちは１回だけ呼び出す場合の処理。
    *
    *  【解答コード】
    *  piblic final void support(Trouble trouble){
    *    for(AbsSupport obj = this; true; obj = obj.next){
    *      if(obj.resolve(trouble)){
    *        obj.done();
    *        break;
    *      } else if(obj.next == null){
    *        obj.fail(trouble);
    *        break;
    *      }
    *    }//for
    * }//support()

開始時刻 11:45
終了時刻 11:59
所要時間 14 分
正答率 86.67 ％ ( 〇13問 / 全15問 )
*/

