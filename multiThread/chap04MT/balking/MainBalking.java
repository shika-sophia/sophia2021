package multiThread.chap04MT.balking;

public class MainBalking {

    public static void main(String[] args) {
        var data = new BalkingData("data.txt", "(empty)");
        new BalkingChangerThread("ChangerThread", data).start();
        new BalkingSaveThread("SaveThread", data).start();
    }//main()

}//class

/*
SaveThread calls doSave(), content = No.0
SaveThread calls doSave(), content = No.1
SaveThread calls doSave(), content = No.2
ChangerThread calls doSave(), content = No.3
SaveThread calls doSave(), content = No.4
ChangerThread calls doSave(), content = No.5
ChangerThread calls doSave(), content = No.6
SaveThread calls doSave(), content = No.7
SaveThread calls doSave(), content = No.8
ChangerThread calls doSave(), content = No.9
SaveThread calls doSave(), content = No.10
ChangerThread calls doSave(), content = No.11
SaveThread calls doSave(), content = No.12
ChangerThread calls doSave(), content = No.13
SaveThread calls doSave(), content = No.14
SaveThread calls doSave(), content = No.15
ChangerThread calls doSave(), content = No.16
SaveThread calls doSave(), content = No.17
ChangerThread calls doSave(), content = No.18
ChangerThread calls doSave(), content = No.19
*/