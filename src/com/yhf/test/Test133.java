package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test133 {
    /**
     * 题目0133-跳格子
     * 题目描述
     * 地上共有N个格子，你需要跳完地上所有的格子，
     * 但是格子间是有强依赖关系的，跳完前一个格子后，
     * 后续的格子才会被开启，格子间的依赖关系由多组steps数组给出，
     * steps[0]表示前一个格子,steps[1]表示steps[0]可以开启的格子:
     * 比如[0,1]表示从跳完第0个格子以后第1个格子就开启了，
     * 比如[2,1]，[2,3]表示跳完第2个格子后第1个格子和第3个格子就被开启了
     * 请你计算是否能由给出的steps数组跳完所有的格子,
     * 如果可以输出yes，否则输出no
     * 说明：
     *
     * 你可以从一个格子跳到任意一个开启的格子
     * 没有前置依赖条件的格子默认就是开启的
     * 如果总数是N，则所有的格子编号为[0,1,2,3....N-1]连续的数组
     * 1 <= N < 500
     * steps[i].length = 2
     * 0 <= step[i][0]，step[i][1] < N
     *
     * 输入描述
     * 输入一个整数N表示总共有多少个格子，接着输入多组二维数组steps表示所有格子之间的依赖关系
     *
     * 输出描述
     * 如果能按照steps给定的依赖顺序跳完所有的格子输出yes
     * 否则输出no
     *
     * 示例一
     * 输入
     * 3
     * 0 1
     * 0 2
     * 输出
     * yes
     * 说明
     * 总共有三个格子[0,1,2]，跳完0个格子后第1个格子就开启了，
     * 跳到第0个格子后第2个格子也被开启了，
     * 按照0->1->2或者0->2->1的顺序都可以跳完所有的格子
     *
     * 示例二
     * 输入
     * 2
     * 1 0
     * 0 1
     * 输出
     * no
     * 说明
     * 总共有2个格子，第1个格子可以开启第0格子，
     * 但是第1个格子又需要第0个格子才能开启，相互依赖，因此无法完成
     *
     * 示例三
     * 输入
     * 6
     * 0 1
     * 0 2
     * 0 3
     * 0 4
     * 0 5
     * 输出
     * yes
     * 说明
     * 总共有6个格子，第0个格子可以开启第1,2,3,4,5个格子，
     * 所以跳完第0个格子之后其他格子都被开启了，之后按任何顺序可以跳完剩余的格子
     *
     * 示例四
     * 输入
     * 5
     * 4 3
     * 0 4
     * 2 1
     * 3 2
     * 输出
     * yes
     * 说明
     * 跳完第0个格子可以开启格子4，跳完格子4可以开启格子3，
     * 跳完格子3可以开启格子2，跳完格子2可以开启格子1，
     * 按照0->4->3->2->1这样就跳完所有的格子
     *
     * 示例五
     * 输入
     * 4
     * 1 2
     * 1 0
     * 输出
     * yes
     * 说明
     * 总共4个格子[0,1,2,3]，格子1和格子3没有前置条件所以默认开启，
     * 格子1可以开启格子0和格子2，所以跳到格子1之后就可以开启所有的格子，因此可以跳完所有格子
     */

    public static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            boolean isTrue = true;
            while (scanner.hasNext()) {
                int key = scanner.nextInt();
                if (key == -1) {
                    break;
                }
                if (key < 1 && key > n) {
                    System.out.println("输入有误");
                    return;
                }

                int value = scanner.nextInt();
                if (value < 1 && value > n) {
                    System.out.println("输入有误");
                    return;
                }

                List<Integer> listChild = new ArrayList<>();
                listChild.add(key);
                listChild.add(value);
                list.add(listChild);
            }

            int len = list.size();
            for (List<Integer> integers : list) {
                if (isBH(integers)) {
                    isTrue = false;
                    break;
                }
            }

            System.out.println(isTrue ? "yes" : "no");
        }
    }

    public static boolean isBH(List<Integer> listC) {
        for (List<Integer> temp : list) {
            if (temp.get(0).equals(listC.get(listC.size() - 1))) {
                if (listC.contains(temp.get(1))) {
                    return true;
                }
                listC.add(temp.get(1));
                isBH(listC);
            }
        }
        return false;
    }
}
