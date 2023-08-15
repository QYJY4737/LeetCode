package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test232 {
    /**
     * 题目0232-最大子矩阵
     * 题目描述
     * 实现一个程序search_matrix(matrix)，参数matrix一是个仅包含 0 或 1 两种数字的矩阵，
     * 程序应返回输入矩阵中包含的最大正方形子矩阵(长和宽相等)的区域面积。
     * 例如:如果matrix是["1010111111","0000000111","1010110111","0000110001"]
     * 那么它看起来像下面的矩阵：
     * 1010111111
     * 0000000111
     * 1010110111
     * 0000110001
     * 对于上面的输入，最大的子矩阵是全部由 1 组成的一个 3×33 \times 33×3 的矩阵，
     * 程序只需要返回最大子矩阵的面积即可，如上面的矩阵即返回 9。
     *
     * 输入描述
     * 第一行输入为一个数字 NNN，代表下面有几行
     * 第二行到第 N−1N -1N−1 行是代表矩阵的 0 和 1 组成的字符串，每行的长度相同
     *
     * 输出描述
     * 返回一个数字，代表输入矩阵的最大正方形子距阵的面积
     *
     * 示例一
     * 输入
     * 3
     * 110
     * 111
     * 110
     * 输出
     * 4
     * 示例二
     * 输入
     * 8
     * 1010111111
     * 0000000111
     * 1010110111
     * 0000111111
     * 1010111111
     * 0000001111
     * 1010111111
     * 0000110001
     * 输出
     * 16
     * 说明
     * 可能存在多个子矩阵，返回面积最大的一个
     *
     * 示例三
     * 输入
     * 1
     * 1001111111
     * 输出
     * 1
     * 说明
     * 可以存在单行或者单列的矩阵（1×11 \times 11×1）
     *
     * 思路解析和复杂度分析
     * 解题思路解析：
     * 本题要求在一个由 0 和 1 组成的矩阵中寻找最大的全 1 正方形子矩阵，并返回其面积。为了解决这个问题，我们可以采用动态规划的方法。具体来说，我们可以创建一个与原矩阵尺寸相同的动态规划矩阵 dp。dp[i][j] 表示以 (i, j) 为右下角的正方形子矩阵的最大边长。这样，我们只需要找到 dp 矩阵中的最大值，然后将其平方即可得到所求的最大正方形子矩阵的面积。
     *
     * 动态规划矩阵的构建过程如下：
     *
     * 初始化 dp 矩阵。对于第一行和第一列的元素，直接将原矩阵中对应元素的值赋给 dp 矩阵，即 dp[i][j] = int(matrix[i][j])。
     * 遍历原矩阵中的其他元素。对于位置(i, j)，如果 matrix[i][j] 等于 1，我们需要更新 dp[i][j] 的值。更新方法是找到其左侧、上侧和左上侧的 dp 值中的最小值，然后加 1。即 dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1。如果 matrix[i][j] 等于 0，则 dp[i][j] = 0。
     * 在构建 dp 矩阵的过程中，记录 dp 矩阵的最大值，记为 max_size。最后返回 max_size 的平方作为答案。
     * 复杂度分析：
     * 时间复杂度：遍历原矩阵中的所有元素一次，时间复杂度为 O(N * M)，其中 N 和 M 分别表示矩阵的行数和列数。
     * 空间复杂度：创建了一个与原矩阵尺寸相同的 dp 矩阵，空间复杂度为 O(N * M)。
     * 通过动态规划的方法，我们可以在较短的时间内找到最大的全 1 正方形子矩阵并返回其面积。在实际编码过程中，需要注意边界条件，例如第一行和第一列的处理。此外，在动态规划矩阵构建过程中，需要实时更新最大值，以便在遍历结束后直接计算最大正方形子矩阵的面积。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] matrix = new String[n];
            for (int i = 0; i < n; i++) {
                matrix[i] = scanner.nextLine();
            }
            int maxArea = searchMatrix(matrix);
            System.out.println(maxArea);
        }
    }

    public static int searchMatrix(String[] matrix) {
        int n = matrix.length;
        int m = matrix[0].length();
        int[][] dp = new int[n][m];
        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i].charAt(j) == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
