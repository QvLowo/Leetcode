package com.qvl.solution.array.easy;

import java.util.Arrays;
import java.util.HashMap;


/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result1 = BruteForce(nums, target);
        int[] result2 = HashMap(nums, target);
        System.out.println("BruteForce output: " + Arrays.toString(result1));
        System.out.println("HashMap output: " + Arrays.toString(result2));
    }

    // time complexity O(n^2)  & space complexity O(1)
    public static int[] BruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // time complexity O(n)  & space complexity O(n)
    public static int[] HashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int anotherNumber = target - nums[i];
            if (map.containsKey(anotherNumber)) {
                return new int[]{map.get(anotherNumber), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

