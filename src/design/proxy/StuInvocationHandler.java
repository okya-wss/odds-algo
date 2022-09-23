package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 动态代理
 *
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class StuInvocationHandler implements InvocationHandler {
    Object target;

    public StuInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(target, args);
    }


    public static void main(String[] args) {
        // 创建一个实例对象，这个对象是被代理的对象
        Person zhang = new Student("张三");

        // 创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler(zhang);

        //创建一个代理对象stuProxy来代理张三，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        design.proxy.Person stuProxy = (design.proxy.Person) Proxy.newProxyInstance(design.proxy.Person.class.getClassLoader(), new Class<?>[]{design.proxy.Person.class},
                stuHandler);
        // 执行代理方法
        stuProxy.giveMoney();
    }
}
