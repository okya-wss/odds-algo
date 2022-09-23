package design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 懒汉式
 *
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class IdGeneratorLazy {

    private AtomicLong id = new AtomicLong(0);

    private static IdGeneratorLazy instance;

    private IdGeneratorLazy(){}

    public static synchronized IdGeneratorLazy getInstance() {
        if (instance == null) {
            instance = new IdGeneratorLazy();
        }
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
