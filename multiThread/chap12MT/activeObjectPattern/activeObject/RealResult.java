package multiThread.chap12MT.activeObjectPattern.activeObject;

class RealResult<T> extends AbsResult<T> {
    private final T resultValue;

    public RealResult(T realValue) {
        this.resultValue = realValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }

}//class
