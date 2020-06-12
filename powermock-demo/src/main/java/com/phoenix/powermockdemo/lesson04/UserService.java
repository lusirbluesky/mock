package com.phoenix.powermockdemo.lesson04;

import com.phoenix.powermockdemo.common.User;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 16:57
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson04
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
