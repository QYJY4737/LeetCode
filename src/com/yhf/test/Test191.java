package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test191 {
    /**
     * 题目0191-寻找链表的中间结点
     * 题目描述
     * 给定一个单链表 LLL，请编写程序输出 LLL 中间结点保存的数据。如果有两个中间结点，则输出第二个中间结点保存的数据。
     * 例如：给定 LLL 为 1→7→5，则输出应该为 7；给定 LLL 为 1→2→3→4，则输出应该为 3。
     * <p>
     * 输入描述
     * 每个输入包含 111 个测试用例。
     * 每个测试用例第 111 行给出链表首结点的地址、结点总个数正整数 N(N≤105)N (N \leq 10^5)N(N≤10
     * 5
     * )。结点的地址是 555 位非负整数，NULL 地址用 −1 表示。
     * <p>
     * 接下来有 NNN 行，每行格式为：
     * <p>
     * Address Data Next
     * 其中 Address 是结点地址，Data 是该结点保存的整数数据(0≤Data≤108)(0 \leq Data \leq 10^8)(0≤Data≤10
     * 8
     * )，Next 是下一结点的地址。
     * <p>
     * 输出描述
     * 对每个测试用例，在一行中输出 LLL 中间结点保存的数据。如果有两个中间结点，则输出第二个中间结点保存的数据。
     * <p>
     * 备注
     * 已确保输入的结点所构成的链表 LLL 不会成环，但会存在部分输入结点不属于链表 LLL 情况 。
     * <p>
     * 示例一
     * 输入
     * 00100 4
     * 00000 4 -1
     * 00100 1 12309
     * 33218 3 00000
     * 12309 2 33218
     * 输出
     * 3
     * 说明
     * 示例二
     * 输入
     * 10000 3
     * 76892 7 12309
     * 12309 5 -1
     * 10000 1 76892
     * 输出
     * 7
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int head = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();
            Map<Integer, int[]> link = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                int address = scanner.nextInt();
                int data = scanner.nextInt();
                int next = scanner.nextInt();
                link.put(address, new int[]{data, next});
            }
            int res = solution(head, link);
            System.out.println(res);
        }
    }

    private static int solution(int head, Map<Integer, int[]> link) {
        if (link.size() == 0) {
            return -1;
        }
        List<Integer> data = new ArrayList<>();
        int next = head;
        while (link.containsKey(next)) {
            int[] node = link.get(next);
            data.add(node[0]);
            next = node[1];
        }
        return data.get(data.size() / 2);
    }
}
