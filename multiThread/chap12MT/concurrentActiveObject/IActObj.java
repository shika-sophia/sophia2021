package multiThread.chap12MT.concurrentActiveObject;

import java.util.concurrent.Future;

public interface IActObj {
    public abstract Future<String> makeStr(int count, char fillchar);
    public abstract void showStr(String str);
    public abstract void shutdown();
    public abstract Future<String> add(String x, String y);
}//interface
