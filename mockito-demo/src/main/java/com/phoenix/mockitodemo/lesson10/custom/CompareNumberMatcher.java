package com.phoenix.mockitodemo.lesson10.custom;

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
public class CompareNumberMatcher<T extends Number> extends BaseMatcher<T> {

    private final T value;

    private final Compare COMPARE;

    public CompareNumberMatcher(T value, boolean greater) {
        this.value = value;
        this.COMPARE = new DefaultNumberCompare(greater);
    }

    @Override
    public boolean matches(Object actual) {
        return this.COMPARE.compare(value, (T) actual);
    }

    @Factory
    public static <T extends Number> CompareNumberMatcher<T> gt(T value){
        return new CompareNumberMatcher<>(value, true);
    }
    @Factory
    public static <T extends Number> CompareNumberMatcher<T> lt(T value){
        return new CompareNumberMatcher<>(value, false);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("compare to number failed.");
    }
}
