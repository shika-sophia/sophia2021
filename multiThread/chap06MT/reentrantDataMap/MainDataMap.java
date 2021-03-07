package multiThread.chap06MT.reentrantDataMap;

public class MainDataMap {

    public static void main(String[] args) {
//        AbsDataMap<String, String> dataMap
//            = new SyncDataMap<>();
        AbsDataMap<String, String> dataMap
            = new ReentrantDataMap<>();

        //AssignThreadの起動
        new AssignThread(dataMap, "Alice", "Alaska").start();
        new AssignThread(dataMap, "Alice", "Australia").start();
        new AssignThread(dataMap, "Bobby", "Brazil").start();
        new AssignThread(dataMap, "Bobby", "Bulgaria").start();

        //RetieveThreadnの起動
        for (int i = 0; i < 100; i++) {
            new RetrieveThread(dataMap, "Alice").start();
            new RetrieveThread(dataMap, "Bobby").start();
        }//for

        //10秒間待機
        dataMap.slowly(10000);

        System.out.println(
            "read count: " + RetrieveThread.getAtomcount());

        //強制終了
        System.exit(0);
    }//main()

}//class

/*
//====== SyncDataMap ======
94: <Bobby, Bulgaria>
93: <Alice, Australia>
92: <Bobby, Bulgaria>
91: <Alice, Australia>
90: <Bobby, Bulgaria>
89: <Alice, Australia>
88: <Bobby, Bulgaria>
87: <Alice, Australia>
86: <Bobby, Bulgaria>
85: <Alice, Australia>
84: <Bobby, Bulgaria>
83: <Alice, Australia>
82: <Bobby, Bulgaria>
81: <Alice, Australia>
80: <Bobby, Bulgaria>
79: <Alice, Australia>
78: <Bobby, Bulgaria>
77: <Alice, Australia>
76: <Bobby, Bulgaria>
75: <Alice, Australia>
74: <Bobby, Bulgaria>
read count: 328

//====== Reentrant DataMap ======
4533: <Bobby, Bulgaria>
4546: <Alice, Australia>
4532: <Bobby, Bulgaria>
4538: <Alice, Australia>
4539: <Bobby, Bulgaria>
4537: <Alice, Australia>
4543: <Alice, Australia>
4542: <Bobby, Bulgaria>
4544: <Bobby, Bulgaria>
4545: <Bobby, Bulgaria>
read count: 4746

*/