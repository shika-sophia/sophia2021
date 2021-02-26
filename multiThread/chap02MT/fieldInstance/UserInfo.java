/**
 * @title multiThread / chap02MT / fieldInstance / UserInfo.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第２章 Immutable / 練習問題 2-4
 * @content private finalのフィールドが改変されるケースを検証
 * @author shika
 * @date 2021-02-26
 */
package multiThread.chap02MT.fieldInstance;

public class UserInfo {
    private final StringBuffer info;

    public UserInfo(String name, String address) {
        this.info = new StringBuffer();
        info.append("<info name: ").append(name)
            .append(", address: ").append(address).append(" />");
    }//constructor

    @Override
    public String toString() {
        return "[UserInfo: " + info.toString() + "]";
    }//toString()

    public StringBuffer getInfo() {
        return info;
    }

}//class

