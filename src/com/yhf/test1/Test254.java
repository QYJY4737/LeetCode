package com.yhf.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test254 {
    /**
     * 题目0254-求符合要求的结对方式
     * 题目描述
     * 用一个数组A代表程序员的工作能力，公司想通过结对编程的方式提高员工的能力，假设结对后的能力为两个员工的能力之和，求一共有多少种结对方式使结对后能力为N。
     * <p>
     * 输入描述
     * 5
     * 1 2 2 2 3
     * 4
     * 第一行为员工的总人数，取值范围[1,1000]
     * 第二行为数组 AAA 的元素，每个元素的取值范围[1,1000]
     * 第三行为 NNN 的值，取值范围[1,1000]
     * <p>
     * 输出描述
     * 4
     * 满足结对后能力为 NNN 的结对方式总数。
     * <p>
     * 示例一
     * 输入
     * 5
     * 1 2 2 2 3
     * 4
     * 输出
     * 4
     * 说明
     * 满足要求的结对方式为：A[0]和A[4]，A[1]和A[2]，A[1]和A[3]，A[2]和A[3]。
     * <p>
     * 思路解析和复杂度分析
     * 思路解析
     * 这道题目的关键是要找到所有两数之和为目标值 NNN 的配对。这种类型的问题通常使用哈希表（在 Java 中为 Map 结构）来解决，以便在常数时间内查找是否存在配对元素。
     * <p>
     * 我们使用一个 Map 存储每个元素出现的次数，键是元素的值，值是该元素出现的次数。
     * <p>
     * 然后，我们遍历数组，对于数组中的每个元素，我们都会检查 Map 中是否存在一个键，该键的值等于目标值 NNN 减去当前元素的值。如果存在这样的键，那么就找到了一个配对，我们把 Map 中这个键的值（也就是配对数量）累加到总的配对数中。
     * <p>
     * 最后，我们需要更新 Map 中当前元素的出现次数，如果该元素在 Map 中已经存在，则其值加一，否则添加该元素到 Map 中并设置其值为一。
     * <p>
     * 复杂度分析
     * 时间复杂度
     * 时间复杂度为 O(n)O(n)O(n)，其中 nnn 为数组的长度。这是因为我们只需要遍历一次数组，对于数组中的每个元素，我们只做常数时间的操作（检查和更新 Map）。
     * <p>
     * 空间复杂度
     * 空间复杂度为 O(n)O(n)O(n)，这是因为在最坏的情况下，数组中的每个元素都不同，我们需要在 Map 中存储所有的元素。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();

            int count = solution(arr, target);
            System.out.println(count);
        }

    }

    public static int solution(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            count += map.getOrDefault(target - num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
