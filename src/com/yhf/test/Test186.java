package com.yhf.test;

import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test186 {
    /**
     * 题目0186-日志采集系统
     * 题目描述
     * 日志采集是运维系统的的核心组件。日志是按行生成，每行记做一条，由采集系统分批上报。
     * 如果上报太频繁，会对服务端造成压力；
     * 如果上报太晚，会降低用户的体验；
     * 如果一次上报的条数太多，会导致超时失败。
     * 为此，项目组设计了如下的上报策略：
     * <p>
     * 每成功上报一条日志，奖励1分
     * 每条日志每延迟上报1秒，扣1分
     * 积累日志达到100条，必须立即上报
     * 给出日志序列，根据该规则，计算首次上报能获得的最多积分数。
     * 输入描述
     * 按时序产生的日志条数 T1,T2...TnT_1,T_2...T_nT
     * 1
     * ​
     * ,T
     * 2
     * ​
     * ...T
     * n
     * ​
     * , 其中 1≤n≤1000,0≤Ti≤1001 \leq n \leq 1000, 0 \leq T_i \leq 1001≤n≤1000,0≤T
     * i
     * ​
     * ≤100
     * <p>
     * 输出描述
     * 首次上报最多能获得的积分数
     * <p>
     * 示例一
     * 输入
     * 1 98 1
     * 输出
     * 98
     * 说明
     * 采集系统第2个时刻上报，可获得最大积分(98+1)-1=98
     * <p>
     * 示例二
     * 输入
     * 50 60 1
     * 输出
     * 50
     * 说明
     * 如果第1个时刻上报，获得积分50。
     * 如果第2个时刻上报，最多上报100条，前50条延迟上报1s，每条扣除1分，共获得积分为 100-50=50。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int res = solution(line);
            System.out.println(res);
        }
    }

    private static int solution(String line) {
        int score = 0;
        String[] split = line.split(" ");
        int[] counts = new int[split.length];


        for (int i = 0; i < counts.length; i++) {
            counts[i] = Integer.parseInt(split[i]);
        }

        if (counts.length > 0 && counts[0] >= 100) {
            return 100;
        }

        for (int i = 0; i < counts.length; i++) {
            score = Math.max(score, getScore(counts, i));
        }
        return score;
    }

    private static int getScore(int[] counts, int ts) {
        int score = 0;
        int total = 0;
        for (int i = 0; i <= ts; i++) {
            if (total + counts[i] < 100) {
                score += counts[i];
                score -= counts[i] * (ts - i);
                total += counts[i];
            } else {
                int diff = 100;
                for (int j = 0; j < i; j++) {
                    diff -= counts[j];
                    counts[j] = 0;
                }
                counts[i] -= diff;
                score += diff;
                score -= diff * (ts - i);
                return score;
            }
        }
        return score;
    }
}
