/**
 * @BNF <primitiveCommand> ::= go | right | left
 */
package javaGoF.chap23Interpreter.parseNode;

public class PrimitiveCommandNode extends AbsNode {
    private String current;

    @Override
    public void parse(NodeContext context) throws NodeParseException {
        current = context.currentToken();
        context.skipToken(current);

        if(!current.equals("go") &&
                !current.equals("right") &&
                !current.equals("left")) {
            throw new NodeParseException(current + " is undefined");
        }
    }//parse()

    public String toString() {
        return current;
    }//toString()
}//class
