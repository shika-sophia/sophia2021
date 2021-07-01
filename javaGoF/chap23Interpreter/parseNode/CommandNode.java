/**
 * @BNF <command> ::= <repeatCommand> | <primitiveCommand>
 */
package javaGoF.chap23Interpreter.parseNode;

public class CommandNode extends AbsNode {
    private AbsNode node;

    @Override
    public void parse(NodeContext context) throws NodeParseException {
        if(context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
            node.parse(context);
        } else {
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }//parse()

    public String toString() {
        return node.toString();
    }//toString()
}//class
