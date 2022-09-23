package design.observer;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class Test {


    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());


        subject.notifyObservers(new Object());
    }
}
