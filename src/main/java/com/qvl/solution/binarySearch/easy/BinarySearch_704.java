package com.qvl.solution.binarySearch.easy;

import java.sql.Time;

/**
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 給定一個按照升序排列的整數陣列 nums，以及一個整數 target，請寫一個函數來搜尋 target 是否存在於陣列中。如果 target
 * 存在，則返回其索引，否則返回 -1。
 * You must write an algorithm with O(log n) runtime complexity.
 * 你必須實現時間複雜度為 O(log n) 的演算法。
 * 
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 
 * 把他當成ro小遊戲：終極密碼來想，就是二分法owo！！
 */
public class BinarySearch_704 {

    public static void main(String[] args) {
        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        int target1 = 9;
        System.out.printf("output: %s%n", search(nums1, target1)); // 4

        int[] nums2 = { -1, 0, 3, 5, 9, 12 };
        int target2 = 2;
        System.out.printf("output: %s%n", search(nums2, target2)); // -1
    }

    // Time Complexity O(log n) & Space Complexity O(1)
    public static int search(int[] nums, int target) {
        int leftIndex = 0; // 頭
        int rightIndex = nums.length - 1; // 尾

        while (leftIndex <= rightIndex) {
            // 起點(index) + 一半(相隔幾個index) = 中間的index
            int middle = leftIndex + (rightIndex - leftIndex) / 2; // 避免整數溢位

            if (nums[middle] == target) {
                return middle; // 找到目標
                // 因為是升序，如果中間的值 小於 目標值
            } else if (nums[middle] < target) {
                leftIndex = middle + 1; // 排除原本左指針的值，往右邊搜尋
            } else {
                rightIndex = middle - 1; // 排除右指針的值，往左邊搜尋
            }
        }

        return -1; // 沒找到
    }

}
