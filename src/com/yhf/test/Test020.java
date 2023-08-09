package com.yhf.test;

import java.util.*;

/**
 * Created on 2023/8/9.
 *
 * @author qyjy4737
 */
public class Test020 {
    /**
     * 题目0020-合并数组
     * 题目描述
     * 现在有多组整数数组，需要将他们合并成一个新的数组，
     * 合并规则：从每个数组里按顺序取出固定长度的内容，合并到新的数组。
     * 取完的内容会删除掉，如果该行不足固定长度，或者已经为空，
     * 则直接取出剩余部分的内容放到新的数组中继续下一行。
     * <p>
     * 输入描述
     * 第1行为每次读取的固定长度len，0 < len < 10，
     * 第2行是整数数组的数目num， 0 < num < 10000，
     * 第3 ~ n 行是需要合并的数组，
     * 不同的数组用换行分割，
     * 元素之间用逗号分割，
     * 最大不超过100个元素
     * <p>
     * 输出描述
     * 输出一个新的数组，用逗号分割
     * <p>
     * 示例一
     * 输入
     * 3
     * 2
     * 2,5,6,7,9,5,7
     * 1,7,4,3,4
     * 输出
     * 2,5,6,1,7,4,7,9,5,3,4,7
     * 说明
     * 获得长度3和数组数目2
     * 先遍历第一行 获得2,5,6
     * 再遍历第二行 获得1,7,4
     * 再循环回到第一行获得7,9,5
     * 再遍历第二行获得3,4
     * 再回到第一行获得7
     * <p>
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
            int len = Integer.parseInt(scanner.nextLine());
            int num = Integer.parseInt(scanner.nextLine());
            System.out.print("len:" + len + ",num:" + num);
            String[] arrays = new String[num];
            for (int i = 0; i < num; i++) {
                arrays[i] = scanner.nextLine();
            }
            solution(len, arrays);
        }

    }

    private static void solution(int len, String[] arrays) {

        List<LinkedList<String>> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int sum = 0;
        for (String array : arrays) {
            String[] arr = array.split(",");
            sum += arr.length;
            list.add(new LinkedList<>(Arrays.asList(arr)));
        }
        while (res.size() != sum) {
            for (LinkedList<String> strList : list) {
                if (strList.size() == 0) continue;
                int times = Math.min(strList.size(), len);
                for (int i = 0; i < times; i++) {
                    res.add(strList.remove(0));
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i != res.size() - 1) {
                System.out.print(",");
            }
        }
    }
}
