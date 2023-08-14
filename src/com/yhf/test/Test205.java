package com.yhf.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test205 {
    /**
     * 题目0205-异常的打卡记录
     * 题目描述
     * 考勤记录是分析和考核职工工作时间利用情况的原始依据，也是计算职工工资的原始依据，
     * 为了正确地计算职工工资和监督工资基金使用情况，公司决定对员工的手机打卡记录进行异常排查。
     * 如果出现以下两种情况，则认为打卡异常：
     * <p>
     * 实际设备号与注册设备号不一样
     * 或者，同一个员工的两个打卡记录的时间小于60分钟并且打卡距离超过5km。
     * 给定打卡记录的字符串数组clockRecords（每个打卡记录组成为：工号,时间（分钟）,打卡距离（km）,实际设备号,注册设备号），返回其中异常的打卡记录（按输入顺序输出）。
     * 输入描述
     * 第一行输入为 NNN，表示打卡记录数；
     * 之后的 NNN 行为打卡记录，每一行为一条打卡记录。
     * <p>
     * 例如：
     * <p>
     * 2
     * 100000,10,1,ABCD,ABCD
     * 100000,50,10,ABCD,ABCD
     * 输出描述
     * 输出为异常的打卡记录，例如：100000,10,1,ABCD,ABCD;100000,50,10,ABCD,ABCD
     * <p>
     * 备注
     * clockRecords长度 <= 1000；
     * clockRecords[i]格式：{id},{time},{distance},{actualDeviceNumber},{registeredDeviceNumber}
     * id由6位数字组成；
     * time由整数组成，范围为0 ~ 1000；
     * distance由整数组成，范围为0 ~ 100；
     * actualDeviceNumber与registeredDeviceNumber由四位大写字母组成。
     * 示例一
     * 输入
     * 2
     * 100000,10,1,ABCD,ABCD
     * 100000,50,10,ABCD,ABCD
     * 输出
     * 100000,10,1,ABCD,ABCD;100000,50,10,ABCD,ABCD
     * 说明
     * 第一条记录是异常的，因为第二条记录与它的间隔不超过60分钟但是打卡距离超过了5km，同理第二条记录也是异常的。
     * <p>
     * 示例二
     * 输入
     * 2
     * 100000,10,1,ABCD,ABCD
     * 100000,80,10,ABCE,ABCD
     * 输出
     * 100000,80,10,ABCE,ABCD
     * 说明
     * 第二条记录的注册设备号与打卡设备号不一致，所以是异常记录
     * <p>
     * 示例三
     * 输入
     * 2
     * 100000,10,1,ABCD,ABCD
     * 100001,80,10,ABCE,ABCE
     * 输出
     * null
     * 说明
     * 无异常打卡记录，所以返回null
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] records = new String[n];
            for (int i = 0; i < n; i++) {
                records[i] = scanner.nextLine();
            }
            String res = solution(records);
            System.out.println(res);
        }
    }

    private static class Record {
        String id;
        int time;
        int distance;
        String actualDeviceNumber;
        String registeredDeviceNumber;
        String src;
    }

    private static String solution(String[] records) {
        ArrayList<Record> list = new ArrayList<>(records.length);
        for (String record : records) {
            String[] split = record.split(",");
            Record r = new Record();
            r.id = split[0];
            r.time = Integer.parseInt(split[1]);
            r.distance = Integer.parseInt(split[2]);
            r.actualDeviceNumber = split[3];
            r.registeredDeviceNumber = split[4];
            r.src = record;
            list.add(r);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Record cur = list.get(i);
            if (!cur.registeredDeviceNumber.equals(cur.actualDeviceNumber)) {
                builder.append(cur.src).append(";");
                continue;
            }
            for (Record tmp : list) {
                if (Math.abs(cur.time - tmp.time) < 60 && Math.abs(cur.distance - tmp.distance) > 5) {
                    builder.append(cur.src).append(";");
                    break;
                }
            }
        }

        return builder.length() == 0 ? "null" : builder.substring(0, builder.length() - 1);
    }
}
