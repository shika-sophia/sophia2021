package multiThread.chap10MT.swingExeCancel;

public class ServiceSWThread extends Thread {
    private volatile boolean cancelRequest = false;

    public ServiceSWThread(Runnable actService) { }

    //====== getter, setter ======
    public boolean isCancelRequest() {
        return cancelRequest;
    }

    public void setCancelRequest() {
        cancelRequest = true;
    }

}//class
