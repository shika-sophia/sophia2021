/**
 * @BNF <commandList> ::= <command>* end
 */
package javaGoF.chap23Interpreter.practiceNode.interpreter;

import java.util.ArrayList;
import java.util.List;

public class CommandListInterpreter extends AbsInterpreter {
    List<AbsInterpreter> cmdList = new ArrayList<>();

    @Override
    public void parse(InterpreterContext context) throws NodeParseException {
        while(true) {
            if(context.currentToken() == null) {
                throw new NodeParseException("Missing 'end'");
            } else if(context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                AbsInterpreter cmdNode = new CommandInterpreter();
                cmdNode.parse(context);
                cmdList.add(cmdNode);
            }
        }//while
    }//parse()

    public String toString() {
        return cmdList.toString();
    }//toString()
}//class
