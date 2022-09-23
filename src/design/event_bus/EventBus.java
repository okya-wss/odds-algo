package design.event_bus;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class EventBus {

    private Executor executor;

    private ObserverRegistry registry = new ObserverRegistry();


    public EventBus(Executor executor) {
        this.executor = executor;
    }


    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(() -> observerAction.execute(event));
        }
    }
}
