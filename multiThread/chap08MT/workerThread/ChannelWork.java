package multiThread.chap08MT.workerThread;

import java.util.Arrays;

public class ChannelWork {
    protected static final int MAX_REQUEST = 100;
    protected final RequestWork[] requestAry;
    protected final WorkerThread[] threadPool;
    protected volatile int tail; //次に putRequest()する index
    protected volatile int head; //次に takeRequest()する ingex
    protected volatile int count;//Requestの数
    protected static int totalRequest;
    protected static int totalExecute;

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

    public synchronized void putRequest(RequestWork request)
            throws InterruptedException {
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
        totalRequest++;
    }//putRequest()

    public synchronized RequestWork takeRequest()
            throws InterruptedException {
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
        totalExecute++;
        return request;
    }//takeRequest()

    public static int getTotalRequest() {
        return totalRequest;
    }

    public static int getTotalExecute() {
        return totalExecute;
    }

    public void stopAllWorker() {
        Arrays.stream(threadPool).forEach(th -> th.stopThread());
    }
}//class
