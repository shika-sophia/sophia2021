/**
 * @BNF <repeatCommand> ::= repeat <number> <cmdList>
 */
package javaGoF.chap23Interpreter.answerNode.language;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public class RepeatCommandExe extends AbsNodeExe {
    private int number;
    private AbsNodeExe cmdListExe;

    @Override
    public void parse(NodeExeContext context) throws NodeParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        cmdListExe = new CommandListExe();
        cmdListExe.parse(context);
    }//parse()

    public String toString() {
        return String.format(
                "[repeat %d %s]", number, cmdListExe.toString());
    }//toString()

    @Override
    public void execute() throws NodeExeException {
        for(int i = 0; i < number; i++) {
            cmdListExe.execute();
        }
    }
}//class
