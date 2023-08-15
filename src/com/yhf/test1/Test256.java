package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test256 {
    /**
     * 题目0256-补种未成活胡杨
     * 题目描述
     * 近些年来，我国防沙治沙取得显著成果。某沙漠新种植 NNN 棵胡杨（编号 111-NNN ），排成一排。
     * <p>
     * 一个月后，有 MMM 棵胡杨未能成活。
     * <p>
     * 现可补种胡杨 KKK 棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？
     * <p>
     * 输入描述
     * NNN 总种植数量，1≤N≤1000001 \leq N \leq 1000001≤N≤100000
     * <p>
     * MMM 未成活胡杨数量
     * <p>
     * MMM 个空格分隔的数，按编号从小到大排列，1≤M≤N1 \leq M \leq N1≤M≤N
     * <p>
     * KKK 最多可以补种的数量，0≤K≤M0 \leq K \leq M0≤K≤M
     * <p>
     * 输出描述
     * 最多的连续胡杨棵树
     * <p>
     * 示例一
     * 输入
     * 5
     * 2
     * 2 4
     * 1
     * 输出
     * 3
     * 说明
     * 补种到2或4结果一样，最多的连续胡杨棵树都是3。
     * <p>
     * 示例二
     * 输入
     * 10
     * 3
     * 2 4 7
     * 1
     * 输出
     * 6
     * 说明
     * 补种第7棵树，最多连续胡杨树棵数位6（5，6，7，8，9，10）
     * <p>
     * 思路解析和复杂度分析
     * 题解思路：
     * 首先，我们需要找出最长的连续胡杨树范围，这个范围可以通过计算两棵未成活胡杨树之间的距离得到。在得到这个距离之后，我们可以根据补种的数量进行判断。如果补种的数量足够将整个范围的未成活胡杨树都补上，那么最长连续胡杨树范围就是该距离。否则，我们可以将所有可补种的胡杨树全部补上，最长连续胡杨树范围就是原来的距离减去未补种的胡杨树数量。
     * <p>
     * 考虑到我们还需要处理数组两端的情况，所以在实现上需要将补种的情况分成三种来处理：
     * <p>
     * 在最左边：补种的是索引为0的树。
     * 在最右边：补种的是索引为m-k的树。
     * 在中间：补种的是索引为i的树。
     * 算法的复杂度分析：
     * 此算法的时间复杂度是O(m)，其中m是未成活胡杨树的数量。这是因为我们只需要遍历一次未成活胡杨树数组，所以时间复杂度为线性级别。
     * <p>
     * 空间复杂度是O(m)，我们使用一个数组来存储所有的未成活胡杨树，所以空间复杂度也是线性级别的。
     * <p>
     * 虽然这个算法看起来复杂度较高，但由于N和M的取值范围有限，该算法在实际应用中的性能是可接受的。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[] indies = new int[M];
            for (int i = 0; i < M; i++) {
                indies[i] = scanner.nextInt();
            }

            int K = scanner.nextInt();
            System.out.println(solution(N, M, indies, K));
        }

    }

    public static int solution(int n, int m, int[] indies, int k) {
        int maxLen = 0;

        for (int i = 0; i <= m - k; i++) {
            if (i == 0) {
                maxLen = Math.max(maxLen, indies[i + k] - 1);
            } else if (i == m - k) {
                maxLen = Math.max(maxLen, n - indies[i - 1]);
            } else {
                maxLen = Math.max(maxLen, indies[i + k] - indies[i - 1] - 1);
            }
        }
        return maxLen;
    }
}
