package com.qvl.solution.array.easy;

import java.util.Arrays;
import java.util.HashMap;


/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * 給定一個整數陣列 nums 和一個整數 target，請回傳兩個數字的索引，使它們的總和等於 target。
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 你可以假設每組輸入都只有一組唯一解，並且不能重複使用相同的元素。
 * You can return the answer in any order.
 * 你可以以任何順序回傳答案。
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSum_1 {
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
            for (int j = i + 1; j < nums.length; j++) { // j要比ｉ大，避免重複的值
                if (nums[i] + nums[j] == target) { // 找到答案
                    return new int[]{i, j}; // 找到答案回傳index
                }
            }
        }
        return new int[]{}; // 沒找到答案回傳空的
    }

    // time complexity O(n)  & space complexity O(n)
    public static int[] HashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int anotherNumber = target - nums[i]; // 計算一組中的另一個數字
            if (map.containsKey(anotherNumber)) { // 如果map裡包含另一個數字，代表找到答案
                return new int[]{map.get(anotherNumber), i}; // 找到答案回傳index
            }
            map.put(nums[i], i); // 如果map不包含另一個數字，將目前的數字和index存入map
        }
        return new int[]{}; // 沒找到答案回傳空的
    }
}
