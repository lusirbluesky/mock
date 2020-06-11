package com.phoenix.mockitodemo.lesson04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 15:26
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson04
 * @Description：
 * Junit3中没有annotation
 * setUp()
 * tearDown()
 * 在Junit4中可以使用注解
 * @Before
 * @After
 *
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {
    private List<String> list;

    @Before
    public void init(){
        this.list = mock(ArrayList.class);
    }

    @Test
    public void howToUseStubbing(){
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));
    }

    @Test
    public void howToUseStubbing2(){
        when(list.get(anyInt())).thenThrow(new RuntimeException());
        try {
            list.get(0);
            fail();
        } catch (Exception e) {
            //e.printStackTrace();
            // 校验有返回值方法是否执行->assertThat()
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void howToStubbingVoidMethod(){
        doNothing().when(list).clear();
        list.clear();
        // 校验无返回值方法是否执行->verify()
        verify(list, times(1)).clear();
    }

    @Test
    public void howToStubbingVoidMethod2(){
        doThrow(RuntimeException.class).when(list).clear();
        try {
            list.clear();
            fail();
        } catch (Exception e) {
            // e.printStackTrace();
            assertThat(e, instanceOf(RuntimeException.class));
        }

    }

    @Test
    public void stubbingDoReturn(){
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);
        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1), equalTo("second"));
    }

    @Test
    public void iterateStubbing(){
        // 后面覆盖前面，list.size() == 4
        when(list.size()).thenReturn(1);
        when(list.size()).thenReturn(2);
        when(list.size()).thenReturn(3);
        when(list.size()).thenReturn(4);
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void iterateStubbing2(){
        // 第一次是1，第二次是2，第三次是3，第四及n次是4
//        when(list.size()).thenReturn(1, 2, 3, 4);
        when(list.size()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4);
        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void stubbingWithAnswer(){
        when(list.get(anyInt())).thenAnswer(invocationOnMock -> {
            Integer index = invocationOnMock.getArgumentAt(0, Integer.class);
            return String.valueOf(index * 10);
        });
        assertThat(list.get(0), equalTo("0"));
        assertThat(list.get(10), equalTo("100"));
        assertThat(list.get(999), equalTo("9990"));
    }

    @Test
    public void stubbingWithRealCall(){
        // mock得到的service是通过cglib得到的一个代理对象
        //class com.phoenix.mockitodemo.lesson04.StubbingService$$EnhancerByMockitoWithCGLIB$$9208903
        StubbingService stubbingService = mock(StubbingService.class);
        System.out.println(stubbingService.getClass());
        String s = stubbingService.getS();
        System.out.println("getS："+s);
        int i = stubbingService.getI();
        System.out.println("getI："+i);

    }

    @Test
    public void stubbingWithRealCall2(){
        StubbingService service = mock(StubbingService.class);
        when(service.getS()).thenReturn("phoenix");
        assertThat(service.getS(), equalTo("phoenix"));
        when(service.getI()).thenCallRealMethod();
        assertThat(service.getI(), equalTo(10));
    }

    @After
    public void destory(){
        reset(this.list);
    }


}
