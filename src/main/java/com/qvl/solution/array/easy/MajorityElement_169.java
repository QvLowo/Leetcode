package com.qvl.solution.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums of size n, return the majority element.
 * 給定一個大小為 n 的陣列 nums，請你回傳陣列中的多數元素。
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * 多數元素是指在陣列中出現次數大於 ⌊n / 2⌋（n 除以 2 的整數部分）次的元素。
 * You may assume that the majority element always exists in the array.
 * 你可以假設在這個陣列中多數元素一定存在。
 */
public class MajorityElement_169 {

    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 3 };
        int result1 = majorityElement(nums1);
        System.out.println("output:" + result1); // 3

        int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
        int result2 = majorityElement(nums2);
        System.out.println("output:" + result2); // 2

    }

    // Boyer-Moore 投票演算法
    // time complexity O(n) & space complexity O(1)
    public static int majorityElement(int[] nums) {
        int count = 0; // 得票數
        int candidate = 0; // 候選人

        for (int num : nums) {
            // 如果得票數=0, 當前候選人沒有支持度，代表換當前的值為新的候選人
            if (count == 0) {
                candidate = num; // 候選人換人
            }
            // 如果當前值=候選人 , 票數+1，反之-1
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        // 返回最終候選人
        return candidate;
    }

}
