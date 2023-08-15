package com.yhf.test1;

import java.util.*;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test255 {
    /**
     * 题目0255-最小传输时延
     * 题目描述
     * 某通信网络中有 NNN 个网络结点，用 111 到 NNN 进行标识。网络通过一个有向无环图表示，其中图的边的值表示结点之间的消息传递时延。
     * <p>
     * 现给定相连节点之间的时延列表 times[i]={u，v，w}，其中u表示源结点，v表示目的结点，w表示u和v之间的消息传递时延。
     * <p>
     * 请计算给定源结点到目的结点的最小传输时延，如果目的结点不可达，返回-1。
     * <p>
     * 备注
     * NNN 的取值范围为 [1，100];
     * 时延列表 timestimestimes 的长度不超过 600060006000，且 1≤u,v≤N，0≤w≤1001 \leq u,v \leq N，0 \leq w \leq 1001≤u,v≤N，0≤w≤100;
     * <p>
     * 输入描述
     * 输入的第一行为两个正整数，分别表示网络结点的个数 NNN，以及时延列表的长度 MMM，用空格分隔；
     * 接下来的 MMM 行为两个结点间的时延列表[u v w];
     * 输入的最后一行为两个正整数，分别表示源结点和目的结点。
     * <p>
     * 1
     * 2
     * 3
     * 11
     * 13
     * 50
     * 输出描述
     * 起点到终点得最小时延，不可达则返回-1。
     * <p>
     * 示例一
     * 输入
     * 3 3
     * 1 2 11
     * 2 3 13
     * 1 3 50
     * 1 3
     * 输出
     * 24
     * 思路解析和复杂度分析
     * 思路解析
     * 这是一个非常经典的最短路径问题，最适合应用的算法就是 Dijkstra 算法。Dijkstra 算法是一种使用广度优先搜索策略寻找单源最短路径的算法。
     * <p>
     * 首先，我们将所有的节点与其相邻节点的信息记录在图(graph)中，以备后续使用。然后，我们使用一个优先队列（heap）来储存到达每个节点的当前最短路径长度。在每次迭代中，我们都从队列中取出距离最短的节点，然后尝试更新它的相邻节点到源节点的距离。如果找到了更短的路径，我们就更新这个距离，并且将相邻节点放入优先队列中。
     * <p>
     * 这个过程一直持续到我们遍历了所有的节点，或者我们找到了到达目标节点的最短路径。最后，我们返回从源节点到目标节点的最短路径长度。
     * <p>
     * 复杂度分析
     * 时间复杂度
     * Dijkstra 算法的时间复杂度是 O((V+E)logV)，其中 V 是节点数，E 是边数。这是因为每个节点和每条边都会被遍历一次，而在优先队列中插入元素的时间复杂度是 O(logV)。
     * <p>
     * 空间复杂度
     * 空间复杂度主要来自于储存图的空间，以及优先队列所占用的空间，所以空间复杂度为 O(V+E)。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            List<List<int[]>> graph = new ArrayList<>(N + 1);
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                graph.get(u).add(new int[]{v, w});
            }

            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int result = dijkstra(graph, source, target, N);
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        }

    }

    private static int dijkstra(List<List<int[]>> graph, int source, int target, int N) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.offer(new int[]{source, 0});
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int node = current[0];
            int dis = current[1];

            if (node == target) return dis;
            if (visited[node]) continue;

            visited[node] = true;
            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int nextDis = edge[1] + dis;

                if (nextDis < distance[next]) {
                    distance[next] = nextDis;
                    heap.offer(new int[]{next, nextDis});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
