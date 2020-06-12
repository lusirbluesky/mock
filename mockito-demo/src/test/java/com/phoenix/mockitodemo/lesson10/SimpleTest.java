package com.phoenix.mockitodemo.lesson10;

import org.junit.Test;

import static com.phoenix.mockitodemo.lesson10.custom.CompareNumberMatcher.gt;
import static com.phoenix.mockitodemo.lesson10.custom.CompareNumberMatcher.lt;
import static org.hamcrest.Matchers.both;
import static org.junit.Assert.assertThat;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 9:37
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson10
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class SimpleTest {
    @Test
    public void test(){
        assertThat(10,gt(5));
        assertThat(10,lt(20));
        assertThat(10,both(gt(8)).and(lt(18)));
    }
}
