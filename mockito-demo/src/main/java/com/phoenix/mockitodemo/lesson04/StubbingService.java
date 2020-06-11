package com.phoenix.mockitodemo.lesson04;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 16:20
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson04
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class StubbingService {
    public int getI(){
        System.out.println("StubbingService.getI");
        return 10;
    }

    public String getS(){
        System.out.println("StubbingService.getS");
        throw new RuntimeException();
    }
}
