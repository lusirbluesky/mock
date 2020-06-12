package com.phoenix.mockitodemo.lesson10.custom;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 11:09
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson10.customer
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class DefaultNumberCompare<T extends Number> implements Compare<T> {

    private final boolean greater;

    public DefaultNumberCompare(boolean greater) {
        this.greater = greater;
    }

    @Override
    public boolean compare(T expected, T actual) {
        Class<?> actualClass = actual.getClass();
        if (actualClass == Byte.class){
            return greater ? (Byte) actual > (Byte) expected :  (Byte) actual < (Byte) expected;
        }else if (actualClass == Short.class){
            return greater ? (Short) actual > (Short) expected : (Short) actual < (Short) expected;
        }else if (actualClass == Integer.class){
            return greater ? (Integer) actual > (Integer) expected : (Integer) actual < (Integer) expected;
        }else if (actualClass == Long.class){
            return greater ? (Long) actual > (Long) expected : (Long) actual < (Long) expected;
        }else if (actualClass == Float.class){
            return greater ? (Float) actual > (Float) expected : (Float) actual < (Float) expected;
        }else if (actualClass == Double.class){
            return greater ? (Double) actual > (Double) expected : (Double) actual < (Double) expected;
        }else{
            throw new AssertionError("The number type "+actualClass+" is not supported.");
        }
    }
}
