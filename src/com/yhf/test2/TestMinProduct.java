package com.yhf.test2;

import java.util.HashMap;

/**
 * Created on 2023/8/22.
 *
 * @author qyjy4737
 */
public class TestMinProduct {

    public static int[] findNumberPair(int[] arr, int targetSum) {
        HashMap<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : arr) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[2];
        int minProduct = Integer.MAX_VALUE;

        for (int num : arr) {
            int target = targetSum - num;
            if (numCountMap.containsKey(target)) {
                if ((target != num && numCountMap.get(target) >= 1) || (num == target && numCountMap.get(target) >= 2)) {
                    if (num * target < minProduct) {
                        minProduct = num * target;
                        result[0] = num;
                        result[1] = target;
                    }
                }
            }
        }
        if (minProduct == Integer.MAX_VALUE) {
            // 没有找到符合条件的数字对，返回空数组
            return new int[0];
        } else {
            // 返回找到的数字对
            return result;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 9};
        int targetSum = 9;
        int[] result = findNumberPair(arr, targetSum);
        if (result.length == 2) {
            System.out.println("找到的数字对为：" + result[0] + " 和 " + result[1]);
        } else {
            System.out.println("未找到符合条件的数字对");
        }
    }
}
