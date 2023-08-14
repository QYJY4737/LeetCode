package com.yhf.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test143 {
    /**
     * 题目0143-玩牌高手
     * 题目描述
     * 给定一个长度为N的整数数组，表示一个选手在N轮内选择的牌面分数，
     * 选手基于规则选牌，请计算所有轮结束后其可以获得的最高总分数。
     * 选择规则如下：
     *
     * 在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数为其新的总分数
     * 选手也可不选择本轮牌面，直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮次小于等于3，则总分数置0
     * 选手初始总分数为0，且必须依次参加每轮
     * 输入描述
     * 第一行为一个小写逗号分隔的字符串
     * 表示N轮的牌面分数
     * 1 <= N <= 20 分数值为整数 [-100,100]
     * 不考虑格式问题
     *
     * 输出描述
     * 所有轮结束后 选手能获得的最高总分数
     *
     * 示例一
     * 输入
     * 1,-5,-6,4,3,6,-2
     * 输出
     * 11
     * 说明
     * 总共7轮牌面，
     * 第一轮选择该轮牌面总分数为1
     * 第二轮不选择该轮牌面总分数还原为0
     * 第三轮不选择该轮牌面总分数还原为0
     * 第四轮选择该轮牌面总分数为4
     * 第五轮选择该轮牌面总分数为7
     * 第六轮选择该轮牌面总分数为13
     * 第七轮如果不选择概论牌面 则总分数返回到三轮前的分数 即第四轮的总分数4
     * 如果选择该轮牌面，总分数为11，所以选择该轮， 因此最高总分数为11
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] numStrArray = line.split(",");
        Map<Integer, Integer> map = new HashMap<>();
        for (int m = 0, size = numStrArray.length; m < size; m++) {
            int num = Integer.parseInt(numStrArray[m]);
            if (m < 3) {
                if (m == 0) {
                    map.put(m + 1, Math.max(0, num));
                } else {
                    map.put(m + 1, Math.max(0, (map.get(m) + num)));
                }
            } else {
                map.put(m + 1, Math.max((map.get(m) + num), map.get(m - 2)));
            }
        }
        System.out.print(map.get(numStrArray.length));
    }
}
