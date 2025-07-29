package com.qvl.solution.array.easy;

/**
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 給定兩個字串 needle 和 haystack，返回 needle 在 haystack 中第一次出現的索引位置；如果 needle 不是
 * haystack 的一部分，則返回 -1。
 */

public class FindTheIndexOfTheFirstOccurrenceInAString_28 {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println("java output:" + strStr(haystack, needle)); // 0
        System.out.println("KMP output:" + strByKMP(haystack, needle)); // 0

        haystack = "leetcode";
        needle = "leeto";
        System.out.println("java output:" + strStr(haystack, needle)); // -1
        System.out.println("KMP output:" + strByKMP(haystack, needle)); // -1

    }

    // java內建方法
    // time complexity O(n * m) & space complexity O(1)
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // KMP（Knuth-Morris-Pratt)演算法 ，如果被禁止使用內建函數的情況用這個
    // time complexity O(n + m) & space complexity O(m)
    public static int strByKMP(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;

        int[] lps = buildLPS(needle);
        int i = 0, j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j; // 有包含子字串
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1; // 沒有包含子字串
    }

    private static int[] buildLPS(String needle) {
        int[] lps = new int[needle.length()];
        int len = 0, i = 1;

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }

        return lps;
    }
}