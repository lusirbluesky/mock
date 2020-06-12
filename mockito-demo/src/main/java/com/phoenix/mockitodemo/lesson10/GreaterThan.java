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
public class GreaterThan<T extends Number> extends BaseMatcher<T> {

    private final T value;

    public GreaterThan(T value) {
        this.value = value;
    }

    @Override
    public boolean matches(Object actual) {
        Class<?> actualClass = actual.getClass();
        if (actualClass == Byte.class){
            return (Byte) actual > (Byte) value;
        }else if (actualClass == Short.class){
            return (Short) actual > (Short) value;
        }else if (actualClass == Integer.class){
            return (Integer) actual > (Integer) value;
        }else if (actualClass == Long.class){
            return (Long) actual > (Long) value;
        }else if (actualClass == Float.class){
            return (Float) actual > (Float) value;
        }else if (actualClass == Double.class){
            return (Double) actual > (Double) value;
        }else{
            throw new AssertionError("The number type "+actualClass+" is not supported.");
        }
    }

    @Factory
    public static <T extends Number> GreaterThan<T> gt(T value){
        return new GreaterThan<>(value);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare to number failed.");
    }
}
