package com.yhf.test1;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test210 {
    /**
     * 题目0210-优秀学员统计
     * 题目描述
     * 公司某部门软件教导团正在组织新员工每日打卡学习活动，他们开展这项学习活动已经一个月了，所以想统计下这个月优秀的打卡员工。
     * 每个员工会对应一个id，每天的打卡记录记录当天打卡员工的id集合，一共30天。
     * 请你实现代码帮助统计出打卡次数top5的员工。假如打卡次数相同，将较早参与打卡的员工排在前面，如果开始参与打卡的时间还是一样，将id较小的员工排在前面。
     * 注：不考虑并列的情况，按规则返回前5名员工的id即可，如果当月打卡的员工少于5个，按规则排序返回所有有打卡记录的员工id。
     * <p>
     * 输入描述
     * 第一行输入为新员工数量 NNN ，表示新员工编号id为 000 到 N−1N-1N−1，NNN 的范围为 [1,100][1,100][1,100]
     * 第二行输入为30个整数，表示每天打卡的员工数量，每天至少有1名员工打卡
     * 之后30行为每天打卡的员工id集合，id不会重复
     * <p>
     * 输出描述
     * 按顺序输出打卡top5员工的id，用空格隔开
     * <p>
     * 备注
     * 同一天打卡的员工没有时间上早晚的区别。不保证所有员工都会打卡。排名只针对有打卡记录的员工。
     * <p>
     * 示例一
     * 输入
     * 11
     * 4 4 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
     * 0 1 7 10
     * 0 1 6 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 10
     * 6 10
     * 7 10
     * 输出
     * 10 0 1 7 6
     * 说明
     * 员工编号范围为 0−100-100−10，
     * id为10的员工连续打卡30天，排第一，
     * id为0，1，6，7的员工打卡都是两天，
     * id为0，1，7的员工在第一天就打卡，比id为6的员工早，排在前面，0，1，7按id升序排序，所以输出[10,0,1,7,6]
     * <p>
     * 示例二
     * 输入
     * 7
     * 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6 6
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 0 1 2 3 4 5
     * 输出
     * 0 1 2 3 4
     * 说明
     * 员工编号范围为0-6，id为0，1，2，3，4，5的员工打卡次数相同，最早开始打卡的时间也一样，所以按id升序返回前5个id
     * <p>
     * 示例三
     * 输入
     * 2
     * 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 1
     * 0 1
     * 0 1
     * 输出
     * 1 0
     * 说明
     * 只有两名员工参与打卡，按规则排序输出两名员工的id
     * <p>
     * 思路
     * 构建一个Clock类用于存储每个员工的id、打卡次数、最早打卡时间
     * 将数据整理到Clock中
     * 自定义符合题意的排序方式，排序后构建输出
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String counts = scanner.nextLine();
            String[] records = new String[30];
            for (int i = 0; i < records.length; i++) {
                records[i] = scanner.nextLine();
            }
            String res = solution(n, counts, records);
            System.out.println(res);
        }
    }

    private static class Clock implements Comparable<Clock> {
        int id;
        int times;
        int earliestTime = Integer.MAX_VALUE;

        @Override
        public int compareTo(Clock o) {
            if (this.times == o.times) {
                if (this.earliestTime == o.earliestTime) {
                    return this.id - o.id;
                } else {
                    return this.earliestTime - o.earliestTime;
                }
            } else {
                return o.times - this.times;
            }
        }
    }

    private static String solution(int n, String counts, String[] records) {
        HashMap<String, Clock> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String record = records[i];
            String[] ids = record.split(" ");
            for (String id : ids) {
                if (!map.containsKey(id)) {
                    Clock clock = new Clock();
                    clock.id = Integer.parseInt(id);
                    clock.earliestTime = Math.min(i, clock.earliestTime);
                    map.put(id, clock);
                }
                Clock clock = map.get(id);
                clock.times += 1;
                map.put(id, clock);
            }
        }
        List<Clock> list = map.values().stream().sorted().collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size() && i < 5; i++) {
            builder.append(list.get(i).id).append(" ");
        }

        return builder.substring(0, builder.length() - 1);
    }
}
