package com.yhf.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test002 {
    /**
     * 题目0002-整数对最小和
     * 题目描述
     * 给定两个整数数组 array1 array2
     * 数组元素按升序排列
     * 假设从array1 array2中分别取出一个元素可构成一对元素
     * 现在需要取出K个元素
     * 并对取出的所有元素求和
     * 计算和的最小值
     * 注意：
     * 两对元素如果对应于array1 array2中的两个下标均相同，则视为同一个元素
     * <p>
     * 输入描述
     * 输入两行数组array1 array2
     * 每行首个数字为数组大小 size( 0 < size <= 100)
     * 0 < array1(i) <= 10000 < array2(i) <= 1000
     * 接下来一行为正整数k (0 < k <= array1.size() * array2.size())
     * <p>
     * 输出描述
     * 满足要求的最小和
     * <p>
     * 示例一
     * 输入
     * 3 1 1 2
     * 3 1 2 3
     * 2
     * 输出
     * 4
     * 说明
     * 用例中，需要取两个元素 取第一个数组第0个元素 与第二个数组第0个元素，组成一对元素[1,1]
     * 取第一个数组第1个元素 与第二个数组第0个元素，组成一对元素[1,1]
     * 求和为1+1+1+1=4 为满足要求的最小和
     */

    //思路解析和复杂度分析
    //思路解析
    //这道题可以看做是两个有序数组的归并排序的变形。先将两个数组中的元素两两相加，得到 m×nm \times nm×n 个元素，将这些元素按和的大小升序排序。题目要求取出前 kkk 个元素的和的最小值。
    //
    //因为数组是有序的，可以考虑使用双指针法，用两个指针 iii 和 jjj 分别指向数组 AAA 和数组 BBB，从头开始依次枚举每个元素，记录当前已经选取的元素个数 cntcntcnt。每次选取两个指针指向的元素中较小的一个，将其加入答案中，并将所在数组的指针向后移动一位。当 cntcntcnt 达到 kkk 时停止。
    //
    //复杂度分析
    //排序的时间复杂度为 O(mnlog⁡(mn))O(mn\log(mn))O(mnlog(mn))，枚举的时间复杂度为 O(k)O(k)O(k)，因此总时间复杂度为 O(mnlog⁡(mn)+k)O(mn\log(mn) + k)O(mnlog(mn)+k)。当 kkk 远小于 m×nm\times nm×n 时，算法的时间复杂度较低，但当 kkk 接近 m×nm\times nm×n 时，算法效率较低。
    //
    //空间复杂度为 O(mn)O(mn)O(mn)，因为需要开辟一个数组来存储每个元素的和以及对应的下标。
    static class Node {
        int i, j, val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        Node[] nodes = new Node[m * n];
        int nodesLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[nodesLen++] = new Node(i, j, arr1[i] + arr2[j]);
            }
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });

        int ans = 0;
        boolean[] used = new boolean[m];
        int cnt = 0;
        for (int i = 0; i < nodesLen; i++) {
            if (used[nodes[i].i]) continue;
            ans += nodes[i].val;
            used[nodes[i].i] = true;
            cnt++;
            if (cnt == k) break;
        }

        System.out.println(ans);
    }
}
