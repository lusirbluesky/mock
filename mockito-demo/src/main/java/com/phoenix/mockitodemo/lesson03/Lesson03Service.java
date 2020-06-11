package com.phoenix.mockitodemo.lesson03;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 14:39
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson03
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class Lesson03Service {
    public Lesson03 get(){
        throw  new RuntimeException();
    }
}
