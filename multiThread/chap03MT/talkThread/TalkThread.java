package multiThread.chap03MT.talkThread;

import multiThread.chap03MT.guardedSuspension.Request;
import multiThread.chap03MT.guardedSuspension.RequestQueue;

public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input, RequestQueue output, String name) {
        super(name);
        this.input = input;
        this.output = output;
    }

    public void run() {
        System.out.println(currentThread().getName() + ": BEGIN");
        for(int i = 0; i < 20; i++) {
            Request request1 = input.getRequest();
            System.out.println(currentThread().getName() + " gets " + request1);

            Request request2 = new Request(request1.getName() + "!");
            System.out.println(currentThread().getName() + " puts " + request2);
            output.putRequest(request2);
        }//for

        System.out.println(currentThread().getName() + ": END");
    }//run
}//class
