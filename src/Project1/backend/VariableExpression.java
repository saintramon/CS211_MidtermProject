package Project1.backend;

import Project1.backend.stack.Stack;
import java.lang.*;

/**
 * @author ROXAS, Johan Rickardo
 * @version 1.00 (13 October 2023)
 * Template for Expression object.
 * This class converts an infix expression to a postfix expression by implementing the Stack data structure.
 */
public class VariableExpression {
    /**
     * The String representation of the infix expression to be converted.
     */
    private String infixExpression;

    /**
     * The String representation of the postfix expression.
     */
    private String postfixExpression;

    /**
     * Array of characters to hold the elements of the symbols.
     */
    private char[] symbols;

    /**
     * Stack that holds the characters of operators.
     */
    private Stack<Character> operatorStack;

    /**
     * Constructs an object of Expression with null values.
     */
    public VariableExpression() {
        infixExpression = "";
        postfixExpression = "";
        symbols = null;
        operatorStack = null;
    } // end of Expression default constructor

    /**
     * Constructs an object of Expression with user-defined values.
     * @param infixExpression given String representation of infix expression.
     */
    public VariableExpression(String infixExpression) {
        this.infixExpression = infixExpression;
        this.postfixExpression = convertToPostfix();
        this.symbols = populateSymbols();
        this.operatorStack = new Stack<>();
    } // end of Expression constructor

    /**
     * TODO: Documentation
     * @param infixExpression
     */
    public void setInfixExpression(String infixExpression) {
        this.infixExpression = infixExpression;
    } // end of setInfixExpression mutator method

    /**
     * TODO: Documentation
     * @param postfixExpression
     */
    public void setPostfixExpression(String postfixExpression) {
        this.postfixExpression = postfixExpression;
    } // end of setPostfixExpression mutator method

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
    public String getInfixExpression() {
        return infixExpression;
    } // end of getInfixExpression accessor method

    /**
     * TODO: Documentation
     * @return
     */
    public String getPostfixExpression() {
        return postfixExpression;
    } // end of getPostfixExpression accessor method

    /**
     * TODO: Documentation
     * @return
     */
    public char getSymbol(int index) {
        return symbols[index];
    } // end of getSymbols accessor method

    /**
     * TODO: Documentation
     * @return
     */
    public Stack<Character> getOperatorStack() {
        return operatorStack;
    } // end of getOperatorStack accessor method

    /**
     * TODO: Documentation
     * @param operator1 Character representation of the first operator.
     * @param operator2 Character representation of the second operator.
     * @return True if operator1 has precedence over operator2, false if otherwise.
     */
    public boolean checkPrecedence(char operator1, char operator2) {
        boolean result = false;
        // TODO: Supporting code
        return result;
    } // end of checkPrecedence method

    /**
     * TODO: Documentation
     * @param currentCharacter character representation of the symbol being evaluated as an operator.
     * @return true if the symbol is an operator, false if it is an operand
     */
    boolean isOperator(char currentCharacter) {
        char[] operators = {'+','-','*','/','^','$','(',')','[',']','{','}','%'};
        for (char operator : operators) {
            return currentCharacter == operator;
        } // end of for
        return false;
    } // end of isOperand method

    /**
     * TODO: Documentation
     * @return
     */
    private String convertToPostfix() {
        int index = 0;
        while (index != infixExpression.length()) {
            symbols[index] = infixExpression.charAt(index);
            if (!isOperator(symbols[index])) {
                postfixExpression = postfixExpression.concat(Character.toString(symbols[index]));
            } else {
                while (!operatorStack.isEmpty() && checkPrecedence(operatorStack.peek(), symbols[index])) {
                    postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
                } // end of while (checkPrecedence)
                if (operatorStack.isEmpty() || symbols[index] != ')') {
                    operatorStack.push(symbols[index]);
                } else {
                    char popped = operatorStack.pop();
                } // end of if-else (empty stack)
            } // end of if-else (isOperand for symbol)
            index++;
        } // end of while (infixExpression length)
        while (!operatorStack.isEmpty()) {
            postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
        } // end of while
        return postfixExpression;
    } // end of convertToPostfix method

    /**
     * Populates the array of symbols with the characters of the infix expression.
     */
    private char[] populateSymbols() {
        char[] symbols = new char[this.infixExpression.length()];
        for (int x = 0; x < infixExpression.length(); x++) {
            symbols[x] = infixExpression.charAt(x);
        } // end of for
        return symbols;
    } // end of populateSymbols method

    /*
    Notes:
    - Add exception handling method where the number of parentheses, brackets, or curly braces must be syntactically
    correct (number of closings must be equal to the number of openings).
    - Add exception handling method where there should be an operand after each operator (for loop that iterates through
    each character of the user's input, use isOperator method).
    - Think of how you will display the operator Stack in a table (possible use of LinkedList).
    - Think of how you will handle mixture of operator characters when using the checkPrecedence method.
    - Think of how you will display the table properly using the symbols, postfix expression and stack of operators.
     */
} // end of class Expressions
