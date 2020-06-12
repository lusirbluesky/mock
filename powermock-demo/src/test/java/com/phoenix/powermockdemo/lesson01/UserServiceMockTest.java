package com.phoenix.powermockdemo.lesson01;

import com.phoenix.powermockdemo.common.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 14:42
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson01
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class UserServiceMockTest {

    private UserService userService;

    @Before
    public void setUp(){
        userService = new UserService(new UserDao());
    }

    @Test
    public void testQueryUserCountWithPowerMock(){
        UserDao dao = PowerMockito.mock(UserDao.class);
        //PowerMockito.doReturn(10).when(dao).getCount();
        PowerMockito.when(dao.getCount()).thenReturn(10);
        UserService service = this.userService = new UserService(dao);
        int result = service.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void testSaveUserWihPowerMock(){
        UserDao dao = PowerMockito.mock(UserDao.class);
        // 必须是同一个User
        User user = new User();
        PowerMockito.doNothing().when(dao).insertUser(user);
        UserService service = new UserService(dao);
        service.saveUser(user);
        // 无返回值用verify进行断言，判断执行次数或是否执行某个方法
        Mockito.verify(dao).insertUser(user);
    }


    @Mock
    private UserDao userDao;

    @Ignore
    @Test
    public void queryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        //Mockito.when(userService.queryUserCount()).thenReturn(10);
        Mockito.when(userDao.getCount()).thenReturn(10);
        int result = userService.queryUserCount();
        assertEquals(10, result);
    }

    @Ignore
    @Test
    public void saveUserWithJunit4() {
        try {
            userService.saveUser(new User());
            fail("should not process to here.");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
}