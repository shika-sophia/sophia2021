/**
 * @title multiThread / chap02MT / fieldInstance / MainChangeField.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable / 練習問題 2-4
 * @content private finalのフィールドが改変されるケースを検証
 * @author shika
 * @date 2021-02-26
 */
package multiThread.chap02MT.fieldInstance;

public class MainChangeField {

    public static void main(String[] args) {
        //インスタンス生成
        var user = new UserInfo("Alice", "Alaska");
        System.out.println("original: " + user.toString());

        //フィールドの変更
        StringBuffer info = user.getInfo();
        info.replace(12, 17, "Bobby"); //index12-17 は "Alice"の位置

        //インスタンス再表示
        System.out.println("replaced: " + user.toString());
    }//main()

}//class

/*
original: [UserInfo: <info name: Alice, address: Alaska />]
replaced: [UserInfo: <info name: Bobby, address: Alaska />]

＊replace()
String.replace(): 新たなStringオブジェクトを生成。
StringBuffer.replace(): 現在のオブジェクトの状態を変化させる。

＊private final のフィールド infoには他の値を代入不可だが
infoの中身 StringBufferインスタンスは mutableなので、
インスタンスの内容を外部から書き換えられてしまう。
*/