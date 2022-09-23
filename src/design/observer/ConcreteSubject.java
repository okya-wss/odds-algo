package design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class ConcreteSubject implements Subject{

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
