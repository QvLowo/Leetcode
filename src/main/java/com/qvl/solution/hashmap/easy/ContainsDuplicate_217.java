package com.qvl.solution.hashmap.easy;

import java.util.HashSet;

/**
 * Given an integer array nums
 * 給定一個整數陣列 nums
 * return true if any value appears at least twice in the array
 * 如果陣列中有任何數值至少出現兩次則回傳 true；
 * and return false if every element is distinct.
 * 如果所有元素皆不重複，則回傳 false。
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 */
public class ContainsDuplicate_217 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        boolean result = containsDuplicate(nums);
        System.out.println("output: " + result);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // 建立一個HashSet
        for (int num : nums) {
            if (!set.add(num)) { // 如果set沒有加num代表有重複的值(因為set的特性不允許重複)
                return true;
            }
        }
        return false;
    }
}