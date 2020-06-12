package com.phoenix.powermockdemo.lesson02;

import com.phoenix.powermockdemo.common.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 15:57
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson02
 * @Description：
 * powermock   ->   mock局部变量
 *
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
//@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryUserCount() {
        try {
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doReturn(10).when(userDao).getCount();
            int result = userService.queryUserCount();
            assertEquals(10, result);
        } catch (Throwable e) {
            fail();
        }
    }

    @Test
    public void saveUser() {
        try {
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            User user = new User();
            doNothing().when(userDao).insertUser(user);
            userService.saveUser(user);
            verify(userDao,times(1)).insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}