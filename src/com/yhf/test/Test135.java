package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test135 {
    /**
     * 题目0135-最小传递延迟
     * 题目描述
     * 通讯网络中有N个网络节点
     * 用1 ~ N进行标识
     * 网络通过一个有向无环图进行表示
     * 其中图的边的值，表示节点之间的消息传递延迟
     * 现给定相连节点之间的延时列表times[i]={u,v,w}
     * 其中u表示源节点，v表示目的节点，w表示u和v之间的消息传递延时
     * 请计算给定源节点到目的节点的最小传递延迟
     * 如果目的节点不可达请返回-1
     * 注意：N的取值范围是1 ~ 100
     * 延迟times列表长度不超过6000
     * 且1 <= u,v <= N,0 <= w <= 100
     *
     * 输入描述
     * 输入第一行为两个正整数，分别为网络节点个数N以及延时列表长度M，用空格分隔
     * 接下来的M行为两个节点间的延时列表[u,v,w]
     * 输入的最后一行为两个正整数u和v分别表示源节点和目的节点
     *
     * 输出描述
     * 输出一个整数表示源节点到目的节点的最小延时
     *
     * 示例一
     * 输入
     * 3 3
     * 1 2 11
     * 2 3 13
     * 1 3 50
     * 1 3
     * 输出
     * 24
     * 说明
     * 1~3的延时是50，1~2~3的延时是11+13=24
     * 所以1~3的最小延时就是24
     */

    static int res = Integer.MAX_VALUE;
    static int tmp = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] split = scanner.nextLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            String[] times = new String[M];
            for (int i = 0; i < M; i++) {
                times[i] = scanner.nextLine();
            }

            String lastLine = scanner.nextLine();
            solution(N, times, lastLine);

        }
    }

    private static void solution(int n, String[] times, String lastLine) {
        Map<Integer, Map<Integer, Integer>> dag = new TreeMap<>();
        // 初始化有向图元素
        for (int i = 1; i <= n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            dag.put(i, map);
        }

        // 建立关联
        for (String time : times) {
            String[] split = time.split(" ");
            int u = Integer.parseInt(split[0]);
            int v = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);
            dag.get(u).put(v, w);
        }

        // 计算延时


        String[] split = lastLine.split(" ");
        int u = Integer.parseInt(split[0]);
        int v = Integer.parseInt(split[1]);
        find(dag, u, v);

        if (res == Integer.MAX_VALUE) {
            res = -1;
        }

        System.out.println(res);

    }


    private static void find(Map<Integer, Map<Integer, Integer>> dag, int u, int v) {

        Map<Integer, Integer> routes = dag.get(u);
        for (Integer key : routes.keySet()) {
            if (key == v) {
                tmp += routes.get(key);
                if (tmp != 0) {
                    res = Math.min(res, tmp);
                }
                tmp = 0;
            } else {
                tmp += routes.get(key);
                find(dag, key, v);
            }
        }
    }
}
