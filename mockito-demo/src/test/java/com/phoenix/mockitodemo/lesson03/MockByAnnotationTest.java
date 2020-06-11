package com.phoenix.mockitodemo.lesson03;

import com.phoenix.mockitodemo.common.Account;
import com.phoenix.mockitodemo.common.AccountDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/11 14:18
 * @Project：mock
 * @Package：com.phoenix.mockitodemo.lesson03
 * @Description：
 * @Modified By：
 * @Version: V1.0
 */
public class MockByAnnotationTest {

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock(){
        Account account = accountDao.findAccount("x", "x");
        System.out.println(account);
    }
}
