package javaGoF.chap21Proxy.printer;

public class PrinterProxy implements IPrintable {
    private String name;
    private String className;
    private IPrintable real;

    public PrinterProxy() { }

    public PrinterProxy(String name, String className) {
        this.name = name;
        this.className = className;
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

    //====== Class.newInstance() version ======
    @Deprecated(since="9")
    private synchronized void realize() {
        String packageStr = "javaGoF.chap21Proxy.printer.";

        if(real == null) {
            try {
                real = (IPrintable) Class.forName(packageStr + className).newInstance();
                setPrintName(name);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }//realize()

//    //====== new Printer version ======
//    private synchronized void realize() {
//        if(real == null) {
//        	real = new Printer(name)
//        }
//    }//realize()
}//class
