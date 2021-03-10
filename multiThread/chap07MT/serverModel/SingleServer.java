package multiThread.chap07MT.serverModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleServer {
    protected final int protoNumber;

    public SingleServer(int protoNumber) {
        this.protoNumber = protoNumber;
    }

    public void execute() throws IOException {
        ServerSocket socket = new ServerSocket(protoNumber);
        System.out.println("Litening on " + socket);

        try {
            while(true) {
                System.out.println("Accepting...");
                Socket clientSocket = socket.accept();
                System.out.println("Connected to " + clientSocket);;

                ServerService.service(clientSocket);
            }//while loop
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }//execute()
}//class
