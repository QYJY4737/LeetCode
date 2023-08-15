package com.yhf.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test225 {
    /**
     * 题目0225-微服务的集成测试
     * 题目描述
     * 现在有 nnn 个容器服务，服务的启动可能有一定的依赖性（有些服务启动没有依赖），其次服务自身启动加载会消耗一些时间。
     * 给你一个 n×nn \times nn×n 的二维矩阵 useTime，其中 useTime[i][i]=10 表示服务 iii 自身启动加载需要消耗10s，useTime[i][j]=1 表示服务 iii 启动依赖服务 jjj 启动完成，useTime[i][k]=0，表示服务 iii 启动不依赖服务 kkk
     * 其实 0≤i，j，k<n0 \leq i，j，k < n0≤i，j，k<n。服务之间启动没有循环依赖（不会出现环），若想对任意一个服务i进行集成测试（服务i自身也需要加载），求最少需要等待多少时间。
     * <p>
     * 输入描述
     * 第一行输入服务总量 nnn，之后的 nnn 行表示服务启动的依赖关系以及自身启动加载耗时
     * 最后输入 kkk 表示计算需要等待多少时间后可以对服务 kkk 进行集成测试
     * 其中 1≤k≤n，1≤n≤1001 \leq k \leq n，1 \leq n \leq 1001≤k≤n，1≤n≤100
     * <p>
     * 输出描述
     * 最少需要等待多少时间(s)后可以对服务 kkk 进行集成测试
     * <p>
     * 示例一
     * 输入
     * 3
     * 5 0 0
     * 1 5 0
     * 0 1 5
     * 3
     * 输出
     * 15
     * 说明
     * 服务3启动依赖服务2，服务2启动依赖服务1，由于服务1,2,3自身加载需要消耗5s，所以5+5+5=15，需等待15s后可以对服务3进行集成测试
     * <p>
     * 示例二
     * 输入
     * 3
     * 5 0 0
     * 1 10 1
     * 1 0 11
     * 2
     * 输出
     * 26
     * 说明
     * 服务2启动依赖服务1和服务3，服务3启动需要依赖服务1，服务1,2,3自身加载需要消耗5s，10s，11s，所以5+10+11=26s，需等待26s后可以对服务2进行集成测试
     * <p>
     * 示例三
     * 输入
     * 4
     * 2 0 0 0
     * 0 3 0 0
     * 1 1 4 0
     * 1 1 1 5
     * 4
     * 输出
     * 12
     * 说明
     * 服务3启动依赖服务1和服务2，服务4启动需要依赖服务1,2,3，服务1,2,3,4自身加载需要消耗2s，3s，4s，5s,所以3+4+5=12s(因为服务1和服务2可以同时启动)，需等待12s后可以对服务4进行集成测试
     * <p>
     * 示例四
     * 输入
     * 5
     * 1 0 0 0 0
     * 0 2 0 0 0
     * 1 1 3 0 0
     * 1 1 0 4 0
     * 0 0 1 1 5
     * 5
     * 输出
     * 11
     * 说明
     * 服务3启动依赖服务1和服务2，服务4启动需要依赖服务1,2，服务5启动需要依赖服务3,5，服务1,2,3,4,5自身加载需要消耗1s，2s，3s，4s，5s,所以2+4+5=11s(因为服务1和服务2可以同时启动，服务3和服务4可以同时启动)，需等待11s后可以对服务5进行集成测试
     * <p>
     * 思路解析和复杂度分析
     * 解题思路：
     * 在这道题目中，我们需要计算对指定服务 k 进行集成测试所需的最少等待时间。我们需要考虑服务 k 以及它所依赖的服务的启动加载时间。
     * <p>
     * 首先，从输入中读取服务的总数量 n 和服务启动的依赖关系以及自身启动加载耗时，存储在一个二维数组或列表中（如 Python 的列表、JavaScript 的数组、Go 的切片等）。
     * 然后，读取需要测试的服务 k。
     * 初始化等待时间变量 waitingTime 为 0。
     * 将服务 k 转换为零基索引（k-1）。
     * 使用 while 循环遍历所有 k 的依赖关系。
     * a. 将服务 k 的启动加载时间累加到等待时间。
     * b. 遍历依赖关系，寻找 k 依赖的服务。如果找到，则将 k 设置为找到的依赖服务并跳出循环。如果没有找到依赖，将 k 设置为 -1 以终止循环。
     * 输出累计的等待时间。
     * 复杂度分析：
     * 时间复杂度：题目要求遍历所有服务的依赖关系，我们需要遍历矩阵中的每个元素。在最坏情况下，所有服务都相互依赖，因此，我们需要遍历整个矩阵。矩阵的大小是 n x n，所以时间复杂度为 O(n^2)。
     * 空间复杂度：我们使用了一个二维数组或列表来存储所有的服务启动依赖关系和自身启动加载耗时。因此，空间复杂度为 O(n^2)。
     * 总结：
     * 本题解法的核心思路是：遍历服务 k 及其所有依赖服务，累加这些服务的启动加载时间，得到最少等待时间。题目的解法具有线性时间复杂度和空间复杂度，对于最大输入规模 n=100，算法的性能是可以接受的。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int k = scanner.nextInt();
            System.out.println(solution(matrix, n, k));
        }

    }

    public static int solution(int[][] matrix, int n, int k) {
        HashMap<Integer, ArrayList<Integer>> pre = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                pre.putIfAbsent(i, new ArrayList<>());
                if (matrix[i][j] == 1) {
                    pre.get(i).add(j);
                }
            }
        }
        return dfs(k - 1, pre, matrix);
    }

    public static int dfs(int k, HashMap<Integer, ArrayList<Integer>> pre, int[][] matrix) {
        if (pre.get(k).size() == 0) {
            return matrix[k][k];
        }
        int maxPreTime = -1;
        for (Integer p : pre.get(k)) {
            maxPreTime = Math.max(maxPreTime, dfs(p, pre, matrix));
        }
        return matrix[k][k] + maxPreTime;
    }
}
