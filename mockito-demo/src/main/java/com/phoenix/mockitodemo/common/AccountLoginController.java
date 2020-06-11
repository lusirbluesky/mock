package com.phoenix.mockitodemo.common;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 11:04
 * @Project：mock
 * @Package：com.phoenix.mockitodemo
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request){
        final String userName = request.getParameter("userName");
        final String password = request.getParameter("password");
        try {
            Account account = accountDao.findAccount(userName, password);
            if (account == null){
                return "/login";
            }else{
                return "/index";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/505";
        }
    }
}
