package com.phoenix.mockitodemo.lesson03;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 14:37
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson03
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class DeepMockTest {

    @Mock
    private Lesson03Service lesson03Service;


    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     * java.lang.NullPointerException
     */
    @Test
    public void testDeepMock(){
        Lesson03 lesson03 = lesson03Service.get();
        lesson03.foo();
    }
    @Mock
    private Lesson03 lesson03;
    @Test
    public void testDeepMock2(){
        when(lesson03Service.get()).thenReturn(lesson03);
        lesson03.foo();
    }

    /**
     * stubbling
     */
    @Test
    public void testDeepMock3(){
        when(lesson03Service.get()).thenReturn(lesson03);
        Lesson03 lesson03 = lesson03Service.get();
        lesson03.foo();
    }

}
