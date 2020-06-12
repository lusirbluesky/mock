package com.phoenix.mockitodemo.lesson07;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 21:12
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson07
 * @Description：
 * 对应静态类或方法可以不用使用runner
 * 即不用在类上添加
 * @RunWith(MockitoJUnitRunner.class)
 *
 * @Modified By：
 * @Version: V1.0
 */
public class ArgumentMatcherTest {

    @Test
    public void basicTest(){
        List list = mock(ArrayList.class);
        //when(list.get(0)).thenReturn(100);
        when(list.get(eq(0))).thenReturn(100);
        assertThat(list.get(0), equalTo(100));
        assertThat(list.get(1),nullValue());
    }

    /**
     * isA & any
     */
    @Test
    public void testComplex(){
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Parent.class))).thenReturn(100);
        int result = foo.function(new Child1());
        assertThat(result, equalTo(100));

        result = foo.function(new Child2());
        assertThat(result, equalTo(100));
    }

    @Test
    public void testComplex2(){
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Child1.class))).thenReturn(100);
        int result = foo.function(new Child1());
        assertThat(result, equalTo(100));

        result = foo.function(new Child2());
        assertThat(result, equalTo(0));
    }

    @Test
    public void testComplex3(){
        Foo foo = mock(Foo.class);
        when(foo.function(Mockito.isA(Child1.class))).thenReturn(100);
        int result = foo.function(new Child1());
        assertThat(result, equalTo(100));

        result = foo.function(new Child2());
        assertThat(result, equalTo(0));

        reset(foo);
        // any
        when(foo.function(Mockito.any(Child1.class))).thenReturn(100);
        result = foo.function(new Child2());
        assertThat(result, equalTo(100));
    }

    static class Foo{
        int function(Parent parent){
            return parent.work();
        }
    }
    interface Parent{
        int work();
    }
    class Child1 implements Parent{

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }
    class Child2 implements Parent{

        @Override
        public int work() {
            throw new RuntimeException();
        }
    }
}
