package com.yhf.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/10.
 *
 * @author qyjy4737
 */
public class Test031 {
    /**
     * 题目0031-内存池
     * 题目描述
     * 有一个简易内存池，内存按照大小粒度分类，每个粒度有若干个可用内存资源。
     * 用户会进行一系列内存申请，需要按需分配内存池中的资源，返回申请结果成功失败列表。
     * 分配规则如下：
     * <p>
     * 分配的内存要大于等于内存的申请量
     * 存在满足需求的内存就必须分配
     * 优先分配粒度小的，但内存不能拆分使用
     * 需要按申请顺序分配
     * 先申请的先分配，有可用内存分配则申请结果为true
     * 没有可用则返回false
     * 注释：不考虑内存释放
     * 输入描述
     * 输入为两行字符串:
     * 第一行为内存池资源列表，
     * 包含内存粒度数据信息，粒度数据间用逗号分割，
     * 一个粒度信息内用冒号分割，冒号前为内存粒度大小，冒号后为数量，
     * 资源列表不大于1024
     * 每个粒度的数量不大于4096
     * 第二行为申请列表，
     * 申请的内存大小间用逗号分割，申请列表不大于100000
     * 如
     * 64:2,128:1,32:4,1:128
     * 50,36,64,128,127
     * <p>
     * 输出描述
     * 输出为内存池分配结果
     * 如true,true,true,false,false
     * <p>
     * 示例一
     * 输入
     * 64:2,128:1,32:4,1:128
     * 50,36,64,128,127
     * 输出
     * true,true,true,false,false
     * 说明
     * 内存池资源包含：64k共2个、128k共1个、32k共4个、1k共128个的内存资源
     * 针对50,36,64,128,127的内存申请序列，
     * 分配的内存依次是，64,64,128,null,null
     * 第三次申请内存时已经将128分配出去，因此输出的结果是
     * true,true,true,false,false
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String resources = scanner.nextLine();
            String jobs = scanner.nextLine();
            solution(resources, jobs);
        }

    }

    private static void solution(String resources, String jobs) {
        TreeMap<Integer, Integer> pool = new TreeMap<>();
        Arrays.stream(resources.split(",")).forEach(x -> {
            String[] split = x.split(":");
            pool.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        });
        List<Integer> list = Arrays.stream(jobs.split(",")).map(Integer::parseInt).collect(Collectors.toList());


        for (int i = 0; i < list.size(); i++) {
            boolean flag = false;
            for (Integer k : pool.keySet()) {
                Integer v = pool.get(k);
                if (k >= list.get(i) && v != 0) {
                    System.out.print(true);
                    pool.put(k, v - 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print(false);
            }
            if (i != list.size() - 1) {
                System.out.print(",");
            }
        }
    }
}
