package javaGoF.chap21Proxy.printer;

public class Printer implements IPrintable {
    private String name;

    public Printer() {
        heavyJob("Printerインスタンスを生成中");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob(String.format(
            "Printerインスタンス(%s)生成中", name));
    }

    @Override
    public void setPrintName(String name) {
        this.name = name;
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String str) {
        System.out.printf("==== %s ==== \n", name);
        System.out.println(str);
    }//print()

    private void heavyJob(String msg) {
        final int TIMES = 5;
        System.out.print(msg);

        for(int i = 0; i < TIMES; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }//for

        System.out.println("完了");
    }//heavyJob()
}//class
