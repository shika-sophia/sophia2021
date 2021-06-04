/**
 * @title javaGoF / chap09Bridge / MainBridge.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第９章 Bridge / List 9-1 ～ 9-5
 * @content 機能の階層と実装の階層を分離し、
 *          フィールド impl に実装の階層をのせ、Bridge(=橋)とする。
 * @content 練習問題 9-1 / RandomDisplayを追加
 * @content 練習問題 9-2 / ReadFileDisplayImplを追加。
 *          SimpleFileDisplayImplの引数なしコンストラクタを追加。
 *          同.setStr(String)を追加し、
 *          表示する文字列 strをインスタンス時ではなく、
 *          後から setStr()できるように変更。
 *          ReadFileDisplayImplで読み込んだ文字列は、
 *          ReadFile extends Simpleにすることで、枠線を付けて表示。
 * @content 練習問題 9-3 / DrawDisplayImplを追加。
 *          CountDisplay.gradualIncrease()を追加。
 *          AbsDisplayの各メソッドを Overrideする必要があるので、
 *          superはAbsDisplay。
 *          CountDisplay.multiDisplay()だと
 *          <*****>と表示されるので、
 *          逓増していくようにするため gradualIncrease()を追加。
 *
 *          あっ、最大数は固定値ではなく、ランダムなので
 *          gradualIncrease()は、RandomDisplayに追加。
 *          ランダム数だけ返すメソッドを分離し、
 *          randomDisplay()と gradualIncrease()で共有。
 *
 *          => 【解答】 guradualIncrease()は別機能なので、
 *          新しいクラスとすべき。
 *          IncrementDisplayを創設。guradualIncrease()を移転
 *
 * @class MainBridge / ◆main()
 * @package ---- bridgeFunction / 機能の階層 ----
 * @class BridgeDisplay / impl / open(),print(),close(),display()
 * @class CountDisplay extends BridgeDisplay / multiDisplay()
 * @class RandomDisplay extends CountDisplay / randomReturn(), randomDisplay()
 * @class IncrementDisplay extends randomDisplay / gradualIncrease()
 *
 * @package ---- bridgeImplementation / 実装の階層 ----
 * @class AbsDisplayImpl
 * @class SimpleDisplayImpl extends AbsDisplayImpl
 * @class ReadFileDisplayImpl extends SimpleDisplayImpl
 * @file  textData.txt
 * @class DrawDisplayImpl extends AbsDisplay
 *
 * @author shika
 * @date 2021-06-03, 06-04
 */
package javaGoF.chap09Bridge;

import javaGoF.chap09Bridge.bridgeFunction.BridgeDisplay;
import javaGoF.chap09Bridge.bridgeFunction.CountDisplay;
import javaGoF.chap09Bridge.bridgeFunction.IncrementDisplay;
import javaGoF.chap09Bridge.bridgeFunction.RandomDisplay;
import javaGoF.chap09Bridge.bridgeImplementation.DrawDisplayImpl;
import javaGoF.chap09Bridge.bridgeImplementation.ReadFileDisplayImpl;
import javaGoF.chap09Bridge.bridgeImplementation.SimpleDisplayImpl;

public class MainBridge {

    public static void main(String[] args) {
        BridgeDisplay d1 = new BridgeDisplay(
                new SimpleDisplayImpl("Hello Japan"));
        BridgeDisplay d2 = new CountDisplay(
                new SimpleDisplayImpl("Hello World"));
        CountDisplay d3 = new CountDisplay(
                new SimpleDisplayImpl("Hello Universe"));
        RandomDisplay d4 = new RandomDisplay(
                new SimpleDisplayImpl("Hello Random"));
        BridgeDisplay d5 = new BridgeDisplay(
                new ReadFileDisplayImpl("textData.txt"));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
        d4.randomDisplay(5);
        d5.display();

        IncrementDisplay d6 = new IncrementDisplay(
                new DrawDisplayImpl());
        d6.gradualIncrease(8);
    }//main()

}//class

/*
+-----------+
|Hello Japan|
+-----------+
+-----------+
|Hello World|
+-----------+
+--------------+
|Hello Universe|
+--------------+
+--------------+
|Hello Universe|
|Hello Universe|
|Hello Universe|
|Hello Universe|
|Hello Universe|
+--------------+
+------------+
|Hello Random|
|Hello Random|
|Hello Random|
+------------+
+------------+
|Hello Random|
|Hello Random|
+------------+
+------------+
|Hello Random|
|Hello Random|
|Hello Random|
|Hello Random|
+------------+
+--------------+
|Hello TextFile|
+--------------+

マークを入力してください。 * / # -> *
<>
<*>
<**>
<***>
<****>
<*****>
<******>

マークを入力してください。 * / # -> #
|-
|#-
|##-
|###-

マークを入力してください。 * / # -> #
|-
|#-
|##-
|###-
|####-
|#####-
|######-
|#######-

マークを入力してください。 * / # -> 8
<!> 「*」か「#」で入力してください。
マークを入力してください。 * / # -> -1
<!> 「*」か「#」で入力してください。
マークを入力してください。 * / # -> &
<!> 「*」か「#」で入力してください。
マークを入力してください。 * / # -> #

 */

