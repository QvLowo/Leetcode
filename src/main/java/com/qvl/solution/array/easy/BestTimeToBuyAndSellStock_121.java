package com.qvl.solution.array.easy;

/**
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 給定一個陣列 prices，其中 prices[i] 代表某支股票在第 i 天的價格。
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 你的目標是選擇某一天買入股票，並在未來的某一天賣出股票，以獲得最大的利潤。
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 請回傳你可以從這筆交易中獲得的最大利潤。如果無法獲得任何利潤，請回傳 0。
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 * 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you
 * must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */

public class BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = maxProfit(prices);
        System.out.println("output: " + result);
    }

    // 貪心演算法 Greedy Algorithm
    // time complexity O(n) & space complexity O(1)
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0]; // 設定初始買入價格為第一天的價格
        int maxProfit = 0; // 設定初始最大利潤為 0
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // 更新最低買入價格
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice; // 更新最大利潤
            }
        }
        return maxProfit; // 回傳最大利潤
    }
}
