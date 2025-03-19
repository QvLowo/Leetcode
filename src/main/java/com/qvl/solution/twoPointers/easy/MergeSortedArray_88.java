package com.qvl.solution.twoPointers.easy;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 給兩個整數陣列 分別為nums1 & nums2 ,按 非遞減順序 排序,
 * 並且有兩個整數 m & n 分別代表nums1 & nums2 的元素數量．
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 將nums1 & nums2 合併成一個單一陣列，並按 非遞減順序(=遞增) 排序．
 * 
 * The final sorted array should not be returned by the function,but instead
 * bestored inside the array nums1.
 * 最終的排序陣列 不應由方法返回，而是取代儲存在陣列nums 1
 * 
 * To accommodate this, nums1 has a length of m +
 * n, where the first m elements denote the elements that should be merged, and
 * the last n elements are set to 0 and should be ignored. nums2 has a length of
 * n.
 * 為了適應這個，nums1 的長度為m+n，其中前m個元素代表應合併，最後n個元素設為0 應忽略， nums2 的長度為n．
 * 
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1.
 * 
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * 
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there
 * to ensure the merge result can fit in nums1.
 */
public class MergeSortedArray_88 {
    public static void main(String[] args) {
        // example1:
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m1 = 3;
        int[] nums2 = { 2, 5, 6 };
        int n1 = 3;
        merge(nums1, m1, nums2, n1);
        System.out.printf("output: %s%n", Arrays.toString(nums1)); // [1,2,2,3,5,6]

        // example2:
        int[] nums3 = { 1 };
        int m2 = 1;
        int[] nums4 = {};
        int n2 = 0;
        merge(nums3, m2, nums4, n2);
        System.out.printf("output: %s%n", Arrays.toString(nums3)); // [1]

        // example3:
        int[] nums5 = { 0 };
        int m3 = 0;
        int[] nums6 = { 1 };
        int n3 = 1;
        merge(nums5, m3, nums6, n3);
        System.out.printf("output: %s%n", Arrays.toString(nums3)); // [1]

    }

    // 從後往前雙指針 = 指針從最後面往前跑 (可以想像畫面是從nums1的最後面往前塞入值)
    // time complexity O(m+n) & space complexity O(1) 同一個陣列處理，沒有額外開空間
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // i = nums1有值的最後一位 , j = nums2有值的最後一位 , k = nums1的最後一位
        int i = m - 1, j = n - 1, k = m + n - 1;

        // 當 nums1 和 nums2 都有值
        while (i >= 0 && j >= 0) {
            // 如果 nums1[i]的值 > nums2[j] ，將 i位置的值塞入nums1的k位置後，指針往左移(--)
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
                // 反之，將nums2[j]的值塞入nums1的 k位置後，指針往左移(--)
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // 如果nums2還有剩餘的值，塞入nums1的 k位置後，指針往左移(--)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}