package com.yhf.test2;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2023/8/30.
 *
 * @author qyjy4737
 */
public class TestMachineTesting {

    // 进制转换
    public static void testJzzh() {
        Scanner sc = new Scanner(System.in);
        // System.out.println(); // 打印后会换行
        // System.out.print(); // 打印后不会换行
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            // 十六进制转十进制
            int x = Integer.parseInt(str, 16);
            System.out.println(x);
            // 十进制转二进制
            String y = Integer.toBinaryString(x);
            System.out.println(y);
            // 十进制转八进制
            String z = Integer.toOctalString(x);
            System.out.println(z);
            // 十进制转十六进制
            String d = Integer.toHexString(x);
            System.out.println(d);
        }
    }

    // 求两个整数中的最大值
    public static void testMax() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        // 输入
        int x = input.nextInt();
        int y = input.nextInt();
        // 计算最大值
        int max = 0; // 存储最大值的变量
        if (x > y) {
            max = x;
        } else {
            max = y;
        }
        System.out.println("两个整数中的最大值是：" + max);
    }

    public static void test1() {
        System.out.println("Java是世界上最好的语言！");
    }

    // 计算带余除数：给定两个整数a和b(0<a,b<10000)，计算a除以b的整数商和余数。
    public static void test2() {
        Scanner input = new Scanner(System.in);
        // 输入
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println("商：" + a / b); // 商
        System.out.println("余数：" + a % b); // 余数
    }

    // 整数的个位：输入一个整数a，求个位数是几
    public static void test3() {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(); // 输入
        if (a < 9) { // 只有一位数的情况本身就是个位
            System.out.println(a);
        } else {
            System.out.println(a % 10); // 模10求余数
        }
    }

    // 整数的十位：输入一个整数a，求十位数是几
    public static void test4() {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(); // 输入
        if (a < 9) { // 只有一位数的情况本身就是个位
            System.out.println(a);
        } else {
            System.out.println(a / 10); // 除10求余数
        }
    }

    // 计算两个整数的和：输入两个整数，计算它们两个的和
    public static void test5() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        // 输入
        int x = input.nextInt();
        int y = input.nextInt();
        // 计算和
        int sum = x + y;
        System.out.println(sum); // 输入两个整数和
    }

    // 条件表达式：输入两个整数求的最大值
    public static void test6() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入两个整数：");
        // 输入
        int x = input.nextInt();
        int y = input.nextInt();
        // 计算最大值
        int max = x > y ? x : y; // 存储最大值的变量
        System.out.println(max); // 输入最大值
    }

    // 判断素数：输入一个整数，判断是不是素数
    public static void test7() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入1个整数：");
        // 输入
        int num = input.nextInt();
        // 素数：不能被除了1和它本身的数整除
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                System.out.println("不是素数");
                break;
            } else {
                System.out.println("是素数");
            }
        }
    }

    // 判断闰年：输入一个年份，判断其是不是闰年
    public static void test8() {
        Scanner input = new Scanner(System.in);
        // 输入
        int year = input.nextInt();
        // 闰年：能被4整除并且不能被100整除 --- 或者能被400整除
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Is leap year"); // 是闰年
        } else {
            System.out.println("Is not leap year"); // 不是闰年
        }
    }

    // 输出素数：打印100~200的素数
    public static void test9() {
        for (int i = 100; i <= 200; i++) {
            for (int j = i + 1; j < 200; j++) {
                if (i % j == 0) {
                    // 不是素数 --- 不需要打印
                }
            }
            // 程序走到这里说明内循环走完了都不能整除 --- 是素数输出
            System.out.print(i + "");
        }
    }

    // 兔子问题：斐波那契数列 1 1 2 3 5 8 13 21 34
    public static int result(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return result(n - 1) + result(n - 2);
        }
    }

    // 判断一个整数是否是水仙花数：所谓水仙花数是一个三位数，其各个位上数字立方和等于它本身
    // 思路分析：1.首先要得到此数百位、十位、个位上的数字，然后用if判断它们的立方和是否相等
    // 2.定义此数为n，以153为例
    // 3.n的百位 = n / 100 (153 / 100 = 1)
    // 4.n的十位 = n % 100 / 10 (153 % 100 = 53, 53 / 10 = 5)
    // 5.n的个位 = n % 10 (153 % 10 = 3)
    // 6.要是想要更加严谨，可以先判断此数是否为三位数，因为水仙花数只能是三位数。
    public static void testSxh() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数：");
        int n = sc.nextInt();

        // 核心代码部分
        int n1 = n / 100;
        int n2 = (n % 100) / 10;
        int n3 = n % 10;

        // if判断是否相等
        if (n < 1000 && n > 99) {   // 判断是否为三位数
            if (n == (n1 * n1 * n1 + n2 * n2 * n2 + n3 * n3 * n3)) {
                System.out.println("这个数是水仙花数");
            } else {
                System.out.println("这个数不是水仙花数");
            }
        } else {
            System.out.println("输入有误，请重新输入");
        }
    }

    private transient String name;

    /**
     * 线程池的状态总共有 5 种：RUNNING：运行状态、SHUTDOWN：关闭状态、STOP：停止状态、TIDYING：整理状态和 TERMINATED：销毁状态。默认情况下，如果不调用关闭方法，线程池会一直处于 RUNNING 状态，而线程池状态的转移有两个路径：当调用 shutdown() 方法时，线程池的状态会从 RUNNING 到 SHUTDOWN，再到 TIDYING，最后到 TERMENATED 销毁状态;当调用 shutdownNow() 方法时，线程池的状态会从 RUNNING 到 STOP，再到 TIDYING，最后到 TERMENATED 销毁状态。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100)) {
            @Override
            protected void terminated() {
                super.terminated();
                System.out.println("执行 terminated() 方法");
            }
        };
        // 关闭线程池
        threadPool.shutdown();
        // 等待线程池执行完再退出
        while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("线程池正在运行中");
        }
    }

}
