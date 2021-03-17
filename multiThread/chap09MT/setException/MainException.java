/**
 * @title multiThread / chap09MT / setException / MainException.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第９章 Future / 練習問題 9-4 setException()
 * @content 解答 List A9-5, A9-6, A9-7
 * @content chap09MT / futureData / Exceptionを出す Main
 * @author shika
 * @date 2021-03-17
 */
package multiThread.chap09MT.setException;

public class MainException {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try {
            System.out.println("main BEGIN");

            HostException host = new HostException();
            AbsData data = host.request(-1, 'N');

            System.out.println("main END");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
main BEGIN
    request(-1, N) BEGIN
    request(-1, N) BEGIN
main END
    making RealData(-1,N)
Exception in thread "Thread-0" java.lang.NegativeArraySizeException: -1
    at multiThread.chap09MT.futureData.RealData.<init>(RealData.java:9)
    at multiThread.chap09MT.futureData.HostFuture$1.run(HostException.java:15)

【考察】
題意と異なり、この時点で ちゃんと終了している。
しかし、マルチスレッドなら起こりうる課題なので、ここに問題文の記述を書いておく。

request()内で新しく作ったThreadで 例外が発生すると、
そのThreadは止まっても、main-Threadは getContent()内で wait()したまま。
request(), getContent()を try-catchで囲っても main-Threadは例外を捕まえられない。とのこと。

//====== HostExeption, FutureDataExeption ======
@see List A9-5, A9-6, A9-7
main BEGIN
    request(-1, N) BEGIN
    request(-1, N) BEGIN
main END
    making RealData(-1,N)

【結果】今度は 例外が throwされずに終了。
なんか、動作がテキスト通りにいかぬ。

//====== FutureCallableException =====
main BEGIN
    request(-1, N) BEGIN
    request(-1, N) BEGIN
main END
    making RealData(-1,N)

【結果】こちらも同様
 */
