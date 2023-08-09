package com.yhf.test;

import java.util.Scanner;

public class Test001 {
    /**
     * 题目0001-勾股数
     * 题目描述
     * 如果三个正整数A、B、C ，A² + B² = C² 则为勾股数，
     * 如果ABC之间两两互质，即A与B，A与C，B与C均互质没有公约数，则称其为勾股数元组。
     * 请求出给定 n ~ m 范围内所有的勾股数元组。
     * <p>
     * 输入描述
     * 起始范围
     * 1 < n < 10000
     * n < m < 10000
     * <p>
     * 输出描述
     * ABC保证A < B < C
     * 输出格式A B C
     * 多组勾股数元组，按照A B C升序的排序方式输出。
     * 若给定范围内，找不到勾股数元组时，输出Na。
     * <p>
     * 示例一
     * 输入
     * 1
     * 20
     * 输出
     * 3 4 5
     * 5 12 13
     * 8 15 17
     * 示例二
     * 输入
     * 5
     * 10
     * 输出
     * Na
     */

    //思路解析和复杂度分析
    //本题是一道求解勾股数元组的问题。勾股数的定义是三个正整数 aaa、bbb、ccc，满足 a2+b2=c2a^2+b^2=c^2a
    //2
    // +b
    //2
    // =c
    //2
    // ，其中 aaa、bbb、ccc 两两互质，则称其为勾股数元组。
    //
    //求解思路是枚举 aaa 和 bbb，然后再计算出 ccc，判断是否满足勾股数条件和两两互质条件。需要注意的是，aaa 和 bbb 的范围是 nnn 到 mmm，ccc 的范围是 mmm，因为 aaa 和 bbb 不能大于 ccc。
    //
    //求解复杂度分析：
    //对于每个 aaa，需要枚举 bbb，范围是 a+1a+1a+1 到 mmm。对于每组 aaa 和 bbb，需要计算 ccc，因此计算 ccc 的次数也与 mmm 有关，最大不超过 mmm。因此，时间复杂度为 O((m−n)2m)O((m-n)^2m)O((m−n)
    //2
    // m)。
    //
    //空间复杂度为 O(1)O(1)O(1)，只需要几个变量存储数据即可。
    //
    //参考代码中，使用了一个求最大公约数的函数 gcd，其时间复杂度为 O(log⁡min⁡(a,b))O(\log \min(a,b))O(logmin(a,b))。因此，总时间复杂度为 O((m−n)2mlog⁡min⁡(a,b))O((m-n)^2m\log \min(a,b))O((m−n)
    //2
    // mlogmin(a,b))。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean found = false;
            for (int i = n; i <= m; i++) {
                for (int j = i + 1; j <= m; j++) {
                    int k = (int) Math.sqrt(i * i + j * j);
                    if (k > m) {
                        break;
                    }
                    if (k * k == i * i + j * j) {
                        if (gcd(i, j) == 1 && gcd(j, k) == 1) {
                            System.out.printf("%d %d %d\\n", i, j, k);
                            found = true;
                        }
                    }
                }
            }
            if (!found) {
                System.out.println("Na");
            }
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
