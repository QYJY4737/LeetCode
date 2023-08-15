package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test218 {
    /**
     * 题目0218-区块链文件转储系统
     * 题目描述
     * 区块链底层存储是一个链式文件系统，由顺序的 NNN 个文件组成，每个文件的大小不一，依次为 F1,F2...FnF_1,F_2...F_nF
     * 1
     * ​
     * ,F
     * 2
     * ​
     * ...F
     * n
     * ​
     * 。随着时间的推移，所占存储会越来越大。
     * 云平台考虑将区块链按文件转储到廉价的SATA盘，只有连续的区块链文件才能转储到SATA盘上，且转储的文件之和不能超过SATA盘的容量。
     * 假设每块SATA盘容量为 MMM，求能转储的最大连续文件大小之和。
     * <p>
     * 输入描述
     * 第一行为SATA盘容量 M，1000≤M≤1000000M，1000 \leq M \leq 1000000M，1000≤M≤1000000
     * 第二行为区块链文件大小序列F1,F2...FnF_1,F_2...F_nF
     * 1
     * ​
     * ,F
     * 2
     * ​
     * ...F
     * n
     * ​
     * 。其中 1≤n≤100000，1≤Fi≤5001 \leq n \leq 100000， 1 \leq F_i \leq 5001≤n≤100000，1≤F
     * i
     * ​
     * ≤500
     * <p>
     * 输出描述
     * 求能转储的最大连续文件大小之和
     * <p>
     * 示例一
     * 输入
     * 1000
     * 100 300 500 400 400 150 100
     * 输出
     * 950
     * 说明
     * 最大序列和为950，序列为[400,400,150]
     * <p>
     * 示例二
     * 输入
     * 1000
     * 100 500 400 150 500 100
     * 输出
     * 1000
     * 说明
     * 最大序列和为1000，序列为[100,500,400]
     * <p>
     * 思路解析和复杂度分析
     * 题目要求我们找到最大连续文件大小之和，使得这个和不超过SATA盘的容量M。为了实现这个目标，我们可以遍历所有可能的连续文件序列，并计算这些序列的和，同时记录下最大的满足条件的和。
     * <p>
     * 解题思路如下：
     * <p>
     * 遍历所有可能的起始位置i（从0到n-1，其中n为区块链文件数量）。
     * 对于每一个起始位置i，从i开始遍历区块链文件序列，累加文件大小到一个变量current_sum中。
     * 如果累加过程中current_sum超过了SATA盘的容量M，停止遍历并继续下一个起始位置的检查。
     * 如果累加过程中current_sum没有超过SATA盘的容量M，且current_sum大于当前记录的最大和max_sum，更新max_sum为current_sum。
     * 遍历完所有起始位置后，max_sum即为最大连续文件大小之和。
     * 该算法的时间复杂度为O(n^2)，因为我们需要遍历每个起始位置，并检查从该位置开始的连续文件序列。在最坏情况下，我们需要检查n个起始位置，每个位置最多需要检查n个连续文件。因此，总的计算量为n * n，即O(n^2)。
     * <p>
     * 空间复杂度方面，我们只需要存储输入的文件大小序列，以及几个用于计算的变量（如max_sum和current_sum），因此空间复杂度为O(n)。
     * <p>
     * 虽然算法的时间复杂度较高，但由于题目限制了区块链文件数量n的上限（n<=100000），该算法在实际问题中应该能够在合理时间内找到解。在实际编程实现中，我们可以采用不同的编程语言，如C、C++、Python、JavaScript（Node.js）和Go等，按照上述思路编写相应的代码。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());
        Integer[] f =
                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        System.out.println(solution(m, f));
    }

    public static int solution(int m, Integer[] f) {
        int l = 0, r = 0;
        int sum = 0, max = 0;

        int n = f.length;

        while (r < n) {
            int newSum = sum + f[r];

            if (newSum > m) {
                sum -= f[l++];
            } else if (newSum < m) {
                sum += f[r++];
                max = Math.max(sum, max);
            } else {
                return m;
            }
        }

        return max;
    }
}
