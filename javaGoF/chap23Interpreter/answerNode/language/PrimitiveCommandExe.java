/**
 * @BNF <primitiveCommand> ::= go | right | left
 */
package javaGoF.chap23Interpreter.answerNode.language;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public class PrimitiveCommandExe extends AbsNodeExe {
    private INodeExecutor executor;
    private String current;

    @Override
    public void parse(NodeExeContext context) throws NodeParseException {
        current = context.currentToken();
        context.skipToken(current);
        executor = context.createExecutor(current);

        if(!current.equals("go") &&
                !current.equals("right") &&
                !current.equals("left")) {
            throw new NodeParseException(current + " is undefined");
        }
    }//parse()

    public String toString() {
        return current;
    }//toString()

    @Override
    public void execute() throws NodeExeException {
        if(executor == null) {
            throw new NodeExeException(current + ": not defined");
        } else {
            executor.execute();
        }
    }
}//class
