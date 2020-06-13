package com.phoenix.powermockdemo.lesson08;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/13 6:48
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson08
 * @Description：
 *
 * mock需要类，默认模拟虚拟对象行为
 * spy需要实例，默认模拟真实对象行为
 * spy模拟的对象，如果符合断言就执行断言，否则执行真实调用
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
@PowerMockRunnerDelegate
public class UserServiceTest {

    @Test
    public void fooWithMock() {
        UserService userService = PowerMockito.mock(UserService.class);
        userService.foo();
    }

    @Test
    public void fooWithSpy() {
        UserService userService = PowerMockito.spy(new UserService());
        userService.foo();
    }

    /**
     * spy如果符合断言就执行断言，否则执行真实
     */
    @Test
    public void foo2WithSpy(){
        UserService userService = PowerMockito.spy(new UserService());
        System.out.println(userService);
        // com.phoenix.powermockdemo.lesson08.UserService$$EnhancerByMockitoWithCGLIB$$135b816a@77cd7a0
        String arg = "hello spy";
        PowerMockito.doNothing().when(userService).foo2(arg);
        userService.foo2(arg);
        //userService.foo2("hello mock");
    }

    @Test
    public void checkExist(){
        try {
            UserService userService = PowerMockito.spy(new UserService());
            PowerMockito.doReturn(true).when(userService,"checkExist","phoenix");
            Assert.assertTrue(userService.exist("phoenix"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}