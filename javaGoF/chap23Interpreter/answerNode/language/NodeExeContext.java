package javaGoF.chap23Interpreter.answerNode.language;

import java.util.StringTokenizer;

import javaGoF.chap23Interpreter.parseNode.NodeParseException;

public class NodeExeContext implements INodeExeFactory {
    private INodeExeFactory factory;
    private StringTokenizer tokenizer;
    private String currentToken;

    public NodeExeContext(String str) {
        tokenizer = new StringTokenizer(str);
        nextToken();
    }

    public String nextToken() {
        if(tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }

        return currentToken;
    }//nextToken()

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(String token) throws NodeParseException {
        if(!token.equals(currentToken)) {
            throw new NodeParseException(
                String.format("Warnig: %s is expected, but %s is found.",
                        token, currentToken));
        }

        nextToken();
    }//skipToken()

    public int currentNumber() throws NodeParseException {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);

        } catch (NumberFormatException e) {
            throw new NodeParseException("Warning: " + e);
        }

        return number;
    }//currentNumber()

    public void setExecutorFactory(INodeExeFactory factory) {
        this.factory = factory;
    }

    @Override
    public INodeExecutor createExecutor(String exeName) {
        return factory.createExecutor(exeName);
    }
}//class
