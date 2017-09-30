import algorithm.MyInvocationHandler;
import algorithm.ProxyGeneratorUtils;
import algorithm.UserService;
import algorithm.UserServiceImpl;
import org.junit.Test;

/**
 * Created by lucaskc on 2017/5/10.
 */
public class ProxyTest {

    @Test
    public void testProxy() throws Throwable {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();

        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.add();

        proxy.remove();

    }
    @Test
    public void testGenerateProxyClass() {
        ProxyGeneratorUtils.writeProxyClassToHardDisk("/Users/lucaskc/workspace/Gradle/proxy.class");
    }


}
