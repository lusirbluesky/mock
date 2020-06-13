package com.phoenix.powermockdemo.lesson07;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @Author：phoenix
 * @Date：Created in 2020/6/12 21:09
 * @Project：mock
 * @Package：com.phoenix.powermockdemo.lesson07
 * @Description：
 *
 * mockito   ->    arguments matcher  &   Answer
 * ArgumentMatcher<String>
 * Answer
 *
 * @Modified By：
 * @Version: V1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void find() {
        try {
            UserDao userDao = PowerMockito.mock(UserDao.class);
            String name = "phoenix";
            PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            //PowerMockito.doReturn("史莱克七怪").when(userDao).queryByName(name);
            PowerMockito.when(userDao.queryByName(name)).thenReturn("史莱克七怪");
            UserService userService = new UserService();
            String result = userService.find(name);
            Assert.assertEquals("史莱克七怪",result);

            PowerMockito.when(userDao.queryByName("Alex")).thenReturn("史莱克七怪");
            result = userService.find("Alex");
            Assert.assertEquals("史莱克七怪",result);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void findWithMatcher() {
        try {
            UserDao userDao = PowerMockito.mock(UserDao.class);
            String name = "phoenix";
            PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            //PowerMockito.doReturn("史莱克七怪").when(userDao).queryByName(name);
            //PowerMockito.when(userDao.queryByName(name)).thenReturn("史莱克七怪");
            PowerMockito.when(userDao.queryByName(Matchers.argThat(new MyArgumentMatcher()))).thenReturn("史莱克七怪");
            UserService userService = new UserService();

            String result = userService.find(name);
            Assert.assertEquals("史莱克七怪",result);

            result = userService.find("唐三");
            Assert.assertEquals("史莱克七怪",result);

            result = userService.find("小舞");
            Assert.assertEquals("史莱克七怪",result);

            result = userService.find("Alex");
            Assert.assertEquals(null,result);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void findWithMAnswer() {
        try {
            UserDao userDao = PowerMockito.mock(UserDao.class);
            String name = "phoenix";
            PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            //PowerMockito.when(userDao.queryByName(Matchers.argThat(new MyArgumentMatcher()))).thenReturn("史莱克七怪");
            PowerMockito.when(userDao.queryByName(Mockito.anyString())).then(invocation -> {
                String arg = invocation.getArgumentAt(0, String.class);
                switch(arg){
                    case "phoenix":
                        return "斗罗大陆";
                    case "唐三":
                        return "千手修罗";
                    case "朱竹青":
                        return "幽冥灵猫";
                    case "小舞":
                        return "柔骨魅兔";
                    case "戴沐白":
                        return "邪眸白虎";
                    case "奥斯卡":
                        return "香肠专卖";
                    case "马红俊":
                        return "邪火凤凰";
                    case "宁蓉蓉":
                        return "九彩琉璃";
                    default:
                        throw new RuntimeException("Not support " + arg);
                }
            });
            UserService userService = new UserService();

            String result = userService.find(name);
            Assert.assertEquals("斗罗大陆",result);

            result = userService.find("唐三");
            Assert.assertEquals("千手修罗",result);

            result = userService.find("小舞");
            Assert.assertEquals("柔骨魅兔",result);

            try {
                result = userService.find("Alex");
                Assert.fail("Never process here.");
            } catch (Exception e) {
                e.printStackTrace();
                Assert.assertTrue(e instanceof RuntimeException);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    static class MyArgumentMatcher extends ArgumentMatcher<String>{

        @Override
        public boolean matches(Object o) {
            String arg = (String) o;
            switch (arg){
                case "phoenix":
                case "唐三":
                case "朱竹青":
                case "小舞":
                case "戴沐白":
                case "奥斯卡":
                case "马红俊":
                case "宁蓉蓉":
                    return true;
                default:
                    return false;
            }
        }
    }
}