package com.phoenix.powermockdemo.lesson06;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 17:57
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson06
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class UserService {
    public void save(String username, String password){
        UserDao userDao = new UserDao(username, password);
        userDao.insert();
    }
}
