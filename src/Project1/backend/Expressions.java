package Project1.backend;

import Project1.backend.stack.Stack;

/**
 * @author ROXAS, LACANILAO
 * @version 2.00 (17 October 2023)
 * Template for object Expression.
 * This class converts and evaluates an infix expression to postfix expression.
 */
public class Expressions {

    public int getPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0; // for parentheses and other characters
        };
    }

    public boolean checkPrecedence(char operator1, char operator2) {
        int precedence1 = getPrecedence(operator1);
        int precedence2 = getPrecedence(operator2);
        return precedence1 >= precedence2;
    }

    /**
     * TODO: Documentation
     * @param infixExpression given String value of an infix expression
     * @return String representation of the converted postfix expression from infix
     */
    public String convertToPostfix(String infixExpression) {
        String postfixExpression = "";
        Stack<Character> operatorStack = new Stack<>();

        for (int index = 0; index < infixExpression.length(); index++) {
            char symbol = infixExpression.charAt(index);
            if (Character.isLetterOrDigit(symbol)) {
                postfixExpression = postfixExpression.concat(Character.toString(symbol));
            } else if (symbol == '(') {
                operatorStack.push(symbol);
            } else if (symbol == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    char popped = operatorStack.pop();
                }
            } else {
                while (!operatorStack.isEmpty() && checkPrecedence(operatorStack.peek(), symbol)) {
                    postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
                } // end of while (checkPrecedence)
                operatorStack.push(symbol);
            } // end of if-else (isOperand for symbol)
        } // end of for
        while (!operatorStack.isEmpty()) {
            postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
        } // end of while
        return postfixExpression;
    } // end of convertToPostfix method

    // TODO: Evaluate methods

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
