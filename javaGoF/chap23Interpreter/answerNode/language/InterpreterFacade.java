package javaGoF.chap23Interpreter.answerNode.language;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public class InterpreterFacade implements INodeExecutor {
    private INodeExeFactory factory;
    private NodeExeContext context;
    private AbsNodeExe programExe;

    public InterpreterFacade(INodeExeFactory factory) {
        this.factory = factory;
    }

    public boolean parse(String text) {
        boolean ok = true;
        context = new NodeExeContext(text);
        context.setExecutorFactory(factory);
        programExe = new ProgramExe();

        try {
            programExe.parse(context);
            System.out.println(programExe.toString());
        } catch (NodeParseException e) {
            e.printStackTrace();
            ok = false;
        }

        return ok;
    }//paese()

    @Override
    public void execute() throws NodeExeException {
        try {
            programExe.execute();

        } catch (NodeExeException e) {
            e.printStackTrace();
        }
    }//execute()

}//class
