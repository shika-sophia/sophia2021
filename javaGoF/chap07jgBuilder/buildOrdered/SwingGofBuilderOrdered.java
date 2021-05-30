package javaGoF.chap07jgBuilder.buildOrdered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SwingGofBuilderOrdered extends GofBuilderOrdered {
    private final JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private List<JTextArea> txAreaList = new ArrayList<>();
    private volatile int index = 0;

    public SwingGofBuilderOrdered() { }

    @Override
    public void buildTitle(String title) {
        frame.setTitle(title);
    }//buildTitle()

    @Override
    public void buildString(String str) {
        JTextArea txArea = new JTextArea();
        txArea.append("◆" + str + "\n");
        txAreaList.add(index, txArea);
    }//buildString()

    @Override
    public void buildItem(String[] item) {
        if(txAreaList == null || txAreaList.isEmpty()) {
            System.out.println("<!> Listに格納されていません。");
            return;
        }

        JTextArea txArea = txAreaList.get(index);
        Arrays.stream(item)
              .map(s -> s + "\n")
              .forEach(txArea::append);
        txArea.append("\n");

        index++;
    }//buildItem()

    @Override
    public void buildDone() {
        frame.getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        txAreaList.stream()
                  .forEach(panel::add);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        //frame.pack();
        frame.setVisible(true);
    }//buildDone()

    public String getResult() {
        return "swing: " + frame.getTitle();
    }//getResult()

}//class
