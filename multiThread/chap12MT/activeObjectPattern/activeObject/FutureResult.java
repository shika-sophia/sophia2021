package multiThread.chap12MT.activeObjectPattern.activeObject;

public class FutureResult<T> extends AbsResult<T> {
    private AbsResult<T> result;
    private volatile boolean ready = false;

    public synchronized void setResult(AbsResult<T> result) {
        this.result = result;
        this.ready = true;
        notifyAll();
    }//setResult()

    @Override
    public synchronized T getResultValue() {
        while(!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while

        //RealResultで @Overrideした getResultValue()で値を取得
        return result.getResultValue();
    }//getResultValue()

}//class
