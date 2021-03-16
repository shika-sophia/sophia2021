package multiThread.chap09MT.webReader.content;

public class Retriever {
    public static AbsContent retrieve(String urlStr) {
        return new SyncContentImpl(urlStr);
    }//retrieve()
}//class
