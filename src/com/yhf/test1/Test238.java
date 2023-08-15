package com.yhf.test1;

import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test238 {
    /**
     * 题目0238-羊、狼、农夫过河
     * 题目描述
     * 羊、狼、农夫都在岸边，当羊的数量小于狼的数量时，狼会攻击羊，农夫则会损失羊。农夫有一艘容量固定的船，能够承载固定数量的动物。
     * <p>
     * 要求求出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。
     * <p>
     * 只计算农夫去对岸的次数，回程时农夫不会运送羊和狼。
     * <p>
     * 备注：农夫在或农夫离开后羊的数量大于狼的数量时狼不会攻击羊。
     * <p>
     * 输入描述
     * 第一行输入为 MMM，NNN，XXX， 分别代表羊的数量，狼的数量，小船的容量。
     * <p>
     * 输出描述
     * 输出不损失羊情况下将全部羊和狼运到对岸需要的最小次数（若无法满足条件则输出 0 ）。
     * <p>
     * 示例一
     * 输入
     * 5 3 3
     * 输出
     * 3
     * 说明
     * 第一次运2只狼
     * 第二次运3只羊
     * 第三次运2只羊和1只狼
     * <p>
     * 示例一
     * 输入
     * 5 4 1
     * 输出
     * 0
     * 说明
     * 如果找不到不损失羊的运送方案，输出0
     * <p>
     * 思路解析和复杂度分析
     * 思路解析：
     * 本题的目标是在不损失羊的情况下，求出将所有羊和狼运到对岸所需的最小次数。我们需要注意的是，每次运动时，羊的数量必须大于等于狼的数量，以避免羊被狼攻击。
     * <p>
     * 首先检查边界条件。如果船的容量为1，那么只有当狼的数量为0时，农夫才能将羊运到对岸，所需次数为羊的数量。否则输出0。
     * 其次，我们需要确保初始状态下，狼的数量不大于羊的数量，否则无法满足题目要求，输出0。
     * 初始化步数为0，剩余的羊和狼的数量分别等于输入的羊和狼的数量。
     * 当剩余的羊和狼都大于0时，执行以下操作： a. 如果剩余羊的数量大于等于剩余狼的数量，农夫运送尽可能多的羊，但不超过船的容量。然后从剩余的羊中减去运送的数量。 b. 否则，农夫运送尽可能多的狼，但不超过船的容量。然后从剩余的狼中减去运送的数量。 c. 如果在运送后剩余的狼数量大于剩余的羊数量且剩余的羊数量大于0，输出0，因为在这种情况下，羊会被狼攻击。 d. 最后，增加步数。
     * 返回步数作为解。
     * 复杂度分析：
     * 时间复杂度：本算法的时间复杂度为O(min(sheep, wolf))，因为在最坏的情况下，我们需要运送羊和狼的最小数量的次数。然而，在实际问题中，羊和狼的数量通常较小，因此算法的执行速度相对较快。
     * <p>
     * 空间复杂度：本算法的空间复杂度为O(1)，因为我们仅使用了几个变量来存储羊、狼和船的相关数量以及步数。这意味着算法在空间上是高效的。
     */

    public static int minSteps(int sheep, int wolf, int capacity) {
        if (capacity == 1) {
            return wolf > 0 ? 0 : sheep;
        }

        if (wolf > sheep) {
            return 0;
        }

        int steps = 0;
        int remainingSheep = sheep;
        int remainingWolf = wolf;
        while (remainingSheep > 0 || remainingWolf > 0) {
            if (remainingSheep >= remainingWolf) {
                int toCarry = remainingSheep <= capacity ? remainingSheep : capacity;
                remainingSheep -= toCarry;
            } else {
                int toCarry = remainingWolf <= capacity ? remainingWolf : capacity;
                remainingWolf -= toCarry;
            }

            if (remainingWolf > remainingSheep && remainingSheep > 0) {
                return 0;
            }

            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sheep = scanner.nextInt();
        int wolf = scanner.nextInt();
        int capacity = scanner.nextInt();

        int steps = minSteps(sheep, wolf, capacity);
        System.out.println(steps);
    }
}
