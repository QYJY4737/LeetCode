package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test162 {
    /**
     * 题目0162-单核CPU任务调度
     * 题目描述
     * 现有一个CPU和一些任务需要处理，已提前获知每个任务的任务ID、优先级、所需执行时间和到达时间。
     * CPU同时只能运行一个任务，请编写一个任务调度程序，采用“可抢占优先权调度”调度算法进行任务调度，规则如下：
     * <p>
     * 如果一个任务到来时，CPU是空闲的，则CPU可以运行该任务直到任务执行完毕。但是如果运行中有一个更高优先级的任务到来，则CPU必须暂停当前任务去运行这个优先级更高的任务；
     * 如果一个任务到来时，CPU正在运行一个比他优先级更高的任务时，信道大的任务必须等待；
     * 当CPU空闲时，如果还有任务在等待，CPU会从这些任务中选择一个优先级最高的任务执行，相同优先级的任务选择到达时间最早的任务。
     * 输入描述
     * 输入有若干行，每一行有四个数字（均小于10^8）,
     * 分别为任务ID，任务优先级，执行时间和到达时间。
     * 每个任务的任务ID不同，优先级数字越大优先级越高，
     * 并且相同优先级的任务不会同时到达。
     * 输入的任务已按照到达时间从小到大排序，并且保证在任何时间，
     * 处于等待的任务不超过10000个。
     * <p>
     * 输出描述
     * 按照任务执行结束的顺序，
     * <p>
     * 示例一
     * 输入
     * 1 3 5 1
     * 2 1 5 10
     * 3 2 7 12
     * 4 3 2 20
     * 5 4 9 21
     * 6 4 2 22
     * 输出
     * 1 6
     * 3 19
     * 5 30
     * 6 32
     * 4 33
     * 2 35
     */

    private static class Task implements Comparable<Task> {
        Integer id;
        Integer level;
        Integer time;
        Integer start;

        public Task(int id, int level, int time, int start) {
            this.id = id;
            this.level = level;
            this.time = time;
            this.start = start;
        }

        @Override
        public int compareTo(Task o) {
            return o.level - this.level;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Task> tasks = new ArrayList<>();
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] split = line.split(" ");
                Task task = new Task(
                        Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2]),
                        Integer.parseInt(split[3])
                );
                tasks.add(task);
            }

            solution(tasks);
        }
    }

    private static void solution(List<Task> tasks) {
        int time = 0;
        ArrayList<Task> waiting = new ArrayList<>();
        while (tasks.size() > 0) {

            Task cur = find(tasks, time);

            if (cur != null) {
                waiting.add(cur);
                waiting.sort(Task::compareTo);
                cur = waiting.get(0);
            } else {
                if (waiting.size() != 0) {
                    cur = waiting.get(0);
                }
            }

            if (cur != null) {
                cur.time -= 1;
                if (cur.time.equals(0)) {
                    System.out.println(cur.id + " " + (time + 1));
                    tasks.remove(cur);
                    waiting.remove(cur);
                }
            }
            time++;
        }
    }

    private static Task find(List<Task> tasks, int time) {
        for (Task task : tasks) {
            if (task.start.equals(time)) {
                return task;
            }
        }
        return null;
    }
}
