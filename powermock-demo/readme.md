# PowerMock
## 什么是PowerMock
## PowerMock快速入门
## Mock局部变量
## Mock静态变量
## Mock final修饰的方法
## Mock私有方法
## Verify的使用
## Mock不同的构造函数
## Arguments Matcher的使用
## Answer接口的使用
## Spy的使用


* powermock基于easymock和mockito进行的增强，完成了他们无法完成的工作
* objenesis-2.1.jar功能很强大，但是有时会有一些问题，如果遇到JVM crash，可以考虑更换这个library的八本
* PowerMock不是重复造轮子
* 测试类只能使用一个Runner，如使用了
```
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
```
可以使用powermock的代理再加其他Runner
```=
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
@PowerMockRunnerDelegate(SpringRunner.class)
```
@PowerMockRunnerDelegate是PowerMock1.4版本以后新增注解，考虑到还有其他Runner存在的可能性
另外，使用@Rule可以减少Runner的占用
```
 @Rule
 PowerMockRule rule = new PowerMockRule();
```
Using PowerMockRule with Maven
You need to depend on these projects:
```xml
<dependency>
  <groupId>org.powermock</groupId>
  <artifactId>powermock-module-junit4-rule</artifactId>
  <version>2.0.2</version>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.powermock</groupId>
  <artifactId>powermock-classloading-xstream</artifactId>
  <version>2.0.2</version>
  <scope>test</scope>
</dependency>
```
You can also replace ```powermock-classloading-xstream``` with an Objenesis version:
```xml
<dependency>
  <groupId>org.powermock</groupId>
  <artifactId>powermock-classloading-objenesis</artifactId>
  <version>2.0.2</version>
  <scope>test</scope>
</dependency>
```
详情https://github.com/powermock/powermock/wiki/powermockrule
* 单元测试后自动生成文档，引入Concordion framework
```
<!-- https://mvnrepository.com/artifact/org.concordion/concordion -->
<dependency>
    <groupId>org.concordion</groupId>
    <artifactId>concordion</artifactId>
    <version>2.2.0</version>
</dependency>
```
还要一个Runner
```
@RunWith(ConcordionRunner.class)
或者
@PowerMockRunnerDelegate(ConcordionRunner.class)
```
* 尽量减少使用PowerMock（该用还是用，但是减少使用。使用它意味着自己的代码设置不合理或者情非得已）