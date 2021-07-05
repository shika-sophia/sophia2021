/**
 * @BNF <command> ::= <repeatCommand> | <primitiveCommand>
 */
package javaGoF.chap23Interpreter.answerNode.language;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public class CommandExe extends AbsNodeExe {
    private AbsNodeExe node;

    @Override
    public void parse(NodeExeContext context) throws NodeParseException {
        if(context.currentToken().equals("repeat")) {
            node = new RepeatCommandExe();
            node.parse(context);
        } else {
            node = new PrimitiveCommandExe();
            node.parse(context);
        }
    }//parse()

    public String toString() {
        return node.toString();
    }//toString()

    @Override
    public void execute() throws NodeExeException {
        node.execute();
    }
}//class
