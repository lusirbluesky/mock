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
public class UserDao {
    private String username;
    private String password;
    public UserDao(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void insert() {
        throw new UnsupportedOperationException();
    }
}
