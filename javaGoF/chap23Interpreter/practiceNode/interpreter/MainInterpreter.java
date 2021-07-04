/**
 * @title javaGoF / chap23Interpreter / parseNode / MainInterpreter.java
 * @reference 結城 浩 『Java言語で学ぶデザインパターン入門 [増補改訂版]』 SB Creative, 2004
 * @content 第23章 Interpreter / List 23-1 ～ 23-10
 *          ミニ言語の解析
 * @BNF Backus-Nour Form / Backus Normal Form: 言語文法の表記法
 * @BNF <program> ::= program <commandList>
 * @BNF <commandList> ::= <command>* end
 * @BNF <command> ::= <repeatCommand> | <primitiveCommand>
 * @BNF <repeatCommand> ::= repeat <number> <commandList>
 * @BNF <primitiveCommand> ::= go | right | left
 * @file program.txt
 *
 * @class MainInterpreter /
 *        ◆main() {
 *            new ProgramInterpreter(),
 *            new InterpreterContext() }
 * @class AbsInterpreter / abstract void parse(InterpreterContext)
 * @class ProgramInterpreter extends AbsInterpreter
 *        / ◇AbsInterpreter cmdListNode /
 *        parse(InterpreterContext) { new CommandListInterpreter() }, toString()
 * @class CommandListInterpreter extends AbsInterpreter
 *        / ◇List<AbsInterpreter> cmdList /
 *        parse(InterpreterContext) { new CommandInterpreter() } , toString()
 * @class CommandInterpreter extends AbsInterpreter
 *        / ◇AbsInterpreter node /
 *        parse(InterpreterContext) {
 *            new RepeatCommandInterpreter(),
 *            new PrimitiveCommandInterpreter() },
 *        toString()
 * @class RepeatCommandInterpreter extends AbsInterpreter
 *        / ◇AbsInterpreter cmdListNode, int number /
 *        parse(InterpreterContext) { new CommandListInterpreter() }
 *        toString()
 * @class PrimitiveCommandInterpreter extends AbsInterpreter
 *        / String current /
 *        parse(InterpreterContext), toString()
 *
 * @class InterpreterContext
 *        / StringTokenizer tokenizer,
 *          String currentToken /
 *        nextToken(), skipToken(String), currentNumber()
 * @class NodeParseException extends Exception
 *
 * @author shika
 * @date 2021-07-01
 */
package javaGoF.chap23Interpreter.practiceNode.interpreter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainInterpreter {

    public static void main(String[] args) {
        String dir = "src/javaGoF/chap23Interpreter/practiceNode/";
        String fileName = "program.txt";

        try(var reader =
                new BufferedReader(
                    new FileReader(dir + fileName))){
            String text;
            while((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                AbsInterpreter node = new ProgramInterpreter();
                node.parse(new InterpreterContext(text));
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

//====== program.txt ======
program end
program go end
program go right go right go right go right end
program repeat 4 go right end right end
program repeat 4 repeat 3 go right go left end right end end

*/