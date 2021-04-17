
package javaGoF.chap05JG.ticketSingleton;

public final class TicketMaker {
    private static final TicketMaker maker = new TicketMaker();
    private static volatile int id = 100;

    private TicketMaker() { }

    public synchronized int getTicket() {
        if(id <= 0) {
            System.out.println("\nチケットは完売しました。");
            return -1;
        }

        return id--;
    }//getTicket()

    public static final TicketMaker getInstance() {
        return maker;
    }//getInstance()

    public static int getId() {
        return id;
    }
}//class
