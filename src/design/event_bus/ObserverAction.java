package design.event_bus;

import com.sun.tools.javac.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class ObserverAction {

    private Object target;

    private Method method;


    public ObserverAction(Object target, Method method) {
        this.method = method;
        Assert.checkNonNull(target);
        this.target  = target;
        this.method.setAccessible(true);
    }


    public void execute(Object event) {
        // event是method方法的参数
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
