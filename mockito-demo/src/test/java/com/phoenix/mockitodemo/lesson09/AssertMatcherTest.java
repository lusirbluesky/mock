package com.phoenix.mockitodemo.lesson09;

import org.junit.Test;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.either;
import static org.junit.Assert.assertThat;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 8:52
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson09
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class AssertMatcherTest {

    @Test
    public void test(){
        int i = 10;
        assertThat(i, equalTo(10));
        assertThat(i, not(equalTo(20)));
        assertThat(i,is(10));
        assertThat(i,is(not(20)));
    }

    @Test
    public void test2(){
        double price = 23.45;
        assertThat(price, either(equalTo(23.45)).or(equalTo(23.54)));
        //assertThat(price, both(equalTo(23.45)).and(equalTo(23.54)));
        assertThat(price, both(equalTo(23.45)).and(not(equalTo(23.54))));
        assertThat(price,anyOf(is(23.45),is(23.54),is(54.23),is(54.32)));

        assertThat(price,allOf(is(23.45),not(is(23.54)),not(is(54.23)),not(54.32)));

        assertThat(Stream.of(1,2,3).allMatch(i -> i > 0),equalTo(true));
        assertThat(Stream.of(1,2,3).anyMatch(i -> i > 2),equalTo(true));
    }

    @Test
    public void test3(){
        double price = 23.45;
        //assertThat("The double value assertion failed.", price, either(equalTo(23.451)).or(equalTo(23.54)));
    }

}
