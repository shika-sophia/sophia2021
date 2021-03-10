package multiThread.chap07MT.serverModel;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerService {
    private ServerService() {
    }

    public static void service(Socket clientSocket)
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

                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } //for i

            out.writeBytes("</body></html>");
        } finally {
            clientSocket.close();
        }

        System.out.printf("%s :service(%s) END \n ",
            Thread.currentThread().getName(), clientSocket.toString());
    }//service()
}//class
