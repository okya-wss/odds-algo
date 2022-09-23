package design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 饿汉式
 *
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class IdGeneratorHungry {

    private AtomicLong id = new AtomicLong(0);

    private static final IdGeneratorHungry instance = new IdGeneratorHungry();

    private IdGeneratorHungry() {
    }

    public static IdGeneratorHungry getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
