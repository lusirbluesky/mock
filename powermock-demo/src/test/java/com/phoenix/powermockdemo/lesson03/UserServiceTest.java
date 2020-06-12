package com.phoenix.powermockdemo.lesson03;

import com.phoenix.powermockdemo.common.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 16:20
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson03
 * @Description：
 * powermock   ->   mock静态方法
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserDao.class})
public class UserServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryUserCount() {
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.when(UserDao.getCount()).thenReturn(10);
        UserService userService = new UserService();
        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);
    }

    @Test
    public void saveUser() {
        PowerMockito.mockStatic(UserDao.class);
        PowerMockito.doNothing().when(UserDao.class);
        UserService userService = new UserService();
        userService.saveUser(new User());
        PowerMockito.verifyStatic();
    }
}