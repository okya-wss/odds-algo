package design.observer;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Object message);
}
