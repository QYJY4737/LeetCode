package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test224 {
    /**
     * 题目0224-光伏场地建设规划
     * 题目描述
     * 祖国西北部有一片大片荒地，其中零星的分布着一些湖泊，保护区，矿区；整体上常年光照良好，但是也有一些地区光照不太好。某电力公司希望在这里建设多个光伏电站，生产清洁能源。对每平方公里的土地进行了发电评估，其中不能建设的区域发电量为0kw，可以发电的区域根据光照，地形等给出了每平方公里年发电量x千瓦。我们希望能够找到其中集中的矩形区域建设电站，能够获得良好的收益。
     * <p>
     * 输入描述
     * 第一行输入为调研的地区长，宽，以及准备建设的电站【长宽相等，为正方形】的边长，最低要求的发电量
     * 之后每行为调研区域每平方公里的发电量
     * 例如，输入为：
     * 2 5 2 6
     * 1 3 4 5 8
     * 2 3 6 7 1
     * 表示调研的区域大小为长2宽5的矩形，我们要建设的电站的边长为2，建设电站最低发电量为6
     * <p>
     * 输出描述
     * 输出为这样的区域有多少个
     * 上述输入长宽为2的正方形满足发电量大于等于6的区域有4个。
     * 则输出为：
     * 4
     * <p>
     * 备注
     * 其中 被调研的区域的长宽均大于等于1，建设电站的边长大于等于1，任何区域的发电量大于等于0
     * <p>
     * 示例一
     * 输入
     * 2 5 2 6
     * 1 3 4 5 8
     * 2 3 6 7 1
     * 输出
     * 4
     * 说明
     * 输入长为2，宽为5的场地，建设的场地为正方形场地，边长为2，要求场地的发电量大于等于6
     * <p>
     * 示例二
     * 输入
     * 2 5 1 6
     * 1 3 4 5 8
     * 2 3 6 7 1
     * 输出
     * 3
     * 说明
     * 输入长为2，宽为5的场地，建设的场地为正方形场地，边长为1，要求场地的发电量大于等于6
     * <p>
     * 示例三
     * 输入
     * 2 5 1 0
     * 1 3 4 5 8
     * 2 3 6 7 1
     * 输出
     * 10
     * 说明
     * 输入长为2，宽为5的场地，建设的场地为正方形场地，边长为1，要求场地的发电量大于等于0即可
     * <p>
     * 思路解析和复杂度分析
     * 解题思路：
     * 这道题目的关键是在给定的区域内找到满足条件的矩形区域。我们需要在给定的长宽范围内遍历所有可能的矩形区域，然后计算每个矩形区域内所有元素的和，判断是否大于等于最低发电量。
     * <p>
     * 以下是解题步骤：
     * <p>
     * 首先读取输入，包括长宽、准备建设的电站边长和最低发电量等信息。
     * 定义一个二维数组 area 来存储调研区域每平方公里的发电量。
     * 根据输入的长宽，遍历调研区域，并将每个点的发电量存入 area 二维数组。
     * 初始化一个计数变量 count 用于计算满足条件的矩形区域数量。
     * 使用两层嵌套循环遍历所有可能的矩形区域。对于每个矩形区域，再使用两层嵌套循环计算矩形区域内所有元素的和，判断是否大于等于最低发电量。如果满足条件，则将 count 加一。
     * 最后输出 count，即满足条件的矩形区域数量。
     * 复杂度分析：
     * 由于采用了四层嵌套循环，时间复杂度为 O(n^4)，其中 n 是调研区域的长度或宽度。空间复杂度为 O(n^2)，因为需要使用二维数组 area 存储调研区域的发电量。
     * <p>
     * 这种暴力遍历的方法在 n 较小的情况下可以解决问题，但在较大规模问题上可能会导致运行时间过长。实际工程中可以考虑使用更优化的算法，如动态规划或其他方法，降低时间复杂度。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            int r = scanner.nextInt();
            int c = scanner.nextInt();

            int s = scanner.nextInt();
            int min = scanner.nextInt();

            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println(solution(matrix, r, c, s, min));
        }

    }


    public static int solution(int[][] matrix, int r, int c, int s, int min) {
        int zip_r = r - s + 1;
        int zip_c = c - s + 1;

        int[][] zip_col_dps = new int[r][zip_c];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < s; j++) {
                zip_col_dps[i][0] += row[i];
            }

            for (int j = 1; j < zip_c; j++) {
                zip_col_dps[i][j] = zip_col_dps[i][j - 1] - row[j - 1] + row[j + s - 1];
            }
        }

        matrix = zip_col_dps;

        int res = 0;

        int[][] zip_col_row_dps = new int[zip_r][zip_c];

        for (int j = 0; j < zip_c; j++) {
            for (int i = 0; i < s; i++) {
                zip_col_row_dps[0][j] += matrix[i][j];
            }
            if (zip_col_row_dps[0][j] >= min) res++;

            for (int i = 1; i < zip_r; i++) {
                zip_col_row_dps[i][j] = zip_col_row_dps[i - 1][j] - matrix[i - 1][j] + matrix[i + s - 1][j];
                if (zip_col_row_dps[i][j] >= min) res++;
            }
        }

        return res;
    }
}
