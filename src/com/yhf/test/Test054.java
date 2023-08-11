package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test054 {
    /**
     * 题目0054-最优调度策略
     * 题目描述
     * 在通信系统中有一个常见的问题是对用户进行不同策略的调度
     * 会得到不同系统消耗的性能
     * 假设由N个待串行用户，每个用户可以使用A/B/C三种不同的调度策略
     * 不同的策略会消耗不同的系统资源
     * 请你根据如下规则进行用户调度
     * 并返回总的消耗资源数
     * 规则是：相邻的用户不能使用相同的调度策略
     * 例如：
     * 第一个用户使用A策略 则第二个用户只能使用B和C策略
     * 对单的用户而言，不同的调度策略对系统资源的消耗可以规划后抽象为数值
     * 例如
     * 某用户分别使用ABC策略的系统消耗，分别为15 8 17
     * 每个用户依次选择当前所能选择的对系统资源消耗最少的策略,局部最优
     * 如果有多个满足要求的策略，选最后一个
     * <p>
     * 输入描述
     * 第一行表示用户个数N
     * 接下来表示每一行表示一个用户分别使用三个策略的资源消耗
     * resA resB resC
     * <p>
     * 输出描述
     * 最优策略组合下的总的系统消耗资源数
     * <p>
     * 示例一
     * 输入
     * 3
     * 15 8 17
     * 12 20 9
     * 11 7 5
     * 输出
     * 24
     * 说明
     * 1号用户使用B策略
     * 2号用户使用C策略
     * 3号用户使用B策略
     * 系统资源消耗8+9+7
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            List<Map<Integer, Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> map = new TreeMap<>();
                for (int j = 0; j < 3; j++) {
                    map.put(scanner.nextInt(), j);
                }
                res.add(map);
            }
            solution(res);
        }
    }

    private static void solution(List<Map<Integer, Integer>> res) {
        Integer res1 = new ArrayList<>(res.get(0).keySet()).get(0);
        int sum = res1;
        Integer type = res.get(0).get(res1);
        if (res.size() > 1) {
            for (int i = 1; i < res.size(); i++) {
                List<Integer> keyList = new ArrayList<>(res.get(i).keySet());
                Integer resN = keyList.get(0);
                Integer typeN = res.get(i).get(resN);
                if (!typeN.equals(type)) {
                    sum += resN;
                    type = typeN;
                } else {
                    sum += keyList.get(1);
                    type = res.get(i).get(keyList.get(1));
                }
            }
        }
        System.out.print(sum);
    }
}
