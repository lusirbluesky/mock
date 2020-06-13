package com.phoenix.powermockdemo.lesson08;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/13 6:47
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson08
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class UserService {
    public void foo(){
        log();
    }

    private void log() {
        System.out.println("I am a console log.");
    }

    public void foo2(String arg){
        log2(arg);
    }

    private void log2(String arg) {
        System.out.println("I am a console log." + " -> " + arg);
    }

    public boolean exist(String username){
        return checkExist(username);
    }

    private boolean checkExist(String username) {
        throw new UnsupportedOperationException();
    }
}
