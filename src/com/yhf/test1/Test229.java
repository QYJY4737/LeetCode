package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test229 {
    /**
     * 题目0229-响应报文时间
     * 题目描述
     * IGMP 协议中，有一个字段称作最大响应时间(Max Response Time)，HOST收到查询报文，解析出MaxResponseTime字段后，
     * 需要在(0,MaxResponseTime)(s)时间内选取随机时间回应一个响应报文，如果再随机时间内收到一个新的查询报文，则会根据两者时间的大小，选取小的一方刷新回应时间。
     * <p>
     * 最大响应时间有如下计算方式：
     * 当MaxRespCode < 128,MaxRespTime = MaxRespCode;
     * 当MaxRespCode >= 128,MaxRespTime = (amnt | 0x10) << (exp + 3);
     * |0|123|4567|
     * |1|exp|mant|
     * 注：exp最大响应时间的高5~7位;mant为最大响应时间的低4位。
     * 其中接收到的 MaxRespCode 最大值为255，以上出现所有字段均为无符号数。
     * 现在我们认为 HOST 接收到查询报文时，选取的随机时间必定为最大值。
     * 现给出 HOST 收到查询报文个数 CCC ，HOST收到报文的时间 TTT ，以及查询报文的最大响应时间字段值 MMM ，请计算出 HOST 发送响应报文的时间。
     * <p>
     * 输入描述
     * 第一行为查询报文个数 CCC，后续每行分别为HOST收到报文时间 TTT，以及最大响应字段 MMM ，以空格分割。
     * <p>
     * 输出描述
     * HOST发送响应报文的时间
     * <p>
     * 示例一
     * 输入
     * 3
     * 0 20
     * 1 10
     * 8 20
     * 输出
     * 11
     * 说明
     * 收到3个报文，
     * 第0秒收到1个报文响应时间为20秒，则要到0+20=20秒响应;
     * 第1秒收到第2个报文，响应时间为10，则要到1+10=11秒响应，与上面的报文的响应时间比较获得响应时间最小为11秒;
     * 第8秒收到第3个报文，响应时间为20秒，则要到8+20=28秒响应，与上面的报文的响应时间比较获得响应时间最小为11秒;
     * 最终得到最小响应报文时间为11秒。
     * <p>
     * 示例二
     * 输入
     * 2
     * 0 255
     * 200 60
     * 输出
     * 260
     * 说明
     * 第0秒收到第1个报文，响应时间为255秒，则要到(15|0x10)<<(7+3)=31744秒响应；(mant=15,exp=7)
     * 第200秒收到第2个报文，响应时间为60，则要到200+60=260秒响应，与上面的报文的响应时间比较获得响应时间最小为260秒;
     * 最终得到最小响应报文时间为260秒。
     * <p>
     * 备注
     * 用例确定只会发送一个响应报文，不存在计时结束后依然收到查询报文的情况。
     * <p>
     * 思路解析和复杂度分析
     * 本题的目标是计算出在给定一系列查询报文的情况下，HOST 发送响应报文的最早时间。每个查询报文包含报文时间和最大响应时间字段。这个问题可以通过迭代处理每个查询报文并不断更新最小响应时间来解决。
     * <p>
     * 解题思路：
     * 首先，需要计算最大响应时间。这可以通过根据给定的公式计算实现。如果最大响应代码（MaxRespCode）小于128，则最大响应时间等于最大响应代码。否则，需要通过将最大响应代码的高5~7位（exp）和低4位（mant）结合，按照公式 (mant | 0x10) << (exp + 3) 计算最大响应时间。
     * 然后，需要迭代处理每个查询报文。对于每个报文，首先读取报文时间（T）和最大响应代码（M）。然后，根据最大响应代码计算最大响应时间。将报文时间加上最大响应时间，得到当前报文的响应时间。
     * 在处理每个查询报文时，需要不断更新最小响应时间。将当前报文的响应时间与已知的最小响应时间进行比较，取较小值作为新的最小响应时间。
     * 最后，输出最小响应时间作为结果。
     * 时间复杂度分析：
     * 由于我们需要迭代处理每个查询报文，所以算法的时间复杂度为 O(C)，其中 C 为查询报文的数量。在每次迭代中，我们仅执行常数时间的操作，如计算最大响应时间和更新最小响应时间。因此，总体时间复杂度为 O(C)。
     * <p>
     * 空间复杂度分析：
     * 算法所需的额外空间主要用于存储输入数据。除此之外，只需要常数级别的额外空间来存储临时变量，如报文时间、最大响应代码和当前报文的响应时间。因此，总体空间复杂度为 O(C)。
     * <p>
     * 总结，本题的解题思路是迭代处理每个查询报文并不断更新最小响应时间。算法具有 O(C) 的时间复杂度和 O(C) 的空间复杂度。在实际实现中，可以使用不同的编程语言，如 C、C++、Python、JavaScript（Node.js）或 Go。不同语言的实现细节可能略有不同，但总体解题思路和复杂度分析保持一致。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int C = scanner.nextInt();
            int[] T = new int[C];
            int[] M = new int[C];

            for (int i = 0; i < C; i++) {
                T[i] = scanner.nextInt();
                M[i] = scanner.nextInt();
            }
            int responseTime = solution(C, T, M);
            System.out.println(responseTime);
        }
    }

    private static int solution(int C, int[] T, int[] M) {
        int responseTime = 0;
        for (int i = 0; i < C; i++) {
            int maxRespTime = calculateMaxRespTime(M[i]);
            int newRespTime = T[i] + maxRespTime;

            if (i == 0 || newRespTime < responseTime) {
                responseTime = newRespTime;
            }
        }

        return responseTime;
    }

    private static int calculateMaxRespTime(int maxRespCode) {
        if (maxRespCode < 128) {
            return maxRespCode;
        } else {
            int exp = (maxRespCode & 0x70) >> 4;
            int mant = maxRespCode & 0x0F;
            return (mant | 0x10) << (exp + 3);
        }
    }
}
