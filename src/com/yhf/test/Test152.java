package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test152 {
    /**
     * 题目0152-星际篮球争霸赛
     * 题目描述
     * 在星球争霸篮球赛对抗赛中 ，最大的宇宙战队希望每个人
     * 都能拿到MVP，MVP的条件是单场最高分得分获得者。
     * 可以并列所以宇宙战队 决定在比赛中 尽可能让更多队员上场，
     * 并且让所有得分的选手得分都相同，
     * 然而比赛过程中的每1分钟的得分都只能由某一个人包揽。
     *
     * 输入描述
     * 输入第一行为一个数字 ttt，表示为有得分的分钟数 1≤t≤501 \leq t \leq 501≤t≤50
     * 第二行为 ttt 个数字，代表每一分钟的得分 ppp ， 1≤t≤501 \leq t \leq 501≤t≤50
     *
     * 输出描述
     * 输出有得分的队员都是MVP时，最少得MVP得分
     *
     * 示例一
     * 输入
     * 9
     * 5 2 1 5 2 1 5 2 1
     * 输出
     * 6
     * 说明
     * 样例解释 一共 444 人得分，分别都是 666 分
     * 5+1，5+1，5+1，2+2+25+1， 5+1， 5+1， 2+2+25+1，5+1，5+1，2+2+2
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int[] scores = new int[t];
            for (int i = 0; i < scores.length; i++) {
                scores[i] = scanner.nextInt();
            }

            int score = solution(scores);
            System.out.println(score);
        }
    }


    static int solution(int[] scores) {
        int sum = 0;
        List<Integer> myList = new ArrayList<>();
        for (int aa : scores) {
            sum += aa;
            myList.add(aa);
        }
        for (int i = scores.length; i > 0; i--) {
            if (sum % i == 0) {
                if (ifExist(myList, sum / i, sum / i)) {
                    return sum / i;
                }
            }
        }
        return sum;
    }

    static boolean ifExist(List<Integer> rootList, int num, int orgNum) {
        if (rootList.size() == 0 && num == orgNum) {
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < rootList.size(); i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < rootList.size(); j++) {
                if (j != i) {
                    subList.add(rootList.get(j));
                }
            }
            if (rootList.get(i) == num) {
                flag = flag || ifExist(subList, orgNum, orgNum);
            } else if (rootList.get(i) < num) {
                flag = flag || ifExist(subList, num - rootList.get(i), orgNum);
            }
        }
        return flag;
    }
}
