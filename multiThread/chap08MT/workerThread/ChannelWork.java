package multiThread.chap08MT.workerThread;

import java.util.Arrays;

public class ChannelWork {
    private static final int MAX_REQUEST = 100;
    private final RequestWork[] requestAry;
    private final WorkerThread[] threadPool;
    private volatile int tail; //次に putRequest()する index
    private volatile int head; //次に takeRequest()する ingex
    private volatile int count;//Requestの数

    public ChannelWork(int threadNum) {
        this.requestAry = new RequestWork[MAX_REQUEST];
        this.threadPool = new WorkerThread[threadNum];
        this.tail = 0;
        this.head = 0;
        this.count = 0;

        for (int i = 0; i < threadNum; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }//constructor

    public void startWorker() {
        Arrays.stream(threadPool).forEach(Thread::start);
    }

    public synchronized void putRequest(RequestWork request) {
        while(count >= requestAry.length) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        requestAry[tail] = request;
        tail = (++tail % requestAry.length);
        count++;
        notifyAll();
    }//putRequest()

    public synchronized RequestWork takeRequest() {
        while(count <= 0) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while

        RequestWork request = requestAry[head];
        head = (++head % requestAry.length);
        count--;
        notifyAll();

        return request;
    }//takeRequest()
}//class
