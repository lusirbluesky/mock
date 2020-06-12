package com.phoenix.powermockdemo.lesson05;

import com.phoenix.powermockdemo.common.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 17:28
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson05
 * @Description：
 * 一切皆可mock
 * powermock -> verify
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void saveOrUpdateWillUseNewJoiner() {
        try {
            User user = PowerMockito.mock(User.class);
            UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            PowerMockito.when(userDao.getCount(user)).thenReturn(0);
//            PowerMockito.doNothing().when(userDao).insertUser(user);
//            PowerMockito.doNothing().when(userDao).updateUser(user);
            UserService userService = new UserService();
            userService.saveOrUpdate(user);

//            Mockito.verify(userDao,Mockito.times(1)).insertUser(user);
//            Mockito.verify(userDao,Mockito.times(0)).updateUser(user);
            Mockito.verify(userDao).insertUser(user);
            Mockito.verify(userDao,Mockito.never()).updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void saveOrUpdateWillUseUpdateOriginal() {
        try {
            User user = PowerMockito.mock(User.class);
            UserDao userDao = PowerMockito.mock(UserDao.class);
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            PowerMockito.when(userDao.getCount(user)).thenReturn(1);
            UserService userService = new UserService();
            userService.saveOrUpdate(user);

//            Mockito.verify(userDao,Mockito.times(0)).insertUser(user);
//            Mockito.verify(userDao,Mockito.times(1)).updateUser(user);
            Mockito.verify(userDao,Mockito.never()).insertUser(user);
            Mockito.verify(userDao).updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}