package com.phoenix.mockitodemo.lesson08;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 6:57
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson08
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class SimpleService {
    public int method1(int i, String s, Collection<?> c, Serializable ser){
        throw new RuntimeException();
    }
    public void method2(int i, String s, Collection<?> c, Serializable ser){
        throw new RuntimeException();
    }
}
