/**
 * @BNF <commandList> ::= <command>* end
 */
package javaGoF.chap23Interpreter.parseNode;

import java.util.ArrayList;
import java.util.List;

public class CommandListNode extends AbsNode {
    List<AbsNode> cmdList = new ArrayList<>();

    @Override
    public void parse(NodeContext context) throws NodeParseException {
        while(true) {
            if(context.currentToken() == null) {
                throw new NodeParseException("Missing 'end'");
            } else if(context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                AbsNode cmdNode = new CommandNode();
                cmdNode.parse(context);
                cmdList.add(cmdNode);
            }
        }//while
    }//parse()

    public String toString() {
        return cmdList.toString();
    }//toString()
}//class
