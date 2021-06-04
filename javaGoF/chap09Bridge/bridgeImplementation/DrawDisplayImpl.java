package javaGoF.chap09Bridge.bridgeImplementation;

import java.util.Scanner;

public class DrawDisplayImpl extends AbsDisplayImpl {
    private String drawMark;
    private String initial;
    private String finish;

    public DrawDisplayImpl() {
        askDrawMark();
    }

    private void askDrawMark() {
        Scanner scn = new Scanner(System.in);

        while(true) {
            System.out.print("マークを入力してください。 * / # -> ");
            String input = scn.next();

            if(input.equals("*")) {
                drawMark = input;
                initial = "<";
                finish = ">";
                break;
            } else if (input.equals("#")){
                drawMark = input;
                initial = "|";
                finish = "-";
                break;
            } else {
                System.out.println("<!> 「*」か「#」で入力してください。");
                continue;
            }//if
        }//while loop

        scn.close();
    }//askDrawMark()

    @Override
    public void rawOpen() {
        System.out.print(initial);
    }//rawOpen()

    @Override
    public void rawPrint() {
        System.out.print(drawMark);
    }//rawPrint

    @Override
    public void rawClose() {
        System.out.println(finish);
    }//rawClose()

}//class
