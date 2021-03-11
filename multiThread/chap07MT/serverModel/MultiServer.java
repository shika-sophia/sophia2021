package multiThread.chap07MT.serverModel;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class MultiServer extends SingleServer {
    ScheduledExecutorService scheduled
        = Executors.newScheduledThreadPool(5);

    public MultiServer(int protoNumber) {
        super(protoNumber);
    }

    @Override
    protected void callService(Socket clientSocket)
            throws IOException {
        System.out.println("MultiServer.callService()");
        new ServerService(scheduled).service(clientSocket);
    }//callService()
}//class
