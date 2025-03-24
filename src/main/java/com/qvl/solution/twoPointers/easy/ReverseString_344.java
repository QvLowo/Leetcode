package com.qvl.solution.twoPointers.easy;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 請撰寫一個函式來反轉字串，輸入是一個字元陣列 s，
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 你必須原陣列（in-place）反轉，且只能使用 O(1) 額外空間（不能開新陣列）。
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString_344 {
    public static void main(String[] args) {
        char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
        char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(s1);
        reverseString(s2);
        System.out.printf("output: %s%n", Arrays.toString(s1)); // ["o","l","l","e","h"]
        System.out.printf("output: %s%n", Arrays.toString(s2)); // ["h","a","n","n","a","H"]

    }

    // Time Complexity O(n) & Space Complexity O(1)
    public static void reverseString(char[] s) {
        int leftIndex = 0; // 頭
        int rightIndex = s.length - 1; // 尾
        while (leftIndex < rightIndex) {
            // 交換左右指針的值
            char temp = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = temp;
            // 左右指針往中間靠齊
            leftIndex++;
            rightIndex--;
        }
    }
}
