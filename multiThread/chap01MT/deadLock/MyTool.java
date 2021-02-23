package multiThread.chap01MT.deadLock;

public class MyTool {
    private final String toolName;

    public MyTool(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String toString() {
        return "[" + toolName + "]";
    }
}//class
