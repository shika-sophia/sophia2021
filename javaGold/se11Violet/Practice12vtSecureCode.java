/**
 * @title javaGold / se11Violet / Practice12vtSecureCode.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content  第12章 SecureCode
 * @author shika
 * @date 2021-05-09
 */
/* Appendix 2021-05-09
 * @costTime 21:40 - 21:47 ( 6 分)
 * @correctRate 正答率 100.00 ％ ( 〇8問 / 全8問 )
 */
package javaGold.se11Violet;

import javaGold.PracticeEditor;

public class Practice12vtSecureCode {

    public static void main(String[] args) {
        new PracticeEditor();
    }//main()

}//class
/*
//====== 2021-05-09 ======
 第12章 SecureCode
〇 （1） B
〇 （2） C
    => Path File.getCanonicalPath()

〇 （3） D
〇 （4） C, D
〇 （5） D
      => static finalにすることによって、クラスファイルが生成されたときに
          IDが固定化される。
〇 （6） F
      => 有効な特権とは、クラス自身が
          JavaのSecurityPolicyFileによって与えられている権限の範囲で実行処理を記述可能。
      => T AccessController.doPrivileged(
            new PrivilegedAction<T>() {
                public T run(){

                }
         });

〇 （7） E
     => 拡張for内で Mapの変更 remove()をしているので、
         ConcurrentModificationException 〔runtime〕
    => Itratorを用いると変更可
        Iterator<Integer> itr = map.keySet().iterator();
        while(itr.hasNext()){
            itr.next()
            itr.remove()
        }//while

〇 （8） B, E

開始時刻 21:40
終了時刻 21:47
所要時間 6 分
正答率 100.00 ％ ( 〇8問 / 全8問 )
*/

