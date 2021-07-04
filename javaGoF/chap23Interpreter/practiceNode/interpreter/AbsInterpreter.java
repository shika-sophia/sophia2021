package javaGoF.chap23Interpreter.practiceNode.interpreter;

public abstract class AbsInterpreter {
    public abstract void parse(InterpreterContext context)
            throws NodeParseException;
}//class
