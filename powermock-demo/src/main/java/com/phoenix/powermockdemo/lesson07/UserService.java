package com.phoenix.powermockdemo.lesson07;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 21:06
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson07
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class UserService {
    public String find(String name){
        UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }
}
