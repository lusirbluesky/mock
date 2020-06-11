package com.phoenix.mockitodemo.lesson06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 16:39
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson06
 * @Description：
 * Spy和Mock都是通过cglib产生的代理对象进行模拟
 * Spy默认模拟真实对象（可以部分mock），Mock默认模拟虚假的对象（可以部分真实）
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class SpyingTest {

    @Test
    public void testSpy(){
        List<String> realList = new ArrayList<>();
        List<String> list = spy(realList);
        list.add("Mockito");
        list.add("PowerMock");
        assertThat(list.get(0),equalTo("Mockito"));
        assertThat(list.get(1),equalTo("PowerMock"));
        assertThat(list.isEmpty(),equalTo(false));
    }
    @Test
    public void testSpy1(){
        List<String> realList = new ArrayList<>();
        List<String> list = spy(realList);
        list.add("Mockito");
        list.add("PowerMock");
        assertThat(list.get(0),equalTo("Mockito"));
        assertThat(list.get(1),equalTo("PowerMock"));
        assertThat(list.isEmpty(),equalTo(false));

        when(list.isEmpty()).thenReturn(true);
        when(list.size()).thenReturn(0);
        assertThat(list.get(0),equalTo("Mockito"));
        assertThat(list.get(1),equalTo("PowerMock"));
        assertThat(list.isEmpty(),equalTo(true));
        assertThat(list.size(),equalTo(0));
    }
    @Test
    public void testSpy2(){
        List<String> realList = new ArrayList<>();
        realList.add("Mockito");
        realList.add("PowerMock");
        List<String> list = spy(realList);
        assertThat(list.get(0),equalTo("Mockito"));
        assertThat(list.get(1),equalTo("PowerMock"));
    }

    @Test
    public void testMock(){
        List<String> realList = new ArrayList<>();
        realList.add("Mockito");
        realList.add("PowerMock");
        List<String> list = mock(ArrayList.class);
//        assertThat(list.get(0),equalTo("Mockito"));
//        assertThat(list.get(1),equalTo("PowerMock"));
    }
    @Test
    public void testMock2(){
        List<String> realList = new ArrayList<>();
        List<String> list = mock(ArrayList.class);
        list.add("Mockito");
        list.add("PowerMock");
//        assertThat(list.get(0),equalTo("Mockito"));
//        assertThat(list.get(1),equalTo("PowerMock"));
    }
}
