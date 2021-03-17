package multiThread.chap09MT.setException;

import java.util.concurrent.ExecutionException;

public interface AbsData {

    public abstract String getContent() throws ExecutionException;

}//interface
