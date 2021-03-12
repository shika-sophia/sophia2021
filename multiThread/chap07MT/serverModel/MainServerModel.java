/**
 * @title multiThread / chap07MT / serverModel / MainServerModel.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門～マルチスレッド編 [増補改訂版]』, 2006
 * @content 第７章 Thread-Per-Message / 練習問題 7-6
 * @content List 7-18, 7-19, 7-20,
 * @content List A7-5 ThreadService
 * @content serverにおける応答性の改善
 * @note 【実行方法】 ローカルマシンで javaを実行し、webブラウザで「http://127.0.0.1:8888/」にアクセス
 * @author shika
 * @date 2021-03-10, 3-11, 3-12
 */

package multiThread.chap07MT.serverModel;

import java.io.IOException;

public class MainServerModel {

    public static void main(String[] args) {
        try {
            new SingleServer(8888).execute();
            //new MultiServer(8888).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
【実行方法】 ローカルマシンで javaを実行し、webブラウザで「http://127.0.0.1:8888/」にアクセス
//====== SingleServer ======
Litening on ServerSocket[addr=0.0.0.0/0.0.0.0,localport=8888]
Accepting...
Connected to Socket[addr=/127.0.0.1,port=55126,localport=8888]
main :service(Socket[addr=/127.0.0.1,port=55126,localport=8888]) BEGIN
main :countdown i = 10
main :countdown i = 9
main :countdown i = 8
main :countdown i = 7
main :countdown i = 6
main :countdown i = 5
main :countdown i = 4
main :countdown i = 3
main :countdown i = 2
main :countdown i = 1
main :countdown i = 0
main :service(Socket[addr=/127.0.0.1,port=55126,localport=8888]) END

Accepting...
Connected to Socket[addr=/127.0.0.1,port=55127,localport=8888]
MultiServer.callService()
main :service(Socket[addr=/127.0.0.1,port=55127,localport=8888]) BEGIN
main :countdown i = 10
main :countdown i = 9
main :countdown i = 8
main :countdown i = 7
main :countdown i = 6
main :countdown i = 5
main :countdown i = 4
main :countdown i = 3
＾C

//====== MultiServer ======
【考察】 挙動としてあまり変わった気がしない。
待ち受けも coundownが全て完了してから Accepting...が出ているし、
実際、他ブラウザは coundown完了まで待たされる。
ScheduledExecutorServiceで countdownを表現できたのは成果。

Litening on ServerSocket[addr=0.0.0.0/0.0.0.0,localport=8888]
Accepting...
Connected to Socket[addr=/127.0.0.1,port=62026,localport=8888]
main :service(Socket[addr=/127.0.0.1,port=62026,localport=8888]) BEGIN
 main :countdown i = 10
main :countdown i = 9
main :countdown i = 8
main :countdown i = 7
main :countdown i = 6
main :countdown i = 5
main :countdown i = 4
main :countdown i = 3
main :countdown i = 2
main :countdown i = 1
main :countdown i = 0
main :service(Socket[addr=/127.0.0.1,port=62026,localport=8888]) END
 Accepting...
Connected to Socket[addr=/127.0.0.1,port=62027,localport=8888]
main :service(Socket[addr=/127.0.0.1,port=62027,localport=8888]) BEGIN
 main :countdown i = 10
main :countdown i = 9
main :countdown i = 8
main :countdown i = 7
main :countdown i = 6
main :countdown i = 5
main :countdown i = 4
main :countdown i = 3
main :countdown i = 2
main :countdown i = 1
main :countdown i = 0
main :service(Socket[addr=/127.0.0.1,port=62027,localport=8888]) END
 Accepting...
Connected to Socket[addr=/127.0.0.1,port=62028,localport=8888]
main :service(Socket[addr=/127.0.0.1,port=62028,localport=8888]) BEGIN
 main :countdown i = 10
main :countdown i = 9
main :countdown i = 8
main :countdown i = 7
main :countdown i = 6
main :countdown i = 5
main :countdown i = 4
main :countdown i = 3
main :countdown i = 2
main :countdown i = 1
main :countdown i = 0
main :service(Socket[addr=/127.0.0.1,port=62028,localport=8888]) END
 Accepting...
Connected to Socket[addr=/127.0.0.1,port=62029,localport=8888]
main :service(Socket[addr=/127.0.0.1,port=62029,localport=8888]) BEGIN
 main :countdown i = 10
main :countdown i = 9
main :countdown i = 8
main :countdown i = 7
main :countdown i = 6
main :countdown i = 5
main :countdown i = 4
main :countdown i = 3
main :countdown i = 2
main :countdown i = 1
main :countdown i = 0
main :service(Socket[addr=/127.0.0.1,port=62029,localport=8888]) END
 Accepting...

 */
