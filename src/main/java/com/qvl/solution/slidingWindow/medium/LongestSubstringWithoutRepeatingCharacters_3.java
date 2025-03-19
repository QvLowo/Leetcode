package com.qvl.solution.slidingWindow.medium;

import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 給定一個字串 s，找出其中不含重複字母的最長子字串的長度。
 * 
 * xample 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * subsequence = 子序列 不連續但順序正確的序列
 * substring = 子字串 連續且順序正確的字串
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.printf("output: %s%n", lengthOfLongestSubstring(s1)); // 3
        System.out.printf("output: %s%n", lengthOfLongestSubstring(s2)); // 1
        System.out.printf("output: %s%n", lengthOfLongestSubstring(s3)); // 3

    }

    public static int lengthOfLongestSubstring(String s) {
        int leftIndex = 0, rightIndex = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        // 窗戶尾指針掃瞄到字串結束
        while (rightIndex < s.length()) {
            // 如果set裡不包含s[rightIndex]的字母，則塞入
            if (!set.contains(s.charAt(rightIndex))) {
                set.add(s.charAt(rightIndex));
                // 計算最大長度 ， 過去與現在相比取最大值，有可能當前的字串比過去掃描到的小
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
                // 窗戶尾指針右移
                rightIndex++;
            } else {
                // 遇到重複的字母 移除set中 窗戶頭指針的值
                set.remove(s.charAt(leftIndex));
                // 窗戶頭右移
                leftIndex++;
            }
        }
        return maxLength;
    }
}
