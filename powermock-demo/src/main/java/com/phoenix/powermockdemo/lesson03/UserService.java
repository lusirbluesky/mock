package com.phoenix.powermockdemo.lesson03;

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

    public int queryUserCount(){
        return UserDao.getCount();
    }

    public void saveUser(User user){
        UserDao.insertUser(user);
    }
}
