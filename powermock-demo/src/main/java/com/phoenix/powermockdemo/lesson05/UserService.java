package com.phoenix.powermockdemo.lesson05;

import com.phoenix.powermockdemo.common.User;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 17:20
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson05
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class UserService {
    public void saveOrUpdate(User user){
        UserDao userDao = new UserDao();
        if (userDao.getCount(user) > 0){
            userDao.updateUser(user);
        }else{
            userDao.insertUser(user);
        }
    }
}
