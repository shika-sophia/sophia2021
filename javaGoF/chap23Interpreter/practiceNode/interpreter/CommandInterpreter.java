/**
 * @BNF <command> ::= <repeatCommand> | <primitiveCommand>
 */
package javaGoF.chap23Interpreter.practiceNode.interpreter;

public class CommandInterpreter extends AbsInterpreter {
    private AbsInterpreter node;

    @Override
    public void parse(InterpreterContext context) throws NodeParseException {
        if(context.currentToken().equals("repeat")) {
            node = new RepeatCommandInterpreter();
            node.parse(context);
        } else {
            node = new PrimitiveCommandInterpreter();
            node.parse(context);
        }
    }//parse()

    public String toString() {
        return node.toString();
    }//toString()
}//class
