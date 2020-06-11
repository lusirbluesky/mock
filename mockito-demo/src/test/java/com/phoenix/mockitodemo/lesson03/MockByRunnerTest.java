package com.phoenix.mockitodemo.lesson03;

import com.phoenix.mockitodemo.common.Account;
import com.phoenix.mockitodemo.common.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 14:03
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson03
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    /**
     * 默认返回null
     */
    @Test
    public void testMock(){
        AccountDao accountDao = mock(AccountDao.class);
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }

    /**
     * 返回空串
     */
    @Test
    public void testMock2(){
        AccountDao accountDao = mock(AccountDao.class, Mockito.RETURNS_SMART_NULLS);
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }
}
