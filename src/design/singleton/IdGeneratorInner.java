package design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类
 *
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class IdGeneratorInner {

    private AtomicLong id = new AtomicLong(0);


    private IdGeneratorInner() {
    }

    private static class SingletonHolder{
        private static final IdGeneratorInner instance = new IdGeneratorInner();
    }

    public static IdGeneratorInner getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
