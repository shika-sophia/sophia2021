package javaGoF.chap05JG.fakeSingleton;

public class FakeSingleton {
    private static FakeSingleton fake = null;
    private static int id;

    private FakeSingleton() {
        System.out.printf("FakeSingleton(%d) インスタンス生成\n", id);
        id++;
    }

    public static FakeSingleton getInstance() {
        if(fake == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            fake = new FakeSingleton();
        }//if

        return fake;
    }//getInstance

    public static int getId() {
        return id;
    }
}//class

