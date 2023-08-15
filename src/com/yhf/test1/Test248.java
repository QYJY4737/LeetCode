package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test248 {
    /**
     * 题目0248-求最小步数
     * 题目描述
     * 求从坐标零点到坐标n的最小步数，一次只能沿横坐标轴向左或向右移动2或3。
     * 注意：途经的坐标可以为负数。
     *
     * 输入描述
     * 坐标点n
     *
     * 输出描述
     * 输出从坐标零点移动到坐标n的移动步数。
     *
     * 示例一
     * 输入
     * 4
     * 输出
     * 2
     * 说明
     * 从坐标零点移动到4，最小需要两步，即向右移2步，再向右移2步
     *
     * 备注
     * 1≤n≤1091 \leq n \leq 10^91≤n≤10
     * 9
     *
     *
     * 思路解析和复杂度分析
     * 思路解析
     * 这个问题是一个典型的动态规划问题，主要解决的是如何从0点到达n点的最小步数。每次移动只能是2步或3步，且可以向左或向右移动。虽然可以向左移动，但从0点开始，向右移动到达任何非负整数点n总是更快的，所以我们的目标是寻找最小步数来到达非负整数n。
     *
     * 动态规划的核心思想是利用历史记录来避免未来的重复计算，从而提高计算效率。在这个问题中，我们创建了一个名为dp的数组，其中dp[i]存储的是到达点i的最小步数。然后，对于每个位置i，我们都查看从当前位置移动2步或3步后的位置，并更新那些位置的最小步数。具体来说，如果dp[i]（当前位置的最小步数）+1小于dp[i+2]或dp[i+3]（即移动2步或3步后的位置的最小步数），我们就用dp[i]+1来更新dp[i+2]或dp[i+3]。
     *
     * 初始情况是，dp[0] = 0，即到达0点需要0步。如果n大于等于2，dp[2] = 1，即到达2点需要1步。如果n大于等于3，dp[3] = 1，即到达3点需要1步。
     *
     * 我们需要注意的是，初始情况下，除了dp[0]、dp[2]和dp[3]，其它的dp[i]都被设为无穷大，表示我们还没有找到到达那些位置的有效步数。
     *
     * 最后，dp[n]就是到达n点的最小步数。
     *
     * 复杂度分析
     * 时间复杂度：O(n)，因为我们需要遍历一次长度为n的数组。
     *
     * 空间复杂度：O(n)，因为我们创建了一个长度为n的数组来存储到达每个位置的最小步数。
     *
     * 这个动态规划解决方案是非常高效的，因为我们只需要线性的时间和空间，就可以找到从0点到n点的最小步数。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(minSteps(n));
        }
    }

    public static int minSteps(int n) {
        if (n < 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 1;
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                if (i + 2 <= n) {
                    dp[i + 2] = Math.min(dp[i + 2], dp[i] + 1);
                }
                if (i + 3 <= n) {
                    dp[i + 3] = Math.min(dp[i + 3], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }
}
