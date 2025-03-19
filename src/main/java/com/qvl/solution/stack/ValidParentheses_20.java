package com.qvl.solution.stack;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '['
 * and']',
 * determine if the input string is valid.
 * 給定一個包含括號 (, ), {, }, [, ] 的字串 s，判斷該字串是否為 有效的括號組合。
 * 
 * An input string is valid if:
 * 有效的條件：
 * 1. Open brackets must be closed by the same type of brackets.
 * 左括號必須由相同類型的右括號閉合。
 * 2. Open brackets must be closed in the correct order.
 * 左括號必須按照正確的順序閉合。
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 每個右括號都必須有對應的左括號。
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * Example 4:
 * Input: s = "([])"
 * Output: true
 */
public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";

        System.out.printf("output: %s%n", isValid(s1)); // true
        System.out.printf("output: %s%n", isValid(s2)); // true
        System.out.printf("output: %s%n", isValid(s3)); // false
        System.out.printf("output: %s%n", isValid(s4)); // true

    }

    // push :堆，pop:拿 (stack = 先進後出(積木堆高高), heap = 先進先出(排隊))
    // time complexity O(n) & space complexity O(n)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 比較左半邊 當遇到括號的頭 stack就塞入尾
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else {
                // 比較右半邊 如果 stack是空 或stack拿出來的不等於左邊的頭 就是無效的括號組合(false)
                if (stack.isEmpty() || stack.pop() != c)
                    return false;
            }
        }
        return stack.isEmpty(); // c跟字串比完後，因為pop會取出stack的值，所以最後stack是空的 = true
    }
}