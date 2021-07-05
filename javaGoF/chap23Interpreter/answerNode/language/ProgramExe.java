/**
 * @BNF <program> ::= program <commandList>
 */
package javaGoF.chap23Interpreter.answerNode.language;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public class ProgramExe extends AbsNodeExe {
    private AbsNodeExe cmdListExe;

    @Override
    public void parse(NodeExeContext context) throws NodeParseException {
        context.skipToken("program");
        cmdListExe = new CommandListExe();
        cmdListExe.parse(context);
    }//parse()

    public String toString() {
        return "[program " + cmdListExe + "]";
    }//toString()

    @Override
    public void execute() throws NodeExeException {
        cmdListExe.execute();
    }
}//class
