package com.phoenix.mockitodemo;

import com.phoenix.mockitodemo.common.Account;
import com.phoenix.mockitodemo.common.AccountDao;
import com.phoenix.mockitodemo.common.AccountLoginController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 11:16
 * @Project：mock
 * @Package：com.phoenix.mockitodemo
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;
    private HttpServletRequest request;
    private AccountLoginController accountLoginController;

    @Before
    public void setUp(){
        this.accountDao = mock(AccountDao.class);
        this.request = mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess(){
        Account account = new Account();
        when(request.getParameter("userName")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(account);

        String result = accountLoginController.login(request);
        System.out.println(result);
        assertThat(accountLoginController.login(request),equalTo("/index"));
    }
    @Test
    public void testLoginFail(){
        when(request.getParameter("userName")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenReturn(null);

        String result = accountLoginController.login(request);
        System.out.println(result);
        assertThat(result,equalTo("/login"));
    }

    @Test
    public void testLogin505(){
        when(request.getParameter("userName")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.findAccount(anyString(),anyString())).thenThrow(UnsupportedOperationException.class);

        assertThat(accountLoginController.login(request), equalTo("/505"));
    }
}
