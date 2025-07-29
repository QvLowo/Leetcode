package com.qvl.solution.array.easy;

/**
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 給定一個由單字與空格組成的字串 s，回傳字串中最後一個單字的長度。
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 一個「單字」是指由非空白字元組成的最長子字串。
 */
public class LengthOfLastWord_58 {

    public static void main(String[] args) {
        String s1 = "Hello World";
        System.out.println("output:" + lengthOfLastWord(s1)); // 5
        String s2 = "   fly me   to   the moon  ";
        System.out.println("output:" + lengthOfLastWord(s2)); // 4
        String s3 = "luffy is still joyboy";
        System.out.println("output:" + lengthOfLastWord(s3)); // 6
    }

    // time complexity O(n) & space complexity O(1)
    public static int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1; // 字串最後一位

        // 如果遇到空格，指針就左移
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        // 指針左移掃描，計算最後一個單字的長度
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

}