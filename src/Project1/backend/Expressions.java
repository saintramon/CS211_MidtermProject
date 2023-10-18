package Project1.backend;

import Project1.backend.stack.Stack;

/**
 * @author ROXAS, LACANILAO
 * @version 2.00 (17 October 2023)
 * Template for object Expression.
 * This class converts and evaluates an infix expression to postfix expression.
 */
public class Expressions {

    /**
     * TODO: Documentation
     *
     * @param operator1 given Character representation of the first operator.
     * @param operator2 given Character representation of the second operator.
     * @return
     */
    public boolean checkPrecedence(char operator1, char operator2) {
        switch (operator1) {
            case '+', '-' -> operator1 = 1;
            case '*', '/' -> operator1 = 2;
            case '^' -> operator1 = 3;
            default -> operator1 = 0; // for parentheses and other characters
        } // end of switch-case (operator1)
        switch (operator2) {
            case '+', '-' -> operator2 = 1;
            case '*', '/' -> operator2 = 2;
            case '^' -> operator2 = 3;
            default -> operator2 = 0; // for parentheses and other characters
        } // end of switch-case (operator 2)
        return operator1 >= operator2;
    }

    /**
     * TODO: Documentation
     *
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

    /**
     * Evaluate a postfix expression and return the result.
     *
     * @param postfixExpression The postfix expression to be evaluated.
     * @return The result of the evaluation.
     * @version 1.0
     */
    public double evaluatePostfix(String postfixExpression) {
        Stack<Double> operandStack = new Stack<>();

        for (int index = 0; index < postfixExpression.length(); index++) {
            char symbol = postfixExpression.charAt(index);

            if (Character.isDigit(symbol)) {
                operandStack.push((double) (symbol - '0'));
            } else if (Character.isLetter(symbol)) {

            } else if (isOperator(symbol)) {
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = performOperation(operand1, operand2, symbol);
                operandStack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token in postfix expression: " + symbol);
            }
        }

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return operandStack.pop();
    }

    /**
     * Check if a character is an operator.
     *
     * @param symbol The character to check.
     * @return True if the character is an operator, false otherwise.
     * @version 1.0
     */
    private boolean isOperator(char symbol) {
        return "+-*/^".indexOf(symbol) != -1;
    }

    /**
     * Perform an arithmetic operation on two operands.
     *
     * @param operand1 The first operand.
     * @param operand2 The second operand.
     * @param operator The operator to apply.
     * @return The result of the operation.
     * @version 1.0
     */
    private double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        } // end of switch-case method
    } // end of performOperation method


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
