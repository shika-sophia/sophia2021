package javaGoF.chap23Interpreter.parseNode;

public abstract class AbsNode {
    public abstract void parse(NodeContext context)
            throws NodeParseException;
}//class
