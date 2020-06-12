package com.phoenix.powermockdemo.lesson04;

import com.phoenix.powermockdemo.common.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 16:59
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson04
 * @Description：
 * powermock   ->    mock final类
 * mockito    ->    不能mock由final类，匿名类和原始类型
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserDao.class)
public class UserServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void queryUserCountWithPowerMockito(){
        UserDao dao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(10);
        UserService service = new UserService(userDao);
        int result = service.queryUserCount();
        Assert.assertEquals(10, result);
    }

    /**
     * Mockito cannot mock/spy following:
     *   - final classes
     *   - anonymous classes
     *   - primitive types
     */
    @Mock
    private UserDao userDao;

    @Ignore
    @Test
    public void queryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);
    }

    @Test
    public void saveUser() {
        UserDao dao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(dao).insertUser(user);
        UserService service = new UserService(dao);
        service.saveUser(user);
        Mockito.verify(dao,Mockito.times(1)).insertUser(user);
    }
}