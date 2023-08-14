package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test145 {
    /**
     * 题目0145-端口合并
     * 题目描述
     * 有M(1<=M<=10)个端口组，
     * 每个端口组是长度为N(1<=N<=100)的整数数组，
     * 如果端口组间存在2个及以上不同端口相同，
     * 则认为这2个端口组互相关联，可以合并
     * 第一行输入端口组个数M，再输入M行，每行逗号分隔，代表端口组。
     * 输出合并后的端口组，用二维数组表示
     *
     * 输入描述
     * 第一行输入一个数字M
     * 第二行开始输入M行，每行是长度为N的整数数组，用逗号分割
     *
     * 输出描述
     * 合并后的二维数组
     *
     * 示例一
     * 输入
     * 4
     * 4
     * 2,3,2
     * 1,2
     * 5
     * 输出
     * [[4],[2,3],[1,2],[5]]
     * 说明
     * 仅有一个端口2相同，不可以合并
     *
     * 示例二
     * 输入
     * 3
     * 2,3,1
     * 4,3,2
     * 5
     * 输出
     * [[1,2,3,4],[5]]
     * 说明
     * 示例三
     * 输入
     * 6
     * 10
     * 4,2,1
     * 9
     * 3,6,9,2
     * 6,3,4
     * 8
     * 输出
     * [[10],[1,2,3,4,6,9],[9],[8]]
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int m = Integer.parseInt(scanner.nextLine());
            String[] portGroups = new String[m];
            for (int i = 0; i < m; i++) {
                portGroups[i] = scanner.nextLine();
            }
            solution(m, portGroups);
        }
    }

    private static void solution(int m, String[] portGroups) {
        List<TreeSet<Integer>> list = new ArrayList<>(m);
        for (String portGroup : portGroups) {
            String[] split = portGroup.split(",");
            TreeSet<Integer> ports = new TreeSet<>();
            for (String s : split) {
                ports.add(Integer.parseInt(s));
            }
            list.add(ports);
        }

        // 检查合并

        while (merge(list)) ;

        System.out.println(list);

    }

    private static boolean merge(List<TreeSet<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                TreeSet<Integer> group1 = list.get(i);
                TreeSet<Integer> group2 = list.get(j);
                boolean same = checkSameGreater2(group1, group2);
                if (same) {
                    group1.addAll(group2);
                    list.remove(j);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkSameGreater2(TreeSet<Integer> group1, TreeSet<Integer> group2) {
        int count = 0;
        for (Integer integer : group1) {
            if (group2.contains(integer)) {
                count++;
            }
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }
}
