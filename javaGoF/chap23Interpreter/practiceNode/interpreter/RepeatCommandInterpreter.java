/**
 * @BNF <repeatCommand> ::= repeat <number> <cmdList>
 */
package javaGoF.chap23Interpreter.practiceNode.interpreter;

public class RepeatCommandInterpreter extends AbsInterpreter {
    private int number;
    private AbsInterpreter cmdListNode;

    @Override
    public void parse(InterpreterContext context) throws NodeParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        cmdListNode = new CommandListInterpreter();
        cmdListNode.parse(context);
    }//parse()

    public String toString() {
        return String.format(
                "[repeat %d %s]", number, cmdListNode.toString());
    }//toString()
}//class
