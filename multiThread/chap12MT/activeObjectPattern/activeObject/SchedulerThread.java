package multiThread.chap12MT.activeObjectPattern.activeObject;

class SchedulerThread extends Thread {
    private final ActQueue queue;

    public SchedulerThread(ActQueue queue) {
        this.queue = queue;
    }

    public void invoke(AbsRequest<?> request) {
        queue.putRequest(request);
    }

    public void run() {
        while(true) {
            AbsRequest<?> request = queue.takeRequest();
            request.execute();
        }//while loop
    }
}//class
