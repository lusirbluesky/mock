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
public class CompareNumber2<T extends Number> extends BaseMatcher<T> {

    private final T value;

    private final Compare COMPARE;

    public CompareNumber2(T value, boolean greater) {
        this.value = value;
        this.COMPARE = new DefaultNumberCompare(greater);
    }

    @Override
    public boolean matches(Object actual) {
        return this.COMPARE.compare(value, (T) actual);
    }

    @Factory
    public static <T extends Number> CompareNumber2<T> gt(T value){
        return new CompareNumber2<>(value, true);
    }
    @Factory
    public static <T extends Number> CompareNumber2<T> lt(T value){
        return new CompareNumber2<>(value, false);
    }

    private interface Compare<T extends Number>{
        boolean compare(T expected, T actual);
    }

    private static class DefaultNumberCompare<T extends Number> implements Compare<T>{

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

    @Override
    public void describeTo(Description description) {
        description.appendText("compare to number failed.");
    }
}
