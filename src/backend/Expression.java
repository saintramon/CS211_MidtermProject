package backend;

import java.lang.*;

/**
 * @author ROXAS, LACANILAO, SICCUAN
 * @version 1.00 (13 October 2023)
 * Template for Expressions object.
 * This class converts an infix expression to a postfix expression by implementing the Stack data structure.
 */
public class Expression {



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

    /**
     * TODO: Documentation
     * @param currentCharacter
     * @return
     */
    public boolean isOperand(char currentCharacter) {
        char[] operators = {'+','-','*','/','^','(',')'};
        for (char operator : operators) {
            if (currentCharacter == operator) {
                return true;
            } // end of if
        } // end of for
        return false;
    } // end of isOperand method

    /**
     * TODO: Documentation
     * @param infixExpression
     * @return
     */
    public String convertToPostfix(String infixExpression) {
        String postfixExpression = "";
        Stack<Character> operatorStack = new Stack<>();
        int index = 0;

        try {
            while (index != infixExpression.length()) {
                char symbol = infixExpression.charAt(index);
                if (!isOperand(symbol)) {
                    postfixExpression = postfixExpression.concat(Character.toString(symbol));
                } else {
                    while (!operatorStack.isEmpty() && checkPrecedence(operatorStack.peek(), symbol)) {
                        postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
                    } // end of while (checkPrecedence)
                    if (operatorStack.isEmpty() || symbol != ')') {
                        operatorStack.push(symbol);
                    } else {
                        char popped = operatorStack.pop();
                    } // end of if-else (empty stack)
                } // end of if-else (isOperand for symbol)
            } // end of while (infixExpression length)
            while (!operatorStack.isEmpty()) {
                postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
            } // end of while
        } catch (StackUnderflowException e) {
            e.printStackTrace();
            e.getMessage();
        } // end of try-catch
        return postfixExpression;
    } // end of convertToPostfix method
} // end of class Expressions
