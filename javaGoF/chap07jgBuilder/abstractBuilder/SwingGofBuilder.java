package javaGoF.chap07jgBuilder.abstractBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SwingGofBuilder extends GofBuilder {
    private final JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private List<JTextArea> txAreaList = new ArrayList<>();
    private volatile int index = 0;

    public SwingGofBuilder() { }

    @Override
    public void makeTitle(String title) {
        frame.setTitle(title);
    }//makeTitle()

    @Override
    public void makeString(String str) {
        JTextArea txArea = new JTextArea();
        txArea.append("◆" + str + "\n");
        txAreaList.add(index, txArea);
    }//makeString()

    @Override
    public void makeItem(String[] item) {
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
    }//makeItem()

    @Override
    public void close() {
        frame.getContentPane().add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        txAreaList.stream()
                  .forEach(panel::add);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        //frame.pack();
        frame.setVisible(true);
    }//close()

    public String getResult() {
        return "swing: " + frame.getTitle();
    }//getResult()

}//class
