package multiThread.chap09MT.futureData;

public class RealData implements AbsData {
    private final String content;

    public RealData(int count, char c) {
        System.out.printf(
                "    making RealData(%d,%c)\n", count, c);
        char[] buffer = new char[count];
        for(int i = 0; i < count; i++) {
            buffer[i] = c;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//for
        System.out.printf(
            "    making RealData(%d,%c)\n", count, c);
        this.content = new String(buffer);
    }//constructor

    @Override
    public String getContent() {
        return content;
    }
}//class
