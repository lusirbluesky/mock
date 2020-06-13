package com.phoenix.powermockdemo.lesson06;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 18:02
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson06
 * powermock   ->     构造函数
 * 带参数的构造函数
 * mock方法中的公共参数必须相同
 *
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void save() {
        try {
            UserDao userDao = PowerMockito.mock(UserDao.class);
            String username="斗罗大陆";
            String password="phoenix";
            PowerMockito.whenNew(UserDao.class).withArguments(username,password).thenReturn(userDao);
            PowerMockito.doNothing().when(userDao).insert();
            UserService userService = new UserService();
            //userService.save("星辰变",password);
            userService.save(username,password);
            Mockito.verify(userDao,Mockito.times(1)).insert();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}