package multiThread.chap10MT.gracefulThread;

public class SubCountupThread extends GracefulThread {
    private long counter = 0; //カウンター変数

    //作業
    @Override
    protected void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }//doWork()

    @Override
    protected void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);

//        String path =
//            "src/multiThread/chap10MT/twoPhaseTermination/counter.txt";
//
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter(path, true);
//            writer.write(String.valueOf(counter) + " ");
//            System.out.printf("%s: fileWrite to %s \n",
//                Thread.currentThread().getName(), path);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                writer.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }//doShutdown()
}//class
