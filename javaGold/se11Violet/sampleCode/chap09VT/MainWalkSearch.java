/**
 * @title javaGold / se11Violet / sampleCode / chap09VT / MainWalkSearch.java
 * @reference 山本道子 『Java Gold SE11 オラクル認定教科書 [1Z0-816]』 翔泳社, 2021
 * @content 第９章 ioFile, nioFiles / p441 / List 9-28, 9-29
 * @content Files.walk() -> Stream<Path>
 *          walk().filter()
 * @see MainFindSearch.java
 * @author shika
 * @date 2021-04-09
 */
package javaGold.se11Violet.sampleCode.chap09VT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainWalkSearch {

    public static void main(String[] args) {
        Path path2 = Paths.get("src/utility");
        try {
            Files.walk(path2)
            .map(file -> file.toString().replace('\\', '/'))
            .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        Path path3 = Paths.get("src/swing");
        try {
            Files.walk(path3)
            .filter(file -> file.toString().endsWith(".jpg"))
            .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
//---- Files.walk() ----
src/utility
src/utility/cmdDiv
src/utility/cmdDiv/AbsCmdExe.java
src/utility/cmdDiv/cmdAnalysis.txt
src/utility/cmdDiv/CmdExecute.java
src/utility/cmdDiv/CmdJavaExe.java
src/utility/interfaceUT
src/utility/interfaceUT/CorrectData.java
src/utility/interfaceUT/ICalcCorrect.java
src/utility/interfaceUT/ICalcTime.java
src/utility/interfaceUT/IEditable.java
src/utility/interfaceUT/IReference.java
src/utility/interfaceUT/TimeData.java
src/utility/ioFileDiv
src/utility/ioFileDiv/AbsFileSystem.java
src/utility/ioFileDiv/BuildFilePage.java
src/utility/ioFileDiv/BuildJavaDoc.java
src/utility/ioFileDiv/ioFileAnalysis.txt
src/utility/ioFileDiv/ReadFile.java
src/utility/ioFileDiv/WriteFile.java
src/utility/scanDiv
src/utility/scanDiv/AbsScan.java
src/utility/scanDiv/scanAnalysis
src/utility/scanDiv/ScanConfirm.java
src/utility/scanDiv/ScanInt.java
src/utility/scanDiv/ScanStr.java
src/utility/scanDiv/scanTest
src/utility/scanDiv/scanTest/AskDate.java
src/utility/scanDiv/scanTest/TestReverse.java
src/utility/tableDiv
src/utility/tableDiv/AbsTableData.java
src/utility/tableDiv/TableHTML.java
src/utility/tableDiv/TableSW.java
src/utility/tableDiv/TableSW.jpg

【考察】
デフォルトで「\」の区切り文字、(Font "consolas"の場合, Windowsは「¥」)
「\ｕ」を Unicodeと解釈し /utilityでエラー表示(コメントアウトの中)
なので、 map()を追加して加工してみました。

Files.walk()の戻り値は Stream<Path>を生成するので、
map(file -> ) fileの型は Path
toString()してから、replace()で加工

//---- Files.walk().filter() ----
src\swing\reference\SwingJFramePane.jpg
src\swing\sample\resultImage\BarGraph.jpg
src\swing\sample\resultImage\CardLayout.jpg
src\swing\sample\resultImage\ChangeBounds.jpg
src\swing\sample\resultImage\ChangeMenu.jpg
src\swing\sample\resultImage\ColorDld.jpg
src\swing\sample\resultImage\ComboBox.jpg
src\swing\sample\resultImage\CreateColor.jpg
src\swing\sample\resultImage\DrawFont.jpg
src\swing\sample\resultImage\DrawShape.jpg
src\swing\sample\resultImage\FlowLayout.jpg
src\swing\sample\resultImage\Fonts.jpg
src\swing\sample\resultImage\GetKeys.jpg
src\swing\sample\resultImage\GridBagLayout.jpg
src\swing\sample\resultImage\GridLayout.jpg
src\swing\sample\resultImage\GroupLayout.jpg
src\swing\sample\resultImage\ImageLabel.jpg
src\swing\sample\resultImage\ImeCtrl.jpg
src\swing\sample\resultImage\LineGraph.jpg
src\swing\sample\resultImage\ListBox.jpg
src\swing\sample\resultImage\ListIcon.jpg
src\swing\sample\resultImage\MainMenu.jpg
src\swing\sample\resultImage\MenuIcon.jpg
src\swing\sample\resultImage\MouseBtn.jpg
src\swing\sample\resultImage\MouseClick.jpg
src\swing\sample\resultImage\MultiPanels.jpg
src\swing\sample\resultImage\NumUpDown.jpg
src\swing\sample\resultImage\OverlayLayout.jpg
src\swing\sample\resultImage\Piechart.jpg
src\swing\sample\resultImage\ProgressBar.jpg
src\swing\sample\resultImage\SampleLabel.jpg
src\swing\sample\resultImage\Scroller.jpg
src\swing\sample\resultImage\ScrollImage.jpg
src\swing\sample\resultImage\ScrollLabel.jpg
src\swing\sample\resultImage\Slider.jpg
src\swing\sample\resultImage\Spliter.jpg
src\swing\sample\resultImage\SpringLayout.jpg
src\swing\sample\resultImage\StatusBar.jpg
src\swing\sample\resultImage\Table.jpg
src\swing\sample\resultImage\TabPane.jpg
src\swing\sample\resultImage\Toolbar.jpg
src\swing\sample\resultImage\TraceMouse.jpg
src\swing\sample\resultImage\Tree.jpg
src\swing\sample\resultImage\TxtArea.jpg
src\swing\sample\resultImage\TxtPane.jpg
src\swing\sample\resultImage\WebBrowse.jpg
src\swing\sample\resultImage\WebSource.jpg
src\swing\sample\resultImage\YesNoDialog.jpg

【考察】
Path.endsWith()もサポートされているが、
そのまま forEach()に渡しても何も出力されなかった。

上記のように
file.toString().endsWith()で 出力できました。

Files.walk()は Stream<Path>を生成するので
Streamの filter()を使える。
これで検索にも利用できる。
*/