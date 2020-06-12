package com.phoenix.mockitodemo.lesson08;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 6:50
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson08
 * @Description：
 * 添加了runner可以不用初始化annotation
 * 保持好习惯
 * 如果mock的资源是全局的，最好最后destroy重置reset资源
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class WildcardArgumentMatcherTest {

    @Mock
    private SimpleService simpleService;

    @Test
    public void wildcardMethod1(){
        when(simpleService.method1(anyInt(),anyString(),anyCollection(), isA(Serializable.class))).thenReturn(100);
        int result = simpleService.method1(1, "phoenix", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(100));

        result = simpleService.method1(1, "斗罗大陆", Collections.emptyList(), "MockitoForJava");
        assertThat(result, equalTo(100));
    }

    @Test
    public void wildcardMethod1WithSpec(){
        /*
        *
        * This exception may occur if matchers are combined with raw expecteds:
        *       //incorrect:
        *       someMethod(anyObject(), "raw String");
        * When using matchers, all arguments have to be provided by matchers.
        * For example:
        *       //correct:
        *       someMethod(anyObject(), eq("String by matcher"));
        *
        * */
//      incorrect
//        when(simpleService.method1(anyInt(),"phoenix",anyCollection(), isA(Serializable.class))).thenReturn(100);
//        when(simpleService.method1(anyInt(),"斗罗大陆",anyCollection(), isA(Serializable.class))).thenReturn(200);
//      correct
        when(simpleService.method1(anyInt(),eq("phoenix"),anyCollection(), isA(Serializable.class))).thenReturn(100);
        when(simpleService.method1(anyInt(),eq("斗罗大陆"),anyCollection(), isA(Serializable.class))).thenReturn(200);
        int result = simpleService.method1(1, "phoenix", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(100));

        result = simpleService.method1(1, "斗罗大陆", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(200));

        result = simpleService.method1(1, "昊天宗", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(0));
    }

    @Test
    public void wildcardMethod2(){
        // Collections.emptyList()传参两次，相当于两个对象，提取公共使用
        doNothing().when(simpleService).method2(anyInt(),anyString(),anyCollection(), isA(Serializable.class));
        List<Object> c = Collections.emptyList();
        simpleService.method2(1, "phoenix", c, "Mockito");
        // 全部使用具体数据
        verify(simpleService, times(1)).method2(1, "phoenix", c, "Mockito");
    }
    @Test
    public void wildcardMetho3(){
        // Collections.emptyList()传参两次，相当于两个对象，提取公共使用
        doNothing().when(simpleService).method2(anyInt(),anyString(),anyCollection(), isA(Serializable.class));
        simpleService.method2(1, "phoenix", Collections.emptyList(), "Mockito");
        // 全部使用具体数据
        verify(simpleService, times(1)).method2(1, "phoenix", Collections.emptyList(), "Mockito");
        // 全部使用Matchers
        verify(simpleService, times(1)).method2(eq(1), eq("phoenix"), anyCollection(), isA(Serializable.class));
        verify(simpleService, times(1)).method2(anyInt(), eq("phoenix"), anyCollection(), isA(Serializable.class));
        verify(simpleService, times(1)).method2(anyInt(), anyString(), anyCollection(), isA(Serializable.class));
    }

    @Test
    public void wildcardMethod1WithSpec2(){
        // 全集放在最上面，子集放在下面（某些特定值的时候返回特定值，不是特定值返回通用值）
        // 全集（共性）
        when(simpleService.method1(anyInt(),anyString(),anyCollection(), isA(Serializable.class))).thenReturn(-1);
        // 子集（个性）
        when(simpleService.method1(anyInt(),eq("phoenix"),anyCollection(), isA(Serializable.class))).thenReturn(100);
        when(simpleService.method1(anyInt(),eq("斗罗大陆"),anyCollection(), isA(Serializable.class))).thenReturn(200);
        int result = simpleService.method1(1, "phoenix", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(100));

        result = simpleService.method1(1, "斗罗大陆", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(200));

        result = simpleService.method1(1, "昊天宗", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(-1));
    }

    @Test
    public void wildcardMethod1WithSpec3(){
        // 全集放在最下面，子集被覆盖导致所有特定值失效
        // 子集
        when(simpleService.method1(anyInt(),eq("phoenix"),anyCollection(), isA(Serializable.class))).thenReturn(100);
        when(simpleService.method1(anyInt(),eq("斗罗大陆"),anyCollection(), isA(Serializable.class))).thenReturn(200);
        // 全集
        when(simpleService.method1(anyInt(),anyString(),anyCollection(), isA(Serializable.class))).thenReturn(-1);
        int result = simpleService.method1(1, "phoenix", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(-1));

        result = simpleService.method1(1, "斗罗大陆", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(-1));

        result = simpleService.method1(1, "昊天宗", Collections.emptyList(), "Mockito");
        assertThat(result, equalTo(-1));
    }

    @After
    public void destroy(){
        reset(simpleService);
    }
}
