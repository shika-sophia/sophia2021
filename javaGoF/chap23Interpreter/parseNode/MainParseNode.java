/**
 * @title javaGoF / chap23Interpreter / parseNode / MainParseNode.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第23章 Interpreter / List 23-1 ～ 23-10
 *          ミニ言語の解析
 * @author shika
 * @date 2021-07-01
 */
package javaGoF.chap23Interpreter.parseNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainParseNode {

    public static void main(String[] args) {
        String dir = "src/javaGoF/chap23Interpreter/parseNode/";
        String fileName = "program.txt";

        try(var reader =
                new BufferedReader(
                    new FileReader(dir + fileName))){
            String text;
            while((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                AbsNode node = new ProgramNode();
                node.parse(new NodeContext(text));
                System.out.println("node = " + node);
            }//while

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NodeParseException e) {
            e.printStackTrace();
        }
    }//main()

}//class

/*
text = "program end"
node = [program []]
text = "program go end"
node = [program [go]]
text = "program go right go right go right go right end"
node = [program [go, right, go, right, go, right, go, right]]
text = "program repeat 4 go right end right end"
node = [program [[repeat 4 [go, right]], right]]
text = "program repeat 4 repeat 3 go right go left end right end end"
node = [program [[repeat 4 [[repeat 3 [go, right, go, left]], right]]]]

*/