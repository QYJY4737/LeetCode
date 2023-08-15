package com.yhf.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on 2023/8/15.
 *
 * @author qyjy4737
 */
public class Test230 {
    /**
     * 题目0230-相同数字组成图形的周长
     * 题目描述
     * 有一个 64×6464 \times 6464×64 的矩阵，每个元素的默认值为0，
     * 现在向里面填充数字，相同的数字组成一个实心图形，
     * 如下图所示是举行的局部(空白表示填充0)：
     * main0230.png
     * 数字1组成了蓝色边框的实心图形，数字2组成了红色边框的实心图形。
     * 单元格的边长规定为1个单位，
     * 请根据输入，计算每个非0值填充出来的实心图形的周长。
     * <p>
     * 输入描述
     * 2
     * 1 1 3 2 2 2 3 2 4 3 2 3 3 3 4 4 1 4 2 4 3 4 4 5 2 5 3
     * 2 3 7 3 8 4 5 4 6 4 7 4 8 5 4 5 5 5 6 5 7 5 8 6 4 6 5 6 6 6 7 6 8 7 4 7 5 7 6 7 7 7 8
     * 输入数据说明如下：
     * <p>
     * 第一行输入 NNN，表示共有 NNN 个图形，N>0N > 0N>0 且 N<64×64N < 64 \times 64N<64×64 ;
     * 矩阵左上角单元格坐标记作(0,0),第一个数字表示行号，第二个数字表示列号;
     * 接下来是 NNN 行，每行第一个数字是矩阵单元格填充的数字，后续每两个一组，表示填充该数字的单元格坐标;
     * 答题者无需考虑数据格式非法的场景，题目用例不考察数据格式;
     * 题目用例保证同一个填充值只会有一行输入数据
     * 输出描述
     * 18 20
     * 一共输出 NNN 个数值，每个数值表示某一行输入表示图形的周长;
     * 输出顺序需和输入的各行顺序保持一致，即第1个数是输入的第1个图形的周长，第2个数是输入的第2个图形的周长，以此类推。
     * 示例一
     * 输入
     * 2
     * 1 1 3 2 2 2 3 2 4 3 2 3 3 3 4 4 1 4 2 4 3 4 4 5 2 5 3
     * 2 3 7 3 8 4 5 4 6 4 7 4 8 5 4 5 5 5 6 5 7 5 8 6 4 6 5 6 6 6 7 6 8 7 4 7 5 7 6 7 7 7 8
     * 输出
     * 18 20
     * 思路解析和复杂度分析
     * 解题思路：
     * 本题的目标是计算每个非0值填充出来的实心图形的周长。为了解决这个问题，我们可以遵循以下步骤：
     * <p>
     * 初始化一个 64x64 的矩阵，将所有元素设置为0。
     * 读取输入数据，包括填充数字的数量 N 和每个填充数字及其对应的坐标。
     * 遍历每个填充数字，将矩阵中对应的单元格设置为填充值。
     * 对于每个填充数字，计算其形成的实心图形的周长。
     * 输出每个填充数字对应图形的周长。
     * 在计算实心图形的周长时，我们需要检查矩阵中每个单元格的上、下、左、右四个邻居。如果邻居单元格的值与当前单元格的值不相等，或者邻居单元格不存在（位于矩阵边界外），则将当前单元格的边计入周长。
     * <p>
     * 复杂度分析：
     * 时间复杂度：整个算法的时间复杂度为 O(N * SIZE^2)，其中 N 是填充数字的数量，SIZE 是矩阵的尺寸。对于每个填充数字，我们需要遍历整个矩阵，因此时间复杂度与填充数字的数量和矩阵的大小成正比。
     * <p>
     * 空间复杂度：空间复杂度为 O(SIZE^2)，因为我们需要存储一个 64x64 的矩阵。此外，我们还需要额外的空间来存储输入数据，但与矩阵相比，这部分空间消耗可以忽略不计。
     * <p>
     * 总结：
     * 本题的解决方案主要依赖于遍历整个矩阵以计算实心图形的周长。通过检查每个单元格的邻居，我们可以确定周长中的每一条边。由于矩阵的尺寸固定且较小（64x64），因此在实际运行中，算法的效率是可以接受的。
     */

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[64][64];

            for (int i = 0; i < N; i++) {
                Integer[] split = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);

                int value = split[0];
                for (int j = 1; j < split.length; j += 2) {
                    int row = split[j];
                    int col = split[j + 1];
                    matrix[row][col] = value;
                }
            }

            scanner.close();

            for (int i = 1; i <= N; i++) {
                int perimeter = calculatePerimeter(matrix, i);
                System.out.print(perimeter);
                if (i != N) {
                    System.out.print(" ");
                }
            }
        }

    }

    private static int calculatePerimeter(int[][] matrix, int value) {
        int perimeter = 0;
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                if (matrix[i][j] == value) {
                    if (i == 0 || matrix[i - 1][j] != value) perimeter++;
                    if (i == 63 || matrix[i + 1][j] != value) perimeter++;
                    if (j == 0 || matrix[i][j - 1] != value) perimeter++;
                    if (j == 63 || matrix[i][j + 1] != value) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
