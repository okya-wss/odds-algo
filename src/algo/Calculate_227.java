package algo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shuaishuai.wang
 * @date 2022-03-01
 **/
public class Calculate_227 {

    //加号 将数字压入栈 减号：将数字的相反数压入栈 乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果
    public static int calculate(String s) {
        char preOps = '+';
        Deque<Integer> stack = new LinkedList<>();
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                switch (preOps) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                    default:
                }
                preOps = ch;
                number = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }


    // public static int calculate(String s) {
    //     Deque<Character> ops = new LinkedList<>();
    //     ArrayList<String> tokens = new ArrayList<>();
    //     String number = "";
    //     s = s + " ";
    //     for (char ch : s.toCharArray()) {
    //         if (Character.isDigit(ch)) {
    //             number = number + ch;
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
    //         int currRank = getRank(ch);
    //         while (!ops.isEmpty() && getRank(ops.peek()) >= currRank) {
    //             tokens.add(ops.peek().toString());
    //             ops.pop();
    //         }
    //         ops.push(ch);
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
    //     } else {
    //         return 1;
    //     }
    // }
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

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}
