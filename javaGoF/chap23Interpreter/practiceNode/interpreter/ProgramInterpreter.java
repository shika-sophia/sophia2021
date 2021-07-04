/**
 * @BNF <program> ::= program <commandList>
 */
package javaGoF.chap23Interpreter.practiceNode.interpreter;

public class ProgramInterpreter extends AbsInterpreter {
    private AbsInterpreter cmdListNode;

    @Override
    public void parse(InterpreterContext context) throws NodeParseException {
        context.skipToken("program");
        cmdListNode = new CommandListInterpreter();
        cmdListNode.parse(context);
    }//parse()

    public String toString() {
        return "[program " + cmdListNode + "]";
    }//toString()
}//class
