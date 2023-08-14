package com.yhf.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test164 {
    /**
     * 题目0164-数组合并
     * 题目描述
     * 现在有多组整数数组,需要将他们合并成一个新的数组。
     * 合并规则,从每个数组里按顺序取出固定长度的内容合并到新的数组中,
     * 取完的内容会删除掉,
     * 如果该行不足固定长度或者已经为空,
     * 则直接取出剩余部分的内容放到新的数组中,继续下一行。
     * 如样例1,获得长度3,先遍历第一行,获得2,5,6；
     * 再遍历第二行,获得1,7,4；再循环回到第一行,
     * 获得7,9,5；再遍历第二行,获得3,4；
     * 再回到第一行,获得7,按顺序拼接成最终结果。
     *
     * 输入描述
     * 第一行是每次读取的固定长度,0<长度<10；
     * 第二行是整数数组的数目0<数目<1000,
     * 第3~n行是需要合并的数组,不同的数组用回车换行分隔,
     * 数组内部用逗号分隔。最大不超过100个元素
     *
     * 输出描述
     * 输出一个新的数组,用逗号分隔
     *
     * 示例一
     * 输入
     * 3
     * 2
     * 2,5,6,7,9,5,7
     * 1,7,4,3,4
     * 输出
     * 2,5,6,1,7,4,7,9,5,3,4,7
     * 示例二
     * 输入
     * 4
     * 3
     * 1,2,3,4,5,6
     * 1,2,3
     * 1,2,3,4
     * 输出
     * 1,2,3,4,1,2,3,1,2,3,4,5,6
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] strings = new String[n];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = scanner.nextLine();
            }
            String res = solution(k, n, strings);
            System.out.println(res);
        }
    }

    private static String solution(int k, int n, String[] strings) {
        StringBuilder builder = new StringBuilder();
        List<LinkedList<Integer>> lists = new ArrayList<>(n);
        for (String string : strings) {
            LinkedList<Integer> linkedList = Arrays.stream(string.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));
            lists.add(linkedList);
        }

        int index = 0;
        while (lists.size() > 0) {
            LinkedList<Integer> linkedList = lists.get(index);
            for (int i = 0; i < k; i++) {
                if (linkedList.isEmpty()) {
                    lists.remove(linkedList);
                    index--;
                    break;
                }
                builder.append(linkedList.removeFirst())
                        .append(",");
            }
            index++;
            if (index >= lists.size()) {
                index = 0;
            }
        }

        return builder.substring(0, builder.length() - 1);
    }
}
