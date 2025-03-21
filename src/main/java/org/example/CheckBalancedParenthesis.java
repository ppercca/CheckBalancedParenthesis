package org.example;

import java.util.Stack;

/**
 * Implementar un algoritmo que indique si una expresión compuesta por paréntesis, está bien balanceada o no está bien balanceada.
 * Paréntesis válidos: (, ), {, }, [, ]
 * Ejemplos:
 * (): bien balanceado
 * ((): mal balanceado
 * ({}): bien balanceado
 * ({)}: mal balanceado
 * )(: mal balanceado
 * [{[]}()]: bien balanceado
 * {}(): bien balanceado
 *
 */
public class CheckBalancedParenthesis
{
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else if (isClose(c)) {
                if (stack.isEmpty() || !isPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private static boolean isClose(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }

    private static boolean isPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main( String[] args )
    {
        String[] expresions = {
                "()", "(()", "({})", "({)}", ")(", "[{[]}()]", "{}()"
        };

        for (String expresion : expresions) {
            System.out.println(expresion + ": " + (isBalanced(expresion) ? "Balanced" : "Not balanced"));
        }
    }
}
