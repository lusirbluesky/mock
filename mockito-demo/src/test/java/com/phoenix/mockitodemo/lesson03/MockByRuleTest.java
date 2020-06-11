package com.phoenix.mockitodemo.lesson03;

import com.phoenix.mockitodemo.common.Account;
import com.phoenix.mockitodemo.common.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 14:29
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson03
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class MockByRuleTest {

    /**
     * The @Rule 'mockitoRule' must be public.
     */
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    private AccountDao accountDao;

    @Test
    public void testMock(){
        AccountDao accountDao = mock(AccountDao.class);
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }

    @Test
    public void testMock2(){
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }
}
