package com.yhf.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test163 {
    /**
     * 题目0163-寻找路径
     * 题目描述
     * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值储存在下标1，
     * 对于储存在下标n的节点，他的左子节点和右子节点分别储存在下标 2*n 和 2*n+1，
     * 并且我们用-1代表一个节点为空。
     * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
     * <p>
     * 输入描述
     * 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分割。
     * 注意第一个元素即为根节点的值，即数组的第n元素对应下标n。
     * 下标0在树的表示中没有使用，所以我们省略了。
     * 输入的树最多为7层。
     * <p>
     * 输出描述
     * 输出从根节点到最小叶子节点的路径上各个节点的值由空格分割
     * 用例保证最小叶子节点只有一个
     * <p>
     * 示例一
     * 输入
     * 3 5 7 -1 -1 2 4
     * 输出
     * 3 7 2
     * 示例二
     * 输入
     * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
     * 输出
     * 5 8 7 6
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(" ");
        int[] ints = new int[split.length + 1];
        int minValue = Integer.MAX_VALUE;
        int minPos = 0;

        for (int i = 1; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i - 1]);
            if (i > 1 && ints[i] != -1 && ints[i] < minValue) {
                minValue = ints[i];
                minPos = i;
            }
        }
        System.out.println(Arrays.toString(ints));
        List<Integer> way = new ArrayList<>();
        while (minPos >= 1) {
            way.add(ints[minPos]);
            minPos /= 2;
        }
        System.out.println(minPos);

        for (int i = way.size() - 1; i >= 0; i--) {
            System.out.print(way.get(i));
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }
}
