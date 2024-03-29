package Practical_13;

import java.text.DecimalFormat;
import java.util.Stack;

public class Calculator {

    public double calculatePostfix(String postfixExpression) throws InvalidPostfixExpressionException, InvalidTokenTypeException, InvalidResultException {
        // Convert the postfix expression from a string to an array of tokens.
        String[] splitPostfix = splitPostfix(postfixExpression);

        // It's not possible to have a postfix expression with less than three tokens as
        // two operands and one operator are required.
        if (splitPostfix.length < 3)
            throw new InvalidPostfixExpressionException();

        int currentPostfixTokenIndex = 0;
        Stack<String> stack = new Stack<>();

        System.out.println("Postfix Expression: \"" + postfixExpression + "\"");
        System.out.println();
        System.out.println("Method    | Return value | Stack Contents");
        System.out.println("-----------------------------------------");

        // Keep looping until all the tokens from the postfix expression have been processed.
        while (hasNextPostfixToken(currentPostfixTokenIndex, splitPostfix)) {
            String currentToken = getNextPostfixToken(currentPostfixTokenIndex, splitPostfix);
            currentPostfixTokenIndex++;

            switch (getTokenType(currentToken)) {
                case Operand -> push(stack, currentToken);
                case Operator -> {
                    push(stack, currentToken);
                    processOperator(stack);
                }
                case Invalid -> throw new InvalidTokenTypeException();
            }
        }

        // All tokens from the postfix expression have been processed.

        // The final token in the stack should be the result of the expression.
        // If it is not a number then the postfix expression is invalid.
        var finalToken = pop(stack);
        if (isNumber(finalToken))
            return Double.parseDouble(finalToken);

        throw new InvalidResultException();
    }

    private String[] splitPostfix(String postfixExpression) {
        return postfixExpression.split(" ");
    }

    private boolean hasNextPostfixToken(int currentPostfixTokenIndex, String[] splitPostfix) {
        // Haven't reached the end of the token array yet.
        return currentPostfixTokenIndex >= 0 && currentPostfixTokenIndex < splitPostfix.length;
    }

    private String getNextPostfixToken(int currentPostfixTokenIndex, String[] splitPostfix) {
        return splitPostfix[currentPostfixTokenIndex];
    }

    private static TokenType getTokenType(String token) {
        if (isNumber(token))
            return TokenType.Operand;

        return switch (token) {
            case "*", "/", "+", "-" -> TokenType.Operator;
            default -> TokenType.Invalid;
        };

    }

    private static boolean isNumber(String number) {
        // Check if the string is a number by trying to convert it to a double.
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String doubleToString(double number) {
        // Removes trailing zeros to give better human readability.
        var format = new DecimalFormat("0.#");
        return format.format(number);
    }

    private void push(Stack<String> tokenStack, String token) {
        tokenStack.push(token);

        String sb = "push(" + token + ")   | " + token + "            | " + tokenStack;
        System.out.println(sb);
    }

    private String pop(Stack<String> tokenStack) {
        var token = tokenStack.pop();

        String sb = "pop()    | " + token + "            | " + tokenStack;
        System.out.println(sb);

        return token;
    }

    private void processOperator(Stack<String> tokenStack) throws InvalidPostfixExpressionException {
        String operatorToken;
        String operandRightToken;
        String operandLeftToken;

        try {
            // Pop 3 times (the operator, num 1 and num2).
            // If cannot pop, then this is an invalid postfix expression.
            operatorToken = pop(tokenStack);
            operandRightToken = pop(tokenStack);
            operandLeftToken = pop(tokenStack);
        } catch (Exception e) {
            throw new InvalidPostfixExpressionException();
        }

        double operandRight;
        double operandLeft;
        try {

            // Convert operands to doubles.
            // If cannot convert, then these are invalid operands.
            operandRight = Double.parseDouble(operandRightToken);
            operandLeft = Double.parseDouble(operandLeftToken);

        } catch (Exception e) {
            throw new InvalidOperandException();
        }

        // Do to previous checks, there should never be a case where an operator token is invalid.
        double result = 0;
        switch (operatorToken) {
            case "*" -> result = operandLeft * operandRight /* multiply */;
            case "/" -> result = operandLeft / operandRight /* divide */;
            case "+" -> result = operandLeft + operandRight /* add */;
            case "-" -> result = operandLeft - operandRight /* subtract */;
        }

        push(tokenStack, doubleToString(result));
    }
}

enum TokenType {
    Operand,
    Operator,
    Invalid
}

class InvalidPostfixExpressionException extends Exception {
}

class InvalidTokenTypeException extends Exception {
}

class InvalidOperandException extends NumberFormatException {
}

class InvalidResultException extends Exception {
}