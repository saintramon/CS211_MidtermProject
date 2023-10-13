package backend;

/**
 * @author ROXAS, LACANILAO, SICCUAN
 * @version 1.00 (13 October 2023)
 * Template for Expression object.
 */
public class Expression {

    /**
     * String representation of the infix expression given by the user.
     */
    private String infixExpression;

    /**
     * Array of characters that holds the symbols
     */
    private char[] symbols;

    /**
     * String representation of the postfix expression of the infix expression.
     */
    private String postfixExpression;

    /**
     * Stack that holds elements of operators.
     */
    private Stack<String> operatorStack;

    public Expression() {
        infixExpression = null;
        symbols = null;
        postfixExpression = "";
        operatorStack = null;
    } // end of StackUtility default constructor

    /**
     * Constructs an object of Expression with a user-defined infixExpression.
     * @param infixExpression given String representation of infixExpression.
     */
    public Expression(String infixExpression) {
        this.infixExpression = infixExpression;
        this.symbols = null;
        this.postfixExpression = "";
        this.operatorStack = null;
    } // end of Expression constructor (infixExpression)

    /**
     * TODO: Documentation
     * @return
     */
    public String getInfixExpression() {
        return infixExpression;
    } // end of getInfixExpression accessor method

    /**
     * TODO: Documentation
     * @param infixExpression
     */
    public void setInfixExpression(String infixExpression) {
        this.infixExpression = infixExpression;
    } // end of setInfixExpression mutator method

    /**
     * TODO: Documentation
     * @return
     */
    public char[] getSymbols() {
        return symbols;
    } // end of getSymbols accessor method

    /**
     * TODO: Documentation
     * @param symbols
     */
    public void setSymbols(char[] symbols) {
        this.symbols = symbols;
    } // end of setSymbols mutator method

    /**
     * TODO: Documentation
     * @return
     */
    public String getPostfixExpression() {
        return postfixExpression;
    } // end of getPostfixExpression accessor method

    /**
     * TODO: Documentation
     * @param postfixExpression
     */
    public void setPostfixExpression(String postfixExpression) {
        this.postfixExpression = postfixExpression;
    } // end of setPostfixExpression mutator method

    /**
     * TODO: Documentation
     * @return
     */
    public Stack<String> getOperatorStack() {
        return operatorStack;
    } // end of getOperatorStack accessor method

    /**
     * TODO: Documentation
     * @param operatorStack
     */
    public void setOperatorStack(Stack<String> operatorStack) {
        this.operatorStack = operatorStack;
    } // end of setOperatorStack mutator method

    /**
     * TODO: Documentation
     * @return
     */
    @Override
    public String toString() {
        return "Infix Expression: " + infixExpression +
                "Postfix Expression: " + postfixExpression +
                "Symbols: " + String.valueOf(getSymbols());
    } // end of toString method

    /**
     * TODO: Documentation
     * @param operator1 Character representation of the first operator.
     * @param operator2 Character representation of the second operator.
     * @return True if operator1 has precedence over operator2, false if otherwise.
     */
    public boolean checkPrecedence(char operator1, char operator2) {
        boolean result = false;


        return result;
    } // end of checkPrecedence method

    public boolean isOperand(char currentCharacter) {

    } // end of isOperand method

    /**
     * TODO: Documentation
     * @return
     */
    public void convertToPostfix() {
        symbols = toSymbols(infixExpression);
        operatorStack = new Stack<>();
        int index = 0;

        while (index != infixExpression.length()) {
            if (isOperand(infixExpression.charAt(index))) {
                postfixExpression.concat(String.valueOf(symbols[index]));
            } else {
                while (!operatorStack.isEmpty() && checkPrecedence(operatorStack.peek(), symbols[index])) {
                    postfixExpression.concat(operatorStack.pop());
                } // end of while (!empty stack)
                if (operatorStack.isEmpty() || symbols[index] != ')') {
                    operatorStack.push(String.valueOf(symbols[index]));
                } else {

                } // end of if-else (empty stack)
            } // end of if-else (isOperand)
            index++;
        } // end of while (infixExpression length)
        while (!operatorStack.isEmpty()) {
            postfixExpression.concat()
        }
    } // end of convertToPostfix method

    /**
     * TODO: Documentation
     * @param infixExpression
     * @return
     */
    private char[] toSymbols(String infixExpression) {
        char[] symbols = new char[infixExpression.length()];
        for (int x = 0; x < symbols.length; x++) {
            symbols[x] = infixExpression.charAt(x);
        } // end of for
        return symbols;
    } // end of toSymbols method
} // end of class StackUtility
