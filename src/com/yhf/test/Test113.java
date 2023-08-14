package com.yhf.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test113 {
    /**
     * 题目0113-选座位
     * 题目描述
     * 疫情期间需要大家保证一定的社交距离
     * 公司组织开交流会议，座位有一排共N个座位
     * 编号分别为[0...n-1]
     * 要求员工一个接着一个进入会议室
     * 并且还可以在任何时候离开会议室
     * 每当一个员工进入时，需要坐到最大社交距离的座位
     *
     * 例如：
     * 位置A与左右有员工落座的位置距离分别为2和2
     * 位置B与左右有员工落座的位置距离分别为2和3
     * 影响因素都为两个位置，则认为作为A和B与左右位置的社交距离是一样的
     * 如果有多个这样的座位
     * 则坐到索引最小的那个座位
     * 输入描述
     * 会议室座位总数1 <= seatNum <= 100
     * 员工的进出顺序seatOrLeave数组元素值为1表示进场，
     * 元素值为负数表示出场(特殊：位置0的员工不会离开)
     * 例如 -4 表示坐在位置4的员工离开(保证有员工坐在该座位上)
     *
     * 输出描述
     * 最后进来员工，他会坐在第几个位置
     * 如果位置已满 则输出-1
     *
     * 示例一
     * 输入
     * 10
     * [1,1,1,1,-4,1]
     * 输出
     * 5
     * 说明
     * seat->0坐在任何位置都行
     * 但是要给他安排索引最小的位置，也就是座位0
     * seat->9要和旁边的人距离最远 也就是座位9
     * seat->4位置4,4与0和9的的距离为(4和5)
     * 位置5与0和9的距离为(5和4)
     * 所以位置4和5都是可选的座位
     * 按照要求需索引最小的 选择4
     * seat->2 位置2与0和4的距离位置为(2和2)
     * 位置6与4和9的距离位置为(2和3)
     * 位置7与4和9的距离位置为(3和2)
     * 影响因素都为两个位置按照要求需索引最小的座位
     * 所以座位2
     * leave(4) 4号座位员工离开
     * seat->5 员工最后坐在5号座位
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            String seatOrLeave = scanner.nextLine();

            String[] split = seatOrLeave
                    .substring(1, seatOrLeave.length() - 1)
                    .split(",");

            int[] sol = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                sol[i] = Integer.parseInt(split[i]);
            }

            int[] seats = new int[n];

            int res = 0;
            for (int action : sol) {
                if (checkFull(seats, action)) {
                    System.out.println(-1);
                    return;
                }
                res = solution(seats, action);
            }
            System.out.print(res);
        }
    }

    private static boolean checkFull(int[] seats, int action) {
        if (action == 1) {
            int sum = 0;
            for (int seat : seats) {
                sum += seat;
            }
            return sum == seats.length;
        }
        return false;
    }

    private static int solution(int[] seats, int action) {
        if (action == 1) {
            //位置零
            if (seats[0] == 0) {
                seats[0] = 1;
                return 0;
            } else {
                List<Seat> list = new LinkedList<>();
                for (int i = 1; i < seats.length; i++) {
                    if (seats[i] != 1) {
                        int l = i - 1, r = i + 1;
                        while (l >= 0 && seats[l] != 1) l--;
                        while (r < seats.length && seats[r] != 1) r++;
                        if (r == seats.length) r = Integer.MAX_VALUE;
                        list.add(new Seat(i, i - l, r - i));
                    }
                }
                list.sort(Seat::compareTo);
                int n = list.get(0).n;
                seats[n] = 1;
                return n;
            }
        } else {
            //离开
            seats[Math.abs(action)] = 0;
            return -4;
        }
    }

    static class Seat implements Comparable<Seat> {
        public int n;
        public int l;
        public int r;

        public Seat(int n, int l, int r) {
            this.n = n;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Seat o) {
            // 左右最小值
            int min1 = Math.min(this.l, this.r);
            int min2 = Math.min(o.l, o.r);
            if (min1 != min2) {
                return min2 - min1;
            } else {
                return this.n - o.n;
            }
        }
    }
}
