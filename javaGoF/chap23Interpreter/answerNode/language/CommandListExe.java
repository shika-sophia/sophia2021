/**
 * @BNF <commandList> ::= <command>* end
 */
package javaGoF.chap23Interpreter.answerNode.language;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public class CommandListExe extends AbsNodeExe {
    List<AbsNodeExe> cmdList = new ArrayList<>();

    @Override
    public void parse(NodeExeContext context) throws NodeParseException {
        while(true) {
            if(context.currentToken() == null) {
                throw new NodeParseException("Missing 'end'");
            } else if(context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                AbsNodeExe cmdExe = new CommandExe();
                cmdExe.parse(context);
                cmdList.add(cmdExe);
            }
        }//while
    }//parse()

    public String toString() {
        return cmdList.toString();
    }//toString()

    @Override
    public void execute() throws NodeExeException {
        Iterator<AbsNodeExe> cmdItr = cmdList.iterator();
        while(cmdItr.hasNext()) {
            ((CommandExe)cmdItr.next()).execute();
        }//while
    }
}//class
