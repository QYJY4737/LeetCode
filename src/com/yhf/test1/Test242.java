package com.yhf.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test242 {
    /**
     * 题目0242-天然蓄水库
     * 题目描述
     * 公元2919年，人类终于发现了一颗宜居星球——X星。
     * 现想在X星一片连绵起伏的山脉间建一个天热蓄水库，如何选取水库边界，使蓄水量最大？
     * <p>
     * 要求：
     * <p>
     * 山脉用正整数数组s表示，每个元素代表山脉的高度。
     * 选取山脉上两个点作为蓄水库的边界，则边界内的区域可以蓄水，蓄水量需排除山脉占用的空间
     * 蓄水量的高度为两边界的最小值。
     * 如果出现多个满足条件的边界，应选取距离最近的一组边界。
     * 输出边界下标（从0开始）和最大蓄水量；如果无法蓄水，则返回0，此时不返回边界。
     * 例如，当山脉为s=[3,1,2]时，则选取s[0]和s[2]作为水库边界，则蓄水量为1，此时输出：0 2:1
     * 当山脉s=[3,2,1]时，不存在合理的边界，此时输出：0。
     * <p>
     * 输入描述
     * 一行正整数，用空格隔开，例如输入
     * <p>
     * 1 2 3
     * 表示s=[1,2,3]
     * <p>
     * 输出描述
     * 当存在合理的水库边界时，输出左边界、空格、右边界、英文冒号、蓄水量；例如
     * <p>
     * 0 2:1
     * 当不存在合理的书库边界时，输出0；例如
     * <p>
     * 0
     * 备注
     * 1 <= length(s) <= 10000
     * 0 <= s[i] <= 10000
     * <p>
     * 示例一
     * 输入
     * 1 9 6 2 5 4 9 3 7
     * 输出
     * 1 6:19
     * 说明
     * 经过分析，选取s[1]和s[6]，水库蓄水量为19（3+7+4+5）
     * <p>
     * 示例二
     * 输入
     * 1 8 6 2 5 4 8 3 7
     * 输出
     * 1 6:15
     * 说明
     * 经过分析，选取s[1]和s[8]时，水库蓄水量为15；同样选取s[1]和s[6]时，水库蓄水量也为15。由于后者下标距离小（为5），故应选取后者。
     * <p>
     * 示例三
     * 输入
     * 1 2 3
     * 输出
     * 0
     * 说明
     * 不存在合理的水库边界
     * <p>
     * 思路解析和复杂度分析
     * 该题目可以采用双指针的思想来解决。主要的思想是，我们维护两个指针，分别位于输入数组的两端。初始时，左指针位于数组的最左端，右指针位于数组的最右端。我们维护两个变量 maxLeft 和 maxRight，表示左右指针分别指向的山脉的最大高度。
     * <p>
     * 然后，我们将指针从数组两端向中间移动。如果左指针指向的山脉的高度小于右指针指向的山脉的高度，那么就移动左指针，并更新 maxLeft。反之，移动右指针，并更新 maxRight。在每次移动指针之后，我们计算并更新可以蓄水的最大面积。
     * <p>
     * 需要注意的是，这种解法基于一个假设，即在任意时刻，可蓄水的最大面积都受到 maxLeft 和 maxRight 中的较小值以及两个指针之间的距离的限制。这是因为，如果我们试图将指针向较高的山脉移动，那么新计算的面积一定小于之前的面积，因此我们总是向较低的山脉移动。
     * <p>
     * 在完成上述步骤之后，我们就找到了可以蓄水的最大面积，以及形成这个面积的两个山脉的位置。
     * <p>
     * 复杂度分析：这种方法的时间复杂度为 O(n)，其中 n 为输入数组的长度。这是因为我们只需要对数组进行一次遍历，就可以找到答案。空间复杂度为 O(1)，我们只需要常数级别的空间来存储变量。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> s = new ArrayList<>();
        //输入数组
        while (scanner.hasNextInt()) {
            s.add(scanner.nextInt());
        }

        //分别从左右两端向中间寻找，如果左端较低，则寻找左侧最高的，如果右端较低，寻找右侧最高的
        int left = 0, right = s.size() - 1;
        int max_left = s.get(0), max_right = s.get(s.size() - 1);
        int max_area = 0, area = 0;
        int max_i = 0, max_j = s.size() - 1;

        while (left < right) {
            if (s.get(left) < s.get(right)) {
                if (s.get(left) > max_left) {
                    max_left = s.get(left);
                }
                area = (right - left) * Math.min(max_left, max_right);
                left++;
            } else {
                if (s.get(right) > max_right) {
                    max_right = s.get(right);
                }
                area = (right - left) * Math.min(max_left, max_right);
                right--;
            }
            if (area > max_area) {
                max_area = area;
                max_i = left;
                max_j = right;
            }
        }

        //最后输出最大蓄水量，如果蓄水量为0，则输出0，否则输出两个边界下标和蓄水量
        if (max_area == 0) {
            System.out.println(0);
        } else {
            //注意减去山脉占用的空间
            for (int i = max_i; i < max_j; i++) {
                max_area -= s.get(i);
            }
            System.out.println(max_i + " " + max_j + ":" + max_area);
        }
    }
}
