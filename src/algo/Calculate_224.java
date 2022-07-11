package algo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shuaishuai.wang
 * @date 2022-03-01
 **/
public class Calculate_224 {

    public static int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Deque<Integer> ops = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = 10 * num + ch - '0';
            } else if (ch == '+' || ch == '-') {
                res = res + num * sign;
                sign = ch == '+' ? 1 : -1;
                num = 0;
            } else if (ch == '(') {
                ops.push(res);
                ops.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res = res +  sign * num;
                num = 0;
                res = res * ops.pop();
                res = res + ops.pop();
            }
        }
        res = res + sign * num;
        return res;
    }


    // public static int calculate(String s) {
    //     Deque<Character> ops = new LinkedList<>();
    //     boolean needsZero = true;
    //     ArrayList<String> tokens = new ArrayList<>();
    //     String number = "";
    //     s = s + " ";
    //     for (char ch : s.toCharArray()) {
    //         if (Character.isDigit(ch)) {
    //             number = number + ch;
    //             needsZero = false;
    //             continue;
    //         } else {
    //             if (!number.isEmpty()) {
    //                 tokens.add(number);
    //                 number = "";
    //             }
    //         }
    //         if (ch == ' ') {
    //             continue;
    //         }
    //         if (ch == '(') {
    //             ops.push(ch);
    //             needsZero = true;
    //         }
    //         if (ch == ')') {
    //             while (ops.peek() != '(') {
    //                 tokens.add(ops.pop().toString());
    //             }
    //             ops.pop();
    //             needsZero = false;
    //             continue;
    //         }
    //         if ((ch == '-' || ch == '+') && needsZero) {
    //             tokens.add("0");
    //         }
    //         int currRank = getRank(ch);
    //         while (!ops.isEmpty() && getRank(ops.peek()) >= currRank) {
    //             tokens.add(ops.peek().toString());
    //             ops.pop();
    //         }
    //         ops.push(ch);
    //         needsZero = true;
    //     }
    //     while (!ops.isEmpty()) {
    //         tokens.add(ops.pop().toString());
    //     }
    //     return evalRPN(tokens);
    // }
    //
    //
    // private static int getRank(char ch) {
    //     if (ch == '*' || ch == '/') {
    //         return 2;
    //     }
    //     if (ch == '-' || ch == '+') {
    //         return 1;
    //     }
    //     return 0;
    // }
    //
    //
    // public static int evalRPN(ArrayList<String> tokens) {
    //     if (tokens.size() == 1) {
    //         return Integer.parseInt(tokens.get(0));
    //     }
    //     Deque<Integer> stack = new LinkedList<>();
    //     for (String token : tokens) {
    //         if (token.equals("*") || token.equals("+") || token.equals("/") || token.equals("-")) {
    //             int num1 = stack.pop();
    //             int num2 = stack.pop();
    //             switch (token) {
    //                 case "+":
    //                     stack.push(num1 + num2);
    //                     break;
    //                 case "-":
    //                     stack.push(num2 - num1);
    //                     break;
    //                 case "*":
    //                     stack.push(num1 * num2);
    //                     break;
    //                 case "/":
    //                     stack.push(num2 / num1);
    //                     break;
    //                 default:
    //             }
    //         } else {
    //             stack.push(Integer.parseInt(token));
    //         }
    //     }
    //     return stack.pop();
    // }


}
