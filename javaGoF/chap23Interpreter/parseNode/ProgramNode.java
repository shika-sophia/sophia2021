/**
 * @BNF <program> ::= program <commandList>
 */
package javaGoF.chap23Interpreter.parseNode;

public class ProgramNode extends AbsNode {
    private AbsNode cmdListNode;

    @Override
    public void parse(NodeContext context) throws NodeParseException {
        context.skipToken("program");
        cmdListNode = new CommandListNode();
        cmdListNode.parse(context);
    }//parse()

    public String toString() {
        return "[program " + cmdListNode + "]";
    }//toString()
}//class
