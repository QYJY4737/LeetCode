package com.yhf.test1;

import java.util.*;

/**
 * Created on 2023/8/14.
 *
 * @author qyjy4737
 */
public class Test214 {
    /**
     * 题目0214-快递投放问题
     * 题目描述
     * 有N个快递站点用字符串标识，某些站点之间有道路连接。每个站点有一些包裹要运输，每个站点间的包裹不重复，
     * 路上有检查站会导致部分货物无法通行，计算哪些货物无法正常投递
     * <p>
     * 输入描述
     * 第一行输入M N，M个包裹N个道路信息. 0 <= M, N <= 100，检查站禁止通行的包裹如果有多个以空格分开
     * <p>
     * 4 2
     * package1 A C
     * package2 A C
     * package3 B C
     * package4 A C
     * A B package1
     * A C package2 package4
     * 输出描述
     * 输出不能送达的包裹
     * package2 package4,
     * 如果所有包裹都可以送达则输出none，
     * 输出结果按照升序排列
     * <p>
     * 示例一
     * 输入
     * 4 2
     * package1 A C
     * package2 A C
     * package3 B C
     * package4 A C
     * A B package1
     * A C package2
     * 输出
     * package2
     */

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] tmp =
                Arrays.stream(scanner.nextLine().split(SPACE)).map(Integer::parseInt).toArray(Integer[]::new);
        int m = tmp[0];
        int n = tmp[1];

        String[][] want = new String[m][];
        for (int i = 0; i < m; i++) {
            want[i] = scanner.nextLine().split(SPACE);
        }

        String[][] cant = new String[n][];
        for (int i = 0; i < n; i++) {
            cant[i] = scanner.nextLine().split(SPACE);
        }

        System.out.println(solution(want, cant));
    }


    public static String solution(String[][] want, String[][] cant) {
        Map<String, HashSet<String>> wantMap = new HashMap<>();
        Map<String, HashSet<String>> cantMap = new HashMap<>();

        for (String[] arr : want) {
            String pkg = arr[0];
            String path = arr[1] + "-" + arr[2];
            wantMap.putIfAbsent(path, new HashSet<>());
            wantMap.get(path).add(pkg);
        }

        for (String[] arr : cant) {
            String path = arr[0] + "-" + arr[1];
            String[] pkgs = Arrays.copyOfRange(arr, 2, arr.length);
            cantMap.putIfAbsent(path, new HashSet<>());
            cantMap.get(path).addAll(Arrays.asList(pkgs));
        }

        List<String> res = new ArrayList<>();

        for (String path : wantMap.keySet()) {
            Set<String> wantPKG = wantMap.get(path);
            Set<String> cantPKG = cantMap.get(path);

            if (cantPKG == null) {
                continue;
            }

            for (String pkg : wantPKG) {
                if (cantPKG.contains(pkg)) {
                    res.add(pkg);
                }
            }
        }

        if (res.size() == 0) {
            return "none";
        }

        res.sort(Comparator.comparingInt(a -> Integer.parseInt(a.substring(7))));

        StringJoiner joiner = new StringJoiner(SPACE);
        for (String s : res) {
            joiner.add(s);
        }
        return joiner.toString();
    }
}
