package com.yhf.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test174 {
    /**
     * 题目0174-预订酒店
     * 题目描述
     * 放暑假了，小明决定到某旅游景点游玩，他在网上搜索到了各种价位的酒店（长度为n的数组A），他的心理价位是x元，请帮他筛选出k个最接近x元的酒店（n>=k>0）,并由低到高打印酒店的价格。
     * <p>
     * 输入描述
     * 第一行：n, k, x
     * 第二行：A[0] A[1] A[2]...A[n-1]
     * <p>
     * 输出描述
     * 从低到高打印筛选出的酒店价格
     * <p>
     * 示例一
     * 输入
     * 10 5 6
     * 1 2 3 4 5 6 7 8 9 10
     * 输出
     * 4 5 6 7 8
     * 示例二
     * 输入
     * 10 4 6
     * 10 9 8 7 6 5 4 3 2 1
     * 输出
     * 4 5 6 7
     * 说明
     * 数组长度n = 10，筛选个数k = 4，目标价位x = 6
     * 当4和8距离x相同时，优先选择价格低的4
     * <p>
     * 示例三
     * 输入
     * 6 3 1000
     * 30 30 200 500 70 300
     * 输出
     * 200 300 500
     * 备注
     * 酒店价格数组A和小明的心理价位x均为整型数据；(0<n,k,x<10000)
     * 优先选择价格最接近心理价位的酒店，若两家酒店和心理价位差价相同，则选择价格较低的酒店。（比如100元和300元距离心理价位200元同样接近，此时选择100元）
     * 酒店价格可能相同重复
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = scanner.nextInt();
            }
            solution(prices, n, k, x);
        }
    }

    private static void solution(int[] prices, int n, int k, int x) {
        Arrays.sort(prices);
        int[][] price_rating = new int[n][2];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            price_rating[i][0] = price;
            price_rating[i][1] = Math.abs(price - x);
        }

        List<int[]> sorted = Arrays.stream(price_rating).sorted(Comparator.comparingInt(h -> h[1]))
                .collect(Collectors.toList());

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(sorted.get(i)[0]);
        }

        res.sort(Integer::compareTo);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
