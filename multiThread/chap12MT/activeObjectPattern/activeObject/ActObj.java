package multiThread.chap12MT.activeObjectPattern.activeObject;

public interface ActObj {
    public abstract AbsResult<String> makeString(int count, char fillchar);
    public abstract void showString(String str);
    public abstract AbsResult<String> add(String x, String y);
    public abstract AbsResult<String> search(String word);
}//interface
