/**
 * @BNF <repeatCommand> ::= repeat <number> <cmdList>
 */
package javaGoF.chap23Interpreter.parseNode;

public class RepeatCommandNode extends AbsNode {
    private int number;
    private AbsNode cmdListNode;

    @Override
    public void parse(NodeContext context) throws NodeParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        cmdListNode = new CommandListNode();
        cmdListNode.parse(context);
    }//parse()

    public String toString() {
        return String.format(
                "[repeat %d %s]", number, cmdListNode.toString());
    }//toString()
}//class
