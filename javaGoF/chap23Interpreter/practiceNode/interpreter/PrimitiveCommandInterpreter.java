/**
 * @BNF <primitiveCommand> ::= go | right | left
 */
package javaGoF.chap23Interpreter.practiceNode.interpreter;

public class PrimitiveCommandInterpreter extends AbsInterpreter {
    private String current;

    @Override
    public void parse(InterpreterContext context) throws NodeParseException {
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
