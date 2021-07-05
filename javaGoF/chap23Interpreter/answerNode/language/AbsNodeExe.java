package javaGoF.chap23Interpreter.answerNode.language;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public abstract class AbsNodeExe implements INodeExecutor {
    public abstract void parse(NodeExeContext context)
            throws NodeParseException;
}//class
