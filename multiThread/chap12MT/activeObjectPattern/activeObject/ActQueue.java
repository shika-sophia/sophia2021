package multiThread.chap12MT.activeObjectPattern.activeObject;

class ActQueue {
    private final int MAX_REQUEST = 100;
    private final AbsRequest<?>[] requestQueue;
    private int tail; //次に putRequest()する index
    private int head; //次に takeRequest()する index
    private int count;
    public ActQueue() {
        this.requestQueue = new AbsRequest[MAX_REQUEST];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
    }//AbsRequestの数

    public synchronized void putRequest(AbsRequest<?> request) {
        while(count >= MAX_REQUEST) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        requestQueue[tail] = request;
        tail = ++tail % MAX_REQUEST;
        count++;
        notifyAll();
    }//putRequest()

    public synchronized AbsRequest<?> takeRequest() {
        while(count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        AbsRequest<?> request = requestQueue[head];
        head = ++head % MAX_REQUEST;
        count--;
        notifyAll();

        return request;
    }//takeRequest()
}//class
