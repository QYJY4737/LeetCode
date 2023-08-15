package com.yhf.test1;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test266 {
    /**
     * 题目0266-模拟工作队列
     * 题目描述
     * 让我们来模拟一个工作队列的运作，有一个任务提交者和若干任务执行者，执行者从1开始编号
     * 提交者会在给定的时刻向工作队列提交任务，任务有执行所需的时间，
     * 执行者取出任务的时刻加上执行时间即为任务完成的时刻
     * 执行者完成任务变为空闲的时刻会从工作队列中取最老的任务执行，若这一时刻有多个空闲的执行者，
     * 其中优先级最高的会执行这个任务。编号小的执行者优先级高。初始状态下所有执行者都空闲。
     * 工作队列有最大长度限制，当工作队列满而有新的任务需要加入队列时，队列中最老的任务会被丢弃。
     * 特别的，在工作队列满的情况下，当执行者变为空闲的时刻和新的任务提交的时刻相同时，
     * 队列中最老的任务被取出执行，新的任务加入队列。
     *
     * 输入描述
     * 输入为两行。
     * 第一行为 2N2N2N 个正整数，代表提交者提交的N个任务的时刻和执行时间。
     * 第一个数字是第一个任务的提交时刻，第二个数字是第一个任务的执行时间，以此类推。
     * 用例保证提交时刻不会重复，任务按提交时刻升序排列。
     * 第二行为两个数字，分别为工作队列的最大长度和执行者的数量。
     * 两行的数字都由空格分隔。NNN 不超过 202020 ，数字为不超过 100010001000 的正整数
     *
     * 输出描述
     * 输出两个数字，分别为最后一个任务执行完成的时刻和被丢弃的任务的数量，数字由空格分隔。
     *
     * 示例一
     * 输入
     * 1 3 2 2 3 3
     * 3 2
     * 输出
     * 7 0
     * 说明
     * 示例二
     * 输入
     * 1 6 2 4 4 3 6 3
     * 1 2
     * 输出
     * 10 0
     * 说明
     * 示例三
     * 输入
     * 1 6 2 4 3 3 4 3 6 3
     * 1 2
     * 输出
     * 10 1
     * 说明
     * ¶思路解析和复杂度分析
     */
}