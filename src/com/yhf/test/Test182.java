package com.yhf.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test182 {
    /**
     * 题目0182-打印机队列
     * 题目描述
     * 有5台打印机打印文件，每台打印机有自己的待打印队列。
     * 因为打印的文件内容有轻重缓急之分，所以队列中的文件有1~10不同的优先级，其中数字越大优先级越高。
     * 打印机会从自己的待打印队列中选择优先级最高的文件来打印。
     * 如果存在两个优先级一样的文件，则选择最早进入队列的那个文件。
     * 现在请你来模拟这5台打印机的打印过程。
     * <p>
     * 输入描述
     * 每个输入包含1个测试用例，每个测试用例第1行给出发生事件的数量 N(0<N<1000)N (0 < N < 1000)N(0<N<1000)。
     * 接下来有 NNN 行，分别表示发生的事件。
     * 共有如下两种事件：
     * <p>
     * IN P NUM，表示有一个拥有优先级 NUM 的文件放到了打印机 P 的待打印队列中。(0<P≤5,0<NUM≤10)(0 < P \leq 5, 0 < NUM \leq 10)(0<P≤5,0<NUM≤10)；
     * OUT P，表示打印机 P 进行了一次文件打印，同时该文件从待打印队列中取出。(0<P≤5)(0 < P \leq 5)(0<P≤5)。
     * 输出描述
     * 对于每个测试用例，每次OUT P事件，请在一行中输出文件的编号。
     * 如果此时没有文件可以打印，请输出NULL。
     * 文件的编号定义为：IN P NUM事件发生第 X 次，此处待打印文件的编号为 X。编号从1开始。
     * <p>
     * 示例一
     * 输入
     * 7
     * IN 1 1
     * IN 1 2
     * IN 1 3
     * IN 2 1
     * OUT 1
     * OUT 2
     * OUT 2
     * 输出
     * 3
     * 4
     * NULL
     * 示例二
     * 输入
     * 5
     * IN 1 1
     * IN 1 3
     * IN 1 1
     * IN 1 3
     * OUT 1
     * 输出
     * 2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] jobs = new String[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = scanner.nextLine();
            }
            solution(jobs);
        }
    }

    private static void solution(String[] jobs) {
        HashMap<String, List<int[]>> printers = new HashMap<>();
        for (int i = 0; i < jobs.length; i++) {
            String[] split = jobs[i].split(" ");
            String op = split[0];
            String num = split[1];
            if (op.equals("IN")) {
                int p = Integer.parseInt(split[2]);
                in(printers, num, i + 1, p);
            } else {
                String res = out(printers, num);
                System.out.println(res);
            }
        }
    }

    private static String out(HashMap<String, List<int[]>> printers, String num) {
        String res = "NULL";
        if (!printers.containsKey(num)) {
            return res;
        }
        List<int[]> jobList = printers.get(num);
        if (jobList.size() == 0) {
            return res;
        }
        jobList.sort((o1, o2) -> o2[1] - o1[1]);
        int seq = jobList.get(0)[0];
        jobList.remove(0);
        return seq + "";
    }

    private static void in(HashMap<String, List<int[]>> printers, String num, int seq, int p) {
        if (!printers.containsKey(num)) {
            printers.put(num, new ArrayList<>());
        }
        List<int[]> jobList = printers.get(num);
        jobList.add(new int[]{seq, p});
    }
}
