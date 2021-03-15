package multiThread.chap08MT.threadPerMessage;

import multiThread.chap08MT.workerThread.ChannelWork;
import multiThread.chap08MT.workerThread.RequestWork;
import multiThread.chap08MT.workerThread.WorkerThread;

public class ChannelPerMess extends ChannelWork {

    public ChannelPerMess(int threadNum) {
        super(threadNum);
    }//constructor

    @Override
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
        totalRequest++;
        new WorkerThread(request.toString(), this).start();
    }//putRequest()

}//class
