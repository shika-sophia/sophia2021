package javaGoF.chap23Interpreter.practiceNode.interpreter;

import java.util.StringTokenizer;

public class InterpreterContext {
    private StringTokenizer tokenizer;
    private String currentToken;

    public InterpreterContext(String str) {
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
}//class
