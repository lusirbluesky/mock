package com.phoenix.powermockdemo.lesson01;

import com.phoenix.powermockdemo.common.User;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 14:36
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson01
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount(){
        return userDao.getCount();
    }

    public void saveUser(User user){
        userDao.insertUser(user);
    }
}
