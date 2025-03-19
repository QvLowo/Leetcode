package com.qvl.solution.twoPointers.easy;

/**
 * A phrase is a palindrome if,
 * after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * 回文串的定義：
 * 忽略大小寫
 * 忽略非字母數字的字符
 * 轉換為小寫後，正向與反向讀取結果相同
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 給定一個字串 s，如果它是 回文串（Palindrome），則返回 true，否則返回 false。
 * 
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * 
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 */

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.printf("output: %s%n", isPalindrome(s1)); // true
        System.out.printf("output: %s%n", isPalindrome(s2)); // false
        System.out.printf("output: %s%n", isPalindrome(s3)); // true
    }

    // time complexity O(n) & space complexity O(1)
    public static boolean isPalindrome(String s) {
        // 空的直接回true(如範例)
        if (s.isEmpty()) {
            return true;
        }

        int leftIndex = 0, rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            // 左指針右移直到找到字母或數字
            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
            }
            // 右指針左移直到找到字母或數字
            while (leftIndex < rightIndex && !Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
            }

            // 轉小寫後比較，如果左指針的值 != 右指針的值 = 不是回文
            if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))) {
                return false;
            }
            // 兩邊指針的值相等，就繼續往中間移動比較
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

}
