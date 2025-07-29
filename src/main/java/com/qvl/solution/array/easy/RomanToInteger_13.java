package com.qvl.solution.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 羅馬數字由七個不同的符號表示：I、V、X、L、C、D 和 M。
 * 
 * Symbol Value
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * 
 * For example, 2 is written as II in Roman numeral, just two ones added
 * together. 12 is written as XII, which is simply X + II. The number 27 is
 * written as XXVII, which is XX + V + II.
 * 例如，數字 2 在羅馬數字中寫作 II，就是兩個 1 相加。數字 12 寫作 XII，即 X + II。數字 27 則寫作 XXVII，即 XX + V
 * + II。
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 羅馬數字通常從左到右按數值從大到小排列。不過，有些情況會使用「減法規則」。例如，數字 4 不是寫成 IIII，而是寫成 IV，因為 1 在 5
 * 的前面，表示要減去 1，變成 4。類似地，數字 9 寫作 IX。
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * I 可以放在 V (5) 和 X (10) 前面，表示 4 和 9。
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * X 可以放在 L (50) 和 C (100) 前面，表示 40 和 90。
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * C 可以放在 D (500) 和 M (1000) 前面，表示 400 和 900。
 * Given a roman numeral, convert it to an integer.
 * 給定一個羅馬數字，請將其轉換為整數。
 */

public class RomanToInteger_13 {
    public static void main(String[] args) {
        String s1 = "III";
        int result1 = romanToInt(s1);
        System.out.println("output:" + result1); // 3

        String s2 = "LVIII";
        int result2 = romanToInt(s2);
        System.out.println("output:" + result2); // 58

        String s3 = "MCMXCIV";
        int result3 = romanToInt(s3);
        System.out.println("output:" + result3); // 1994
    }

    // time complexity O(n) & space complexity O(1)
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int lastValue = 0;
        // 羅馬數字 左符號<右符號=減法，反之加法，所以先從右到左計算
        for (int i = s.length() - 1; i >= 0; i--) {
            // 最後一位的值
            int currentValue = map.get(s.charAt(i));
            // 目前的值 < 上一個數字 -> 結果減掉目前的值
            if (currentValue < lastValue) {
                total -= currentValue;
                // 目前的值 > 上一個數字 -> 結果加上目前的值
            } else {
                total += currentValue;
            }
            // 計算完後，目前的值=上一個數字，指針再繼續往左邊找
            lastValue = currentValue;
        }
        return total;
    }
}