package com.yhf.test2;

import java.util.Observer;
import java.util.Vector;

/**
 * Created on 2023/8/28.
 *
 * @author qyjy4737
 */
public abstract class Subject {
    // 定义一个观察者数组
    private Vector obsVector = new Vector();

    // 增加一个观察者
    public void addObserver(Observer o) {
        this.obsVector.add(o);
    }

    // 删除一个观察者
    public void delObserver(Observer o) {
        this.obsVector.remove(o);
    }

}
