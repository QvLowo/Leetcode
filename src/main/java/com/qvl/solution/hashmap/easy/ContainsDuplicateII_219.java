package com.qvl.solution.hashmap.easy;

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k,return true if there exist two
 * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i
 * - j) <= k.
 * 給定一個整數陣列 nums 和一個整數 k，如果存在兩個不同的索引 i 和 j，使得 nums[i] == nums[j] 且 abs(i - j) <=
 * k，則返回 true。
 */

public class ContainsDuplicateII_219 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println("output: " + result); // true

        int[] nums2 = { 1, 0, 1, 1 };
        int k2 = 1;
        boolean result2 = containsNearbyDuplicate(nums2, k2);
        System.out.println("output: " + result2); // true

        int[] nums3 = { 1, 2, 3, 1, 2, 3 };
        int k3 = 2;
        boolean result3 = containsNearbyDuplicate(nums3, k3);
        System.out.println("output: " + result3); // false
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}