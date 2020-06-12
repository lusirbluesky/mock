package com.phoenix.powermockdemo.lesson01;

import com.phoenix.powermockdemo.common.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 14:42
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson01
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class UserServiceJunit4Test {

    private UserService userService;

    @Before
    public void setUp(){
        userService = new UserService(new UserDao());
    }

    @Test
    public void queryUserCountWithJunit4() {
        try {
            userService.queryUserCount();
            fail("should not process to here.");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }


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

    @Test(expected = UnsupportedOperationException.class)
    public void saveUserWithJunit() throws UnsupportedOperationException {
        userService.saveUser(new User());
        fail("should not process to here.");
    }
}