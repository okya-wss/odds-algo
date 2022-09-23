package design.observer;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Object message) {
        System.out.println("concreteObserverOne is notified");
    }
}
