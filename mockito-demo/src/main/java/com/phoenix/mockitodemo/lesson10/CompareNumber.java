package com.phoenix.mockitodemo.lesson10;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 9:40
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson10
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class CompareNumber<T extends Number> extends BaseMatcher<T> {

    private final T value;

    private final boolean greater;

    public CompareNumber(T value, boolean greater) {
        this.value = value;
        this.greater = greater;
    }

    @Override
    public boolean matches(Object actual) {
        Class<?> actualClass = actual.getClass();
        if (actualClass == Byte.class){
            return greater ? (Byte) actual > (Byte) value :  (Byte) actual < (Byte) value;
        }else if (actualClass == Short.class){
            return greater ? (Short) actual > (Short) value : (Short) actual < (Short) value;
        }else if (actualClass == Integer.class){
            return greater ? (Integer) actual > (Integer) value : (Integer) actual < (Integer) value;
        }else if (actualClass == Long.class){
            return greater ? (Long) actual > (Long) value : (Long) actual < (Long) value;
        }else if (actualClass == Float.class){
            return greater ? (Float) actual > (Float) value : (Float) actual < (Float) value;
        }else if (actualClass == Double.class){
            return greater ? (Double) actual > (Double) value : (Double) actual < (Double) value;
        }else{
            throw new AssertionError("The number type "+actualClass+" is not supported.");
        }
    }

    @Factory
    public static <T extends Number> CompareNumber<T> gt(T value){
        return new CompareNumber<>(value, true);
    }
    @Factory
    public static <T extends Number> CompareNumber<T> lt(T value){
        return new CompareNumber<>(value, false);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare to number failed.");
    }
}
