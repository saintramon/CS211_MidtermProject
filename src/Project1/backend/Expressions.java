package Project1.backend;

import Project1.backend.stack.Stack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author ROXAS, LACANILAO
 * @version 2.00 (17 October 2023)
 * Template for object Expression.
 * This class converts and evaluates an infix expression to postfix expression.
 */
public class Expressions {

    public Expressions(){}


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
    public String convertToPostfix(String infixExpression, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        String postfixExpression = "";
        Stack<Character> operatorStack = new Stack<>();
        char symbol = ' ';

        for (int index = 0; index < infixExpression.length(); index++) {
            symbol = infixExpression.charAt(index);
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
            model.addRow(new Object[]{symbol,postfixExpression,operatorStack.toString()});
        } // end of for
        while (!operatorStack.isEmpty()) {
            postfixExpression = postfixExpression.concat(operatorStack.pop().toString());
            model.addRow(new Object[]{symbol,postfixExpression,operatorStack.toString()});
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
    public double evaluatePostfix(String postfixExpression, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Stack<Integer> operandStack = new Stack<>();
        char symbol = ' ';
        double result = 0;

        for (int index = 0; index < postfixExpression.length(); index++) {
            symbol = postfixExpression.charAt(index);

            if (Character.isDigit(symbol)) {
                operandStack.push(symbol - '0');
            } else {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();

                switch (symbol) {
                    case '+':
                        operandStack.push(operand1 + operand2);
                        break;
                    case '-':
                        operandStack.push(operand1 - operand2);
                        break;
                    case '*':
                        operandStack.push(operand1 * operand2);
                        break;
                    case '/':
                        operandStack.push(operand1 / operand2);
                        break;
                    case '^':
                        operandStack.push((int) Math.pow(operand1,operand2));
                        break;
                } // end of switch-case
            } // end of if-else (symbol is operand)
            model.addRow(new Object[]{symbol, operandStack.toString()});
        } // end of for
        result = operandStack.pop();
        return result;
    } // end of evaluatePostfix method

    /**
     * TODO: Documentation
     * @param infixExpression
     * @return
     */
    public boolean validateParentheses(String infixExpression) {
        int openCount = 0; // number of open parentheses
        int closeCount = 0; // number of open parentheses
        for (int x = 0; x < infixExpression.length(); x++) {
            if (infixExpression.charAt(x) == '(') {
                openCount++;
            } else if (infixExpression.charAt(x) == ')') {
                closeCount++;
            } // end of if-else
        } // end of for (index of infix expression characters)
        return openCount == closeCount;
    } // end of validateParentheses method

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
