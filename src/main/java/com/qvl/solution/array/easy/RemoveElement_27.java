package com.qvl.solution.array.easy;

/**
 * Given an integer array nums and an integer val,remove all occurrences of val
 * in nums in-place.
 * 給定一個整數陣列 nums 和一個整數值 val，請你就地（in-place）移除所有數值等於 val 的元素。
 * The order of the elements may be changed.
 * 元素的順序可以改變，你不需要保留原本的順序。
 * Then return the number of elements in nums which are not equal to val.
 * 請你回傳一個整數 k，代表陣列中不等於 val 的元素個數。
 * <p>
 * Consider the number of elements in nums which are not equal to val be k, to
 * get accepted,you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the
 * elements which are not equal to val.
 * 請你將 nums 陣列修改，使其前 k 個元素為不等於 val 的值。
 * The remaining elements of nums are not important as well as the size of nums.
 * 陣列剩下的部分不重要（不需要清空或處理）。
 * Return k.
 * 返回的 k 必須是 nums 中不等於 val 的元素個數。
 */

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = removeElement(nums, val);
        System.out.println("output: " + k); // 2
    }

    // time complexity O(n) & space complexity O(1)
    public static int removeElement(int[] nums, int val) {
        // k 用來計算不等於val值有幾個
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果nums的值不等於val，就把它放到k的位置，指針往右移
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
