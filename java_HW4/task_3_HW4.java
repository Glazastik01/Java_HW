package java_HW4;

import java.util.Stack;

public class task_3_HW4 {
    public static void main(String[] args) {
        String str1 = "()[]{}"; // true
        String str2 = "([)]"; // false

        System.out.println(isValid(str1)); // true
        System.out.println(isValid(str2)); // false
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

