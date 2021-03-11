package multiThread.chap07MT.serverModel;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServerService {
    private ScheduledExecutorService scheduled;

    public ServerService() { } //at SingleServer

    public ServerService(ScheduledExecutorService scheduled) {
        this.scheduled = scheduled;
    }

    public void threadService(Socket clientSocket) {
        scheduled.scheduleAtFixedRate(
            new Runnable() {
                public void run() {
                    try {
                        service(clientSocket);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }//run()
            },
            0L, //long initialDelay
            1L, //long period
            TimeUnit.SECONDS
            );
    }//threadService()

    public void service(Socket clientSocket)
            throws IOException {
        System.out.printf("%s :service(%s) BEGIN \n ",
            Thread.currentThread().getName(), clientSocket.toString());

        try {
            var out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeBytes("HTTP/1.0 200 OK \r\n");
            out.writeBytes("Content-type: text/html \r\n");
            out.writeBytes("\r\n");
            out.writeBytes("<html><head><title>CountDown</title></head><body>");
            out.writeBytes("<h1>Countdown start!</h1>");

            for (int i = 10; i >= 0; i--) {
                System.out.printf("%s :countdown i = %d \n",
                    Thread.currentThread().getName(), i);
                out.writeBytes("<h1>" + i + "</h1>");
                out.flush();

                slowly(1000L);
            } //for i

            out.writeBytes("</body></html>");
        } finally {
            clientSocket.close();
        }

        System.out.printf("%s :service(%s) END \n ",
            Thread.currentThread().getName(), clientSocket.toString());
    }//service()

    private static void slowly(long rest) {
        try {
            Thread.sleep(rest);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//slowly
}//class
