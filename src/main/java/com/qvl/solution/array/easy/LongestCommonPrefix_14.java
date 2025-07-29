package com.qvl.solution.array.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 寫一個函式，找出一個字串陣列中最長的共同前綴字串。
 * 
 * If there is no common prefix, return an empty string "".
 * 如果沒有任何共同前綴，則回傳空字串 ""。ｓ
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println("output:" + longestCommonPrefix(strs1)); // "fl"
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("output:" + longestCommonPrefix(strs2)); // ""
    }

    // 水平掃描法（Horizontal Scanning）
    // time complexity O(n * m) & space complexity O(1)
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 先假設第一個字是前綴
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 如果 目前的單字從頭開始不包含prefix，就縮短prefix
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
