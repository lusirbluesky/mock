package com.phoenix.mockitodemo.lesson10.custom;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 11:08
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson10.customer
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public interface Compare<T extends Number> {
    boolean compare(T expected, T actual);
}
