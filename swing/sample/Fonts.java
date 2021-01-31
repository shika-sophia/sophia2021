/**
 * @title javaPractice / swing / sample / Fonts.java
 * @refernce 日向俊二『JavaGUIプログラミング
 *                     ～Swingを使った今どきのアプリ開発』カットシステム, 2020
 * @content List5.1 / Fonts.java
 * @see swing/sample/resultImage/Fonts.jpg
 * @author shika
 * @date 2021-01-28
 */
package swing.sample;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fonts extends JFrame {
    Fonts() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel();
        Font font1 = new Font(Font.SERIF, Font.PLAIN, 12);
        label1.setFont(font1);
        label1.setText("Font.SERIF, Font.PLAIN, 12");
        panel.add(label1);

        JLabel label2 = new JLabel();
        Font font2 = new Font(Font.SERIF, Font.ITALIC, 14);
        label2.setFont(font2);
        label2.setText("Font.SERIF,  Font.ITALIC, 14");
        panel.add(label2);

        JLabel label3 = new JLabel();
        Font font3 = new Font(Font.SERIF, Font.BOLD, 16);
        label3.setFont(font3);
        label3.setText("Font.SERIF, Font.BOLD, 16");
        panel.add(label3);

        JLabel label4 = new JLabel();
        Font font4 = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        label4.setFont(font4);
        label4.setText("Font.SANS_SERIF, Font.PLAIN, 12");
        panel.add(label4);

        JLabel label5 = new JLabel();
        Font font5 = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        label5.setFont(font5);
        label5.setText("Font.MONOSPACED, Font.PLAIN, 12");
        panel.add(label5);

        //JFrame
        this.getContentPane().add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Fonts");
        this.pack();
        this.setSize(280, 160);
        this.setVisible(true);
    }//constructor

    public static void main(String[] args) {
        new Fonts();

//        String[] fontAry = GraphicsEnvironment
//            .getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//
//        for(String font : fontAry) {
//            System.out.println(font);
//        }
    }//main()

}//class

/*
for(String font : fontAry) {
    System.out.println(font);
}

Arial
Arial Black
Arial Narrow
Bahnschrift
BIZ UDPゴシック
BIZ UDP明朝 Medium
BIZ UDゴシック
BIZ UD明朝 Medium
Book Antiqua
Bookman Old Style
Bookshelf Symbol 7
Calibri
Calibri Light
Cambria
Cambria Math
Candara
Candara Light
Century
Century Gothic
Comic Sans MS
Consolas
Constantia
Corbel
Corbel Light
Courier New
Dialog
DialogInput
Dubai
Dubai Light
Dubai Medium
Ebrima
Franklin Gothic Medium
Gabriola
Gadugi
Garamond
Georgia
HGP創英角ｺﾞｼｯｸUB
HGP創英角ﾎﾟｯﾌﾟ体
HGP創英ﾌﾟﾚｾﾞﾝｽEB
HGP教科書体
HGP明朝B
HGP明朝E
HGP行書体
HGPｺﾞｼｯｸE
HGPｺﾞｼｯｸM
HGS創英角ｺﾞｼｯｸUB
HGS創英角ﾎﾟｯﾌﾟ体
HGS創英ﾌﾟﾚｾﾞﾝｽEB
HGS教科書体
HGS明朝B
HGS明朝E
HGS行書体
HGSｺﾞｼｯｸE
HGSｺﾞｼｯｸM
HG丸ｺﾞｼｯｸM-PRO
HG創英角ｺﾞｼｯｸUB
HG創英角ﾎﾟｯﾌﾟ体
HG創英ﾌﾟﾚｾﾞﾝｽEB
HG教科書体
HG明朝B
HG明朝E
HG正楷書体-PRO
HG行書体
HGｺﾞｼｯｸE
HGｺﾞｼｯｸM
HoloLens MDL2 Assets
Impact
Ink Free
Javanese Text
Leelawadee UI
Leelawadee UI Semilight
Lucida Console
Lucida Sans Unicode
Malgun Gothic
Malgun Gothic Semilight
Marlett
Meiryo UI
Microsoft Himalaya
Microsoft JhengHei
Microsoft JhengHei Light
Microsoft JhengHei UI
Microsoft JhengHei UI Light
Microsoft New Tai Lue
Microsoft PhagsPa
Microsoft Sans Serif
Microsoft Tai Le
Microsoft YaHei
Microsoft YaHei Light
Microsoft YaHei UI
Microsoft YaHei UI Light
Microsoft Yi Baiti
MingLiU-ExtB
MingLiU_HKSCS-ExtB
Mongolian Baiti
Monospaced
Monotype Corsiva
MS Outlook
MS Reference Sans Serif
MS Reference Specialty
MS UI Gothic
MT Extra
MV Boli
Myanmar Text
Nirmala UI
Nirmala UI Semilight
NSimSun
OCRB
Palatino Linotype
PMingLiU-ExtB
SansSerif
Segoe MDL2 Assets
Segoe Print
Segoe Script
Segoe UI
Segoe UI Black
Segoe UI Emoji
Segoe UI Historic
Segoe UI Light
Segoe UI Semibold
Segoe UI Semilight
Segoe UI Symbol
Serif
SimSun
SimSun-ExtB
Sitka Banner
Sitka Display
Sitka Heading
Sitka Small
Sitka Subheading
Sitka Text
Sylfaen
Symbol
Tahoma
Times New Roman
Trebuchet MS
UD デジタル 教科書体 N-B
UD デジタル 教科書体 N-R
UD デジタル 教科書体 NK-B
UD デジタル 教科書体 NK-R
UD デジタル 教科書体 NP-B
UD デジタル 教科書体 NP-R
Verdana
Webdings
Wingdings
Wingdings 2
Wingdings 3
Yu Gothic UI
Yu Gothic UI Light
Yu Gothic UI Semibold
Yu Gothic UI Semilight
メイリオ
游ゴシック
游ゴシック Light
游ゴシック Medium
游明朝
游明朝 Demibold
游明朝 Light
ＭＳ ゴシック
ＭＳ 明朝
ＭＳ Ｐゴシック
ＭＳ Ｐ明朝

*/