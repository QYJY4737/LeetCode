package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test244 {
    /**
     * 题目0244-Linux发行版的数量
     * 题目描述
     * Linux 操作系统有多个发行版，distrowatch.com 提供了各个发行版的资料。这些发行版互相存在关联，例如 Ubuntu 基于Debian 开发，而 Mint 又基于 Ubuntu 开发，那么我们认为 Mint 同 Debian 也存在关联。
     * <p>
     * 发行版集是一个或多个相关存在关联的操作系统发行版，集合内不包含没有关联的发行版。
     * <p>
     * 给你一个 n * n 的矩阵 isConnected，
     * 其中 isConnected[i][j] = 1 表示第 i 个发行版和第 j 个发行版直接关联，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     * <p>
     * 返回最大的发行版集中发行版的数量。
     * <p>
     * 输入描述
     * 第一行输入发行版的总数量N，
     * <p>
     * 之后每行表示各发行版间是否直接相关
     * <p>
     * 输出描述
     * 输出最大的发行版集中发行版的数量
     * <p>
     * 备注
     * 1≤N≤2001 \leq N \leq 2001≤N≤200
     * <p>
     * 示例一
     * 输入
     * 4
     * 1 1 0 0
     * 1 1 1 0
     * 0 1 1 0
     * 0 0 0 1
     * 输出
     * 3
     * 说明
     * Debian(1) 和 Unbuntu(2) 相关
     * Mint(3) 和 Ubuntu(2) 相关，
     * EeulerOS(4) 和另外三个都不相关，
     * 所以存在两个发行版集，发行版集中发行版的数量分别是3和1，所以输出3。
     * <p>
     * 思路解析和复杂度分析
     * 这个问题是求图的连通分量中节点数最多的那个，也就是求图的最大连通子图的大小。我们可以用深度优先搜索(DFS)或者广度优先搜索(BFS)来解决。
     * <p>
     * 具体来说，我们首先遍历每一个节点，如果这个节点没有被访问过，那么我们就从这个节点出发，进行一次深度优先搜索或者广度优先搜索，每访问到一个节点，我们就把这个节点标记为已访问，同时计数器加1，然后再去访问所有与它直接相连并且还没有被访问过的节点。
     * <p>
     * 这样，当一次深度优先搜索或者广度优先搜索结束之后，我们就得到了一个连通子图，而计数器的值就是这个连通子图的大小。我们在所有连通子图的大小中取最大的就是我们要求的答案。
     * <p>
     * 时间复杂度上，我们需要遍历所有的节点和边，因此时间复杂度是O(n^2)，其中n是节点的数量。
     * <p>
     * 空间复杂度上，我们需要一个长度为n的数组来存储每个节点的访问状态，因此空间复杂度是O(n)。
     * <p>
     * 这种基于深度优先搜索或者广度优先搜索的算法很实用，因为它可以用于解决各种图的问题，比如求图的连通分量数量，求图的最大连通子图，检测图是否存在环等等。只要我们能够正确地构建出图，并且正确地实现深度优先搜索或者广度优先搜索，就可以很容易地解决这些问题。
     */

    private static final int MAX_N = 200;
    private static int[][] matrix = new int[MAX_N][MAX_N];
    private static int[] visited = new int[MAX_N];
    private static int N;

    private static void dfs(int i, int[] count) {
        visited[i] = 1;
        count[0]++;
        for (int j = 0; j < N; j++) {
            if (matrix[i][j] == 1 && visited[j] == 0) {
                dfs(j, count);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                int[] count = new int[1];
                dfs(i, count);
                res = Math.max(res, count[0]);
            }
        }

        System.out.println(res);
    }
}
