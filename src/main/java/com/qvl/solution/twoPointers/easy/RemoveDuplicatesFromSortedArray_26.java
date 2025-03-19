package com.qvl.solution.twoPointers.easy;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once.
 * 給定一個按非遞減順序排序的整數數組 nums，請原地(=不可開新的空間)移除重複項，使每個唯一元素僅出現一次，
 * The relative order of the elements should be kept the same.
 * 並保持元素的相對順序不變。
 * Then return the number of unique elements in nums.
 * 然後返回 nums 中唯一元素的數量。
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you
 * need to do the following things:
 * 考慮 nums 中唯一元素的數量為 k，要通過這個題目，你需要完成以下事項：
 * 1. Change the array nums such that the first k elements of nums contain
 * theunique elements in the order they were present in nums initially.
 * 修改數組 nums，使其前 k 個元素包含原始 nums 中按照出現順序排列的唯一元素。
 * 2. The remaining elements of nums are not important as well as the size of
 * nums.
 * nums 中剩餘的元素不重要，數組的大小也無需考慮。
 * 3. Return k.
 * 返回 k。
 * 
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 2 };
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.printf("output: %s%n", removeDuplicates(nums1)); // 2
        System.out.printf("output: %s%n", removeDuplicates(nums2)); // 5

    }

    // 快慢指針 = 移動方向相同，但指針一快一慢
    // time complexity O(n) & space complexity O(1)
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slowIndex = 0; // 慢指針，符合條件才移動，代表處理完值的index
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            // 如果相比，數字不一樣，慢指針右移
            if (nums[fastIndex] != nums[slowIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[fastIndex]; // 移除重複的數字
            }
        }
        return slowIndex + 1; // 加上起點
    }
}