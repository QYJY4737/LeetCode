package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test194 {
    /**
     * 题目0194-静态代码扫描服务
     * 题目描述
     * 静态扫描快速识别源代码的缺陷，静态扫描的结果以扫描报告作为输出：
     * <p>
     * 文件扫描的成本和文件大小相关，如果文件大小为 NNN ，则扫描成本为 NNN 个金币
     * 扫描报告的缓存成本和文件大小无关，每缓存一个报告需要 MMM 个金币
     * 扫描报告缓存后，后继再碰到该文件则不需要扫描成本，直接获取缓存结果
     * 给出源代码文件标识序列和文件大小序列，求解采用合理的缓存策略，最少需要的金币数。
     * <p>
     * 输入描述
     * 第一行为缓存一个报告金币数 M,1≤M≤100M,1 \leq M \leq 100M,1≤M≤100
     * 第二行为文件标识序列：F1,F2,F3...FnF_1,F_2,F_3...F_nF
     * 1
     * ​
     * ,F
     * 2
     * ​
     * ,F
     * 3
     * ​
     * ...F
     * n
     * ​
     * ，其中 1≤N≤10000,1≤Fi≤10001 \leq N \leq 10000 , 1 \leq F_i \leq 10001≤N≤10000,1≤F
     * i
     * ​
     * ≤1000
     * 第二行为文件大小序列：S1,S2,S3...SnS_1,S_2,S_3...S_nS
     * 1
     * ​
     * ,S
     * 2
     * ​
     * ,S
     * 3
     * ​
     * ...S
     * n
     * ​
     * ，其中 1≤N≤10000,1≤Si≤101 \leq N \leq 10000 , 1 \leq S_i \leq 101≤N≤10000,1≤S
     * i
     * ​
     * ≤10
     * <p>
     * 输出描述
     * 采用合理的缓存策略，需要的最少金币数
     * <p>
     * 示例一
     * 输入
     * 5
     * 1 2 2 1 2 3 4
     * 1 1 1 1 1 1 1
     * 输出
     * 7
     * 说明
     * 文件大小相同，扫描成本均为1个金币。缓存任意文件均不合算，因而最少成本为7金币
     * <p>
     * 示例二
     * 输入
     * 5
     * 2 2 2 2 2 5 2 2 2
     * 3 3 3 3 3 1 3 3 3
     * 输出
     * 9
     * 说明
     * 2号文件出现了3次，扫描加缓存成本共计3+5=8，不缓存成本为3*8=24，显然缓存更优，最优成本为8+1=9。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            scanner.nextLine();
            String idsStr = scanner.nextLine();
            String sizesStr = scanner.nextLine();
            int res = solution(m, idsStr, sizesStr);
            System.out.println(res);
        }
    }

    private static int solution(int m, String idsStr, String sizesStr) {
        Map<Integer, Integer> idCost = new HashMap<>();
        Map<Integer, Integer> idSize = new HashMap<>();
        String[] ids = idsStr.split(" ");
        String[] sizes = sizesStr.split(" ");

        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i]);
            int size = Integer.parseInt(sizes[i]);
            idCost.put(id, idCost.getOrDefault(id, 0) + 1);
            idSize.put(id, size);
        }

        int sum = 0;
        for (Integer id : idCost.keySet()) {
            int total = idCost.get(id) * idSize.get(id);
            idCost.put(id, Math.min(total, m + idSize.get(id)));
            sum += idCost.get(id);
        }
        return sum;
    }
}
