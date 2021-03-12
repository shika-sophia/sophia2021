package multiThread.chap07MT.serverModel;

import java.io.IOException;
import java.net.Socket;

public class ThreadService extends ServerService {
    public void service(Socket socket) {
        new Thread() {
            public void run() {
                doService(socket);
            }//run()
        }.start();
    }//service()

    protected void doService(Socket socket) {
        System.out.println("called doService()");
        try {
            super.service(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//doService()
}//class

/*
Litening on ServerSocket[addr=0.0.0.0/0.0.0.0,localport=8888]
Accepting...
Connected to Socket[addr=/127.0.0.1,port=61343,localport=8888]
SingleServer.callService()
Accepting...
called doService()
Connected to Socket[addr=/127.0.0.1,port=61344,localport=8888]
SingleServer.callService()
Thread-0 :service(Socket[addr=/127.0.0.1,port=61343,localport=8888]) BEGIN
 called doService()
Accepting...
Thread-1 :service(Socket[addr=/127.0.0.1,port=61344,localport=8888]) BEGIN
 Thread-1 :countdown i = 10
Thread-0 :countdown i = 10
Thread-1 :countdown i = 9
Thread-0 :countdown i = 9
Thread-0 :countdown i = 8
Thread-1 :countdown i = 8
Thread-0 :countdown i = 7
Thread-1 :countdown i = 7
Thread-1 :countdown i = 6
Thread-0 :countdown i = 6
Thread-1 :countdown i = 5
Thread-0 :countdown i = 5
Thread-0 :countdown i = 4
Thread-1 :countdown i = 4
Thread-0 :countdown i = 3
Thread-1 :countdown i = 3
Thread-1 :countdown i = 2
Thread-0 :countdown i = 2
Thread-0 :countdown i = 1
Thread-1 :countdown i = 1
Thread-1 :countdown i = 0
Thread-0 :countdown i = 0
Thread-0 :service(Socket[addr=/127.0.0.1,port=61343,localport=8888]) END
 Thread-1 :service(Socket[addr=/127.0.0.1,port=61344,localport=8888]) END
 Connected to Socket[addr=/127.0.0.1,port=61346,localport=8888]
SingleServer.callService()
Accepting...
called doService()
Thread-2 :service(Socket[addr=/127.0.0.1,port=61346,localport=8888]) BEGIN
 Thread-2 :countdown i = 10
Connected to Socket[addr=/127.0.0.1,port=61347,localport=8888]
SingleServer.callService()
Accepting...
called doService()
Thread-3 :service(Socket[addr=/127.0.0.1,port=61347,localport=8888]) BEGIN
 Thread-3 :countdown i = 10
Thread-2 :countdown i = 9
Thread-3 :countdown i = 9
Thread-2 :countdown i = 8
Thread-3 :countdown i = 8
Thread-2 :countdown i = 7
Thread-3 :countdown i = 7
Thread-2 :countdown i = 6
Thread-3 :countdown i = 6
Thread-2 :countdown i = 5
Thread-3 :countdown i = 5
Thread-3 :countdown i = 4
Thread-2 :countdown i = 4
Connected to Socket[addr=/127.0.0.1,port=61349,localport=8888]
SingleServer.callService()
Accepting...
called doService()
Thread-4 :service(Socket[addr=/127.0.0.1,port=61349,localport=8888]) BEGIN
 Thread-4 :countdown i = 10
Thread-3 :countdown i = 3
Thread-2 :countdown i = 3
Thread-4 :countdown i = 9
Thread-3 :countdown i = 2
Thread-2 :countdown i = 2
Thread-4 :countdown i = 8
Thread-2 :countdown i = 1
Thread-3 :countdown i = 1
Thread-4 :countdown i = 7
Thread-3 :countdown i = 0
Thread-2 :countdown i = 0
Thread-4 :countdown i = 6
Thread-2 :service(Socket[addr=/127.0.0.1,port=61346,localport=8888]) END
 Thread-3 :service(Socket[addr=/127.0.0.1,port=61347,localport=8888]) END
 Thread-4 :countdown i = 5
Thread-4 :countdown i = 4
Thread-4 :countdown i = 3
Thread-4 :countdown i = 2
Thread-4 :countdown i = 1
Thread-4 :countdown i = 0
Thread-4 :service(Socket[addr=/127.0.0.1,port=61349,localport=8888]) END
 Connected to Socket[addr=/127.0.0.1,port=61351,localport=8888]
SingleServer.callService()
Accepting...
called doService()
Thread-5 :service(Socket[addr=/127.0.0.1,port=61351,localport=8888]) BEGIN
 Thread-5 :countdown i = 10
Thread-5 :countdown i = 9
Thread-5 :countdown i = 8
Thread-5 :countdown i = 7
Thread-5 :countdown i = 6
Thread-5 :countdown i = 5
Thread-5 :countdown i = 4
Thread-5 :countdown i = 3
Thread-5 :countdown i = 2
Thread-5 :countdown i = 1
Thread-5 :countdown i = 0
Thread-5 :service(Socket[addr=/127.0.0.1,port=61351,localport=8888]) END

*/