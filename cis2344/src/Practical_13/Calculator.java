package Practical_13;

import java.text.DecimalFormat;
import java.util.Stack;

public class Calculator {

    public double calculatePostfix(String postfixExpression) throws InvalidPostfixExpressionException, InvalidTokenTypeException {
        String[] splitPostfix = splitPostfix(postfixExpression);

        if (splitPostfix.length < 3)
            throw new InvalidPostfixExpressionException();

        int currentPostfixTokenIndex = 0;
        Stack<String> stack = new Stack<>();

        System.out.println("Postfix Expression: \"" + postfixExpression + "\"");
        System.out.println();
        System.out.println("Method    | Return value | Stack Contents");
        System.out.println("-----------------------------------------");

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

        var finalToken = pop(stack);
        if (isNumber(finalToken))
            return Double.parseDouble(finalToken);

        throw new InvalidOperandException();
    }

    private String[] splitPostfix(String postfixExpression) {
        return postfixExpression.split(" ");
    }

    private boolean hasNextPostfixToken(int currentPostfixTokenIndex, String[] splitPostfix) {
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
            operandRight = Double.parseDouble(operandRightToken);
            operandLeft = Double.parseDouble(operandLeftToken);

        } catch (Exception e) {
            throw new InvalidOperandException();
        }

        // Do to previous checks, there should never be a case where an operator token is invalid.
        double result = 0;
        switch (operatorToken) {
            case "*" -> result = operandLeft * operandRight;
            case "/" -> result = operandLeft / operandRight;
            case "+" -> result = operandLeft + operandRight;
            case "-" -> result = operandLeft - operandRight;
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