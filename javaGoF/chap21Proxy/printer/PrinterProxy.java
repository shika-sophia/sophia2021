package javaGoF.chap21Proxy.printer;

public class PrinterProxy implements IPrintable {
    private String name;
    private Printer real;

    public PrinterProxy() { }

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public synchronized void setPrintName(String name) {
        if(real != null) {
            real.setPrintName(name); //Printer.setPrintName(String)
        }
        this.name = name;
    }//setPrintName()

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String str) {
        realize();
        real.print(str);
    }//print()

    private synchronized void realize() {
        if(real == null) {
            real = new Printer(name);
        }
    }//realize()

}//class
