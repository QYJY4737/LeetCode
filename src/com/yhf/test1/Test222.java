package com.yhf.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test222 {
    /**
     * 题目0222-快速开租建站
     * 题目描述
     * 当前IT部门支撑了子公司颗粒化业务，该部门需要实现为子公司快速开租建站的能力，建站是指在一个全新的环境部署一套IT服务。
     * 每个站点开站会由一系列部署任务项构成，每个任务项部署完成时间都是固定和相等的，设为1。部署任务项之间可能存在依赖，假如任务2依赖任务1，那么等任务1部署完，任务2才能部署。
     * 任务有多个依赖任务则需要等所有依赖任务都部署完该任务才能部署。没有依赖的任务可以并行部署，优秀的员工们会做到完全并行无等待的部署。
     * 给定一个站点部署任务项和它们之间的依赖关系，请给出一个站点的最短开站时间。
     * <p>
     * 输入描述
     * 第一行是任务数taskNum,第二行是任务的依赖关系数relationsNum
     * <p>
     * 接下来 relationsNum 行，每行包含两个id，描述一个依赖关系，格式为：IDi IDj，表示部署任务i部署完成了，部署任务j才能部署，IDi 和 IDj 值的范围为：[0, taskNum)
     * <p>
     * 注：输入保证部署任务之间的依赖不会存在环。
     * <p>
     * 输出描述
     * 一个整数，表示一个站点的最短开站时间。
     * <p>
     * 备注
     * 1<taskNum≤1001 < taskNum \leq 1001<taskNum≤100
     * <p>
     * 1≤relationsNum≤50001 \leq relationsNum \leq 50001≤relationsNum≤5000
     * <p>
     * 示例一
     * 输入
     * 5
     * 5
     * 0 4
     * 1 2
     * 1 3
     * 2 3
     * 2 4
     * 输出
     * 3
     * 说明
     * 有5个部署任务项，5个依赖关系，如下图所示。我们可以先同时部署任务项0和任务项1，然后部署任务项2，最后同时部署任务项3和任务项4。最短开站时间为3。
     * main0222-1.png
     * <p>
     * 示例二
     * 输入
     * 5
     * 3
     * 0 3
     * 0 4
     * 1 3
     * 输出
     * 2
     * 说明
     * 有5个部署任务项，3个依赖关系，如下图所示。我们可以先同时部署任务项0，任务项1，任务项2。然后再同时部署任务项3和任务项4。最短开站时间为2。
     * main0222-2.png
     * <p>
     * 思路解析和复杂度分析
     * 解题思路：
     * 这道题目的要求是给定一组任务及其依赖关系，找出完成所有任务的最短时间。可以使用拓扑排序算法来解决此问题。
     * <p>
     * 首先，将任务之间的依赖关系表示为有向图。节点表示任务，有向边表示依赖关系。我们需要计算每个任务的入度，即有多少任务依赖于它。同时，我们可以用一个数组存储每个任务的相邻任务（即该任务完成后需要完成的任务）。
     * 然后，将入度为0的任务加入一个队列。这些任务是可以立即开始的任务，因为没有其他任务依赖于它们。
     * 当队列非空时，执行以下操作：
     * a. 获取队列中当前任务的数量，这些任务可以并行执行。
     * b. 更新当前时间。由于所有任务的执行时间都是1，因此每次迭代都会使时间加1。
     * c. 对于队列中的每个任务，遍历其相邻任务，并减小它们的入度。如果相邻任务的入度变为0，说明其所有依赖任务已经完成，将其加入队列以便在下一轮迭代中执行。
     * 当队列为空时，算法结束。返回累计的时间作为完成所有任务的最短时间。
     * 复杂度分析：
     * 时间复杂度：拓扑排序算法的时间复杂度为O(V+E)，其中V表示任务数量，E表示依赖关系数量。在此问题中，V = taskNum，E = relationsNum。因此，时间复杂度为O(taskNum + relationsNum)。
     * 空间复杂度：我们需要存储任务的依赖关系（有向图）以及每个任务的入度。因此，空间复杂度为O(taskNum + relationsNum)。
     * 在本题中，由于任务数量和依赖关系数量均有上限（taskNum <= 100，relationsNum <= 5000），所以该算法在实际应用中的时间和空间复杂度都是可接受的。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int taskNum = scanner.nextInt();
        int relationsNum = scanner.nextInt();

        int[][] relations = new int[relationsNum][2];
        for (int i = 0; i < relationsNum; i++) {
            relations[i][0] = scanner.nextInt();
            relations[i][1] = scanner.nextInt();
        }

        System.out.println(solution(relations, taskNum));
    }

    public static int solution(int[][] relations, int taskNum) {
        HashMap<Integer, ArrayList<Integer>> next = new HashMap<>();
        int[] inDegree = new int[taskNum];

        for (int[] relation : relations) {
            int a = relation[0];
            int b = relation[1];

            next.putIfAbsent(a, new ArrayList<>());
            next.get(a).add(b);
            inDegree[b]++;
        }

        LinkedList<Integer[]> queue = new LinkedList<>();
        int t = 1;

        for (int i = 0; i < taskNum; i++) {
            if (inDegree[i] == 0) {
                queue.add(new Integer[]{i, t});
            }
        }

        while (queue.size() > 0) {
            Integer[] tmp = queue.removeFirst();
            int task = tmp[0];
            int time = tmp[1];

            if (next.containsKey(task) && next.get(task).size() > 0) {
                for (Integer nxt : next.get(task)) {
                    if (--inDegree[nxt] == 0) {
                        t = time + 1;
                        queue.add(new Integer[]{nxt, t});
                    }
                }
            }
        }

        return t;
    }
}
