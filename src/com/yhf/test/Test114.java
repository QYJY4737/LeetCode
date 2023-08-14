package com.yhf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test114 {
    /**
     * 题目0114-简易内存池2
     * 题目描述
     * 请实现一个简易内存池
     * 根据请求命令完成内存分配和释放
     * 内存池支持两种操作命令
     * REQUEST和RELEASE其格式为
     * REQUEST=请求的内存大小
     * 表示请求分配指定大小内存
     * 如果分配成功，返回分配到的内存首地址
     * 如果内存不足，或指定的大小为零则输出error
     * RELEASE=释放的内存首地址
     * 表示释放掉之前分配的内存
     * 释放成功无需输出
     * 如果释放不存在的首地址
     * 则输出error
     * <p>
     * 注意：
     * <p>
     * 内存池总大小为100字节
     * 内存池地址分配必须是连续内存，并优先从低地址分配
     * 内存释放后可被再次分配，已释放的内存在空闲时不能被二次释放
     * 不会释放已申请的内存块的中间地址
     * 释放操作只是针对首地址所对应的单个内存块进行操作，不会影响其他内存块
     * 输入描述
     * 首行为整数N
     * 表示操作命令的个数
     * 取值范围0<N<=100
     * 接下来的N行
     * 每行将给出一个操作命令
     * 操作命令和参数之间用”=“分割
     * 输出描述见题目输出要求
     * <p>
     * 输出描述
     * 示例一
     * 输入
     * 2
     * REQUEST=10
     * REQUEST=20
     * 输出
     * 0
     * 10
     * 示例二
     * 输入
     * 5
     * REQUEST=10
     * REQUEST=20
     * RELEASE=0
     * REQUEST=20
     * REQUEST=10
     * 输出
     * 0
     * 10
     * 30
     * 0
     * 说明
     * 第一条指令，申请地址0~9的10个字节内存
     * 返回首地址0
     * 第二条指令，申请地址 10~29的20字节内存
     * 返回首地址10
     * 第三条指令，释放首地址为0的内存申请，0~9地址内存被释放，
     * 变为空闲，释放成功，无需输出
     * 第四条指令，申请20字节内存，0~9地址内存连续空间不足20字节
     * 往后查找到30~49地址 返回首地址30
     * 第五条指令，申请地址 10字节，0~9地址内存连续空间足够
     * 返回首地址0
     */

    static class AllocatedMemory {
        private final TreeMap<Integer, Integer> hasAllocated;

        AllocatedMemory() {
            hasAllocated = new TreeMap<>();
        }

        String request(int size) {
            int addressDefaultHead = 0;
            int addressHead = addressDefaultHead;
            if (size <= 0 || size > 100) {
                return "error";
            }
            if (hasAllocated.isEmpty()) {
                hasAllocated.put(addressDefaultHead, size);
            } else {
                List<Integer> headList = new ArrayList<>(hasAllocated.keySet());
                for (Integer integer : headList) {
                    if (integer - addressHead >= size) {
                        hasAllocated.put(addressHead, addressHead + size);
                    } else {
                        addressHead = hasAllocated.get(integer);
                    }
                }
                int addressDefaultEnd = 100;
                if (size <= addressDefaultEnd - addressHead) {
                    hasAllocated.put(addressHead, addressHead + size);
                } else {
                    return "error";
                }
            }
            return String.valueOf(addressHead);
        }

        boolean release(int startAddress) {
            if (hasAllocated.containsKey(startAddress)) {
                hasAllocated.remove(startAddress);
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            AllocatedMemory allocatedMemory = new AllocatedMemory();
            try (Scanner scanner = new Scanner(System.in)) {
                int line = Integer.parseInt(scanner.nextLine());
                String[][] ins = new String[line][2];
                for (int i = 0; i < line; i++) {
                    ins[i] = scanner.nextLine().split("=");
                    if (ins[i][0].startsWith("REQUEST")) {
                        System.out.println(allocatedMemory.request(Integer.parseInt(ins[i][1])));
                    } else {
                        boolean ret = allocatedMemory.release(Integer.parseInt(ins[i][1]));
                        if (!ret) {
                            System.out.println("error");
                        }
                    }
                }
            }
        }
    }
}
