package com.qvl.solution.twoPointers.easy;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 給定一個整數陣列 nums，請將所有的 0 移動到陣列的末端，同時維持非零元素的相對順序。
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 注意：你必須原陣列（in-place）操作，不能複製陣列。
 * 
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums1 = { 0, 1, 0, 3, 12 };
        int[] nums2 = { 0 };
        moveZeroes(nums1);
        moveZeroes(nums2);
        System.out.printf("output: %s%n", Arrays.toString(nums1)); // [1,3,12,0,0]
        System.out.printf("output: %s%n", Arrays.toString(nums2)); // [0]

    }

    // Time Complexity O(n) & Space Complexity O(1) (more fast)
    public static void moveZeroes(int[] nums) {
        // 遇到值是0 insertIndex不變 繼續往下比
        int insertIndex = 0; // 要塞入的位置
        // i掃描非0的數字，再往前塞
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertIndex++] = nums[i];
            }
        }
        // 剩下的位子塞0
        while (insertIndex < nums.length) {
            nums[insertIndex++] = 0;
        }
    }

    // Time Complexity O(n) & Space Complexity O(1)
    public static void moveZeroesV2(int[] nums) {
        int j = 0; // j放非零

        for (int i = 0; i < nums.length; i++) { // i找非零
            if (nums[i] != 0) {
                // i != j 才交換位置，避免相同的值在交換
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
    }
}