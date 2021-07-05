package javaGoF.chap23Interpreter.answerNode.language;

public interface INodeExeFactory {
    public abstract INodeExecutor createExecutor(String exeName);
}//interface
