package com.qvl.solution.hashmap.easy;

import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 給定兩個字串 s 和 t，如果 t 是 s 的字母重排（Anagram），則返回 true，否則返回 false。
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */

public class ValidAnagram_242 {

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        String s2 = "rat";
        String t2 = "car";

        boolean result1 = isAnagram(s1, t1); // true
        System.out.printf("output: %s%n", result1);

        boolean result2 = isAnagram(s2, t2); // false
        System.out.printf("output: %s%n", result2);

        boolean result3 = isAnagramByAtoZ(s1, t1);
        System.out.printf("output: %s%n", result3);

        boolean result4 = isAnagramByAtoZ(s2, t2);
        System.out.printf("output: %s", result4);
    }

    // time complexity O(n) & space complexity O(1)
    public static boolean isAnagram(String s, String t) {
        // 如果s字串和t字串長度不一樣，一定不是字母重排
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countMap = new HashMap<>();
        // toCharArry = String轉成 char array
        // getOrDefault = countMap.containsKey(alphabet) ? countMap.get(alphabet) : 0
        // 如果字母有在 s的字元陣列裡，更新字母在map出現的次數。
        for (char alphabet : s.toCharArray()) {
            int currentCount = countMap.getOrDefault(alphabet, 0);
            int newCount = currentCount + 1;
            countMap.put(alphabet, newCount);
        }

        // 如果字母 在 t的字元陣列裡，更新map的出現次數 -1。
        for (char alphabet : t.toCharArray()) {
            // 字母不在countMap(計算s字母出現次數的map)中，或是超過map出現的次數，代表不是字母重排。
            if (!countMap.containsKey(alphabet) || countMap.get(alphabet) == 0) {
                return false;
            }
            int currentCount = countMap.get(alphabet);
            int newCount = currentCount - 1;
            countMap.put(alphabet, newCount);
        }
        return true;
    }

    // time complexity O(n) & space complexity O(1) more fast (best func)
    public static boolean isAnagramByAtoZ(String s, String t) {
        // 如果s字串和t字串長度不一樣，一定不是字母重排
        if (s.length() != t.length()) {
            return false;
        }
        // a-z
        int[] count = new int[26];
        // 先計算 字母在s相對應index 出現的次數
        for (char alphabet : s.toCharArray()) {
            // ascii 97~126 = a~z
            // if alphabet = a , a - a = count[0] 先賦值再 + 1
            count[alphabet - 'a']++;
        }
        // 出現在 t 陣列 就 -1，如果 < 0，代表出現次數超過s陣列的次數
        for (char alphabet : t.toCharArray()) {
            // if alphabet = c ,--count[2] = 先-1 再賦值 => count[1] 再比較 < 0
            if (--count[alphabet - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}