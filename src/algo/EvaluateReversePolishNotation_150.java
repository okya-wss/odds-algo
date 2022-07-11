package algo;

import java.util.Deque;
import java.util.LinkedList;

// 150 evaluate-reverse-polish-notation	逆波兰表达式求值

public class EvaluateReversePolishNotation_150 {
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("*") || token.equals("+") || token.equals("/") || token.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
