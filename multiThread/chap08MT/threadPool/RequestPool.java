package multiThread.chap08MT.threadPool;

import multiThread.chap08MT.workerThread.RequestWork;

public class RequestPool extends RequestWork {

    public RequestPool(String name, int number) {
        super(name, number);
    }

    @Override
    public void run() {
        super.execute();
    }

}//class
