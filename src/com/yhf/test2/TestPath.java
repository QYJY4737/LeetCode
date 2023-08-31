package com.yhf.test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2023/8/22.
 *
 * @author qyjy4737
 */
public class TestPath {

    public static List<Path> getPathList() {
        List<Path> pathLists = new ArrayList<>();
        try {
            String fileName = "D:\\url_path_statistics.txt";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":");
                String path = parts[0];
                int count = Integer.parseInt(parts[1]);
                Path newPath = new Path();
                newPath.setPath(path);
                newPath.setCount(count);
                pathLists.add(newPath);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<Path> newPathList = pathLists.stream().sorted(Comparator.comparingInt(Path::getCount).reversed()).limit(10).collect(Collectors.toList());
        return newPathList;
    }

    public static void main(String[] args) {
        List<Path> pathList = getPathList();
        pathList.stream().forEach(item -> {
            System.out.println(item.getPath() + "访问了" + item.getCount() + "次");
        });
    }
}

class Path {
    private String path;
    private int count;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Path{" + "path='" + path + '\'' + ", count=" + count + '}';
    }
}