package com.yhf.test1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test212 {
    /**
     * 题目0212-区间连接器
     * 题目描述
     * 有一组区间 [a0, b0], [a1, b1], ... (a, b 表示起点, 终点)，区间有可能重叠、相邻，重叠或相邻则可以合并为更大的区间；
     * 给定一组连接器[x1, x2, x3, ...]（x 表示连接器的最大可连接长度，即 x >= gap），可用于将分离的区间连接起来，但两个分离区间之间只能使用1个连接器；
     * 请编程实现使用连接器后，最少的区间数结果。
     * 区间数量 < 10000；a, b <= 10000
     * 连接器梳理 <10000; x <= 10000
     * <p>
     * 输入描述
     * 区间组：[1,10],[15,20],[18,30],[33,40]
     * 连接器组：[5,4,3,2]
     * <p>
     * 输出描述
     * 1
     * 说明：合并后：[1,10], [15,30], [33,40]，使用 5, 3 两个连接器连接后只剩下 [1,40]
     * <p>
     * 示例一
     * 输入
     * [1,10],[15,20],[18,30],[33,40]
     * [5,4,3,2]
     * 输出
     * 1
     * 说明
     * 合并后：[1,10], [15,30], [33,40]，使用 5, 3 两个连接器连接后只剩下 [1,40]
     * <p>
     * 示例二
     * 输入
     * [1,2],[3,5],[7,10],[15,20],[30,100]
     * [5,4,3,2,1]
     * 输出
     * 2
     * 说明
     * 无重叠和相邻，使用 1，2，5 三个连接器连接后只剩下 [1, 20], [30, 100]
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String f = sc.nextLine();
        Integer[][] ranges =
                Arrays.stream(f.substring(1, f.length() - 1).split("],\\["))
                        .map(
                                str -> Arrays.stream(str.split(",")).map(Integer::parseInt).toArray(Integer[]::new))
                        .toArray(Integer[][]::new);

        String s = sc.nextLine();
        List<Integer> connects =
                Arrays.stream(s.substring(1, s.length() - 1).split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        System.out.println(getResult(ranges, connects));
    }

    public static int getResult(Integer[][] ranges, List<Integer> connects) {
        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));

        LinkedList<Integer[]> mergeRanges = new LinkedList<>();
        mergeRanges.addLast(ranges[0]);

        LinkedList<Integer> diffs = new LinkedList<>();

        for (int i = 1; i < ranges.length; i++) {
            Integer[] last = mergeRanges.getLast();
            int s1 = last[0];
            int e1 = last[1];

            Integer[] range = ranges[i];
            int s2 = range[0];
            int e2 = range[1];

            if (s2 <= e1) {
                mergeRanges.removeLast();
                mergeRanges.addLast(new Integer[]{s1, Math.max(e1, e2)});
            } else {
                diffs.addLast(s2 - e1);
                mergeRanges.addLast(range);
            }
        }

        diffs.sort((a, b) -> b - a);
        connects.sort((a, b) -> b - a);

        while (connects.size() > 0 && diffs.size() > 0) {
            if (connects.remove(connects.size() - 1) >= diffs.getLast()) {
                diffs.removeLast();
            }
        }

        return diffs.size() + 1;
    }
}
