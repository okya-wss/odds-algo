package design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双重检测
 *
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class IdGeneratorDoubleCheck {

    private AtomicLong id = new AtomicLong(0);

    private static volatile IdGeneratorDoubleCheck instance;

    private IdGeneratorDoubleCheck(){}

    private static IdGeneratorDoubleCheck getInstance() {

        if (instance == null) {
            synchronized (IdGeneratorDoubleCheck.class) {
                if (instance == null) {
                    instance = new IdGeneratorDoubleCheck();
                }
            }
        }
        return instance;
    }



    // 使用局部变量 避免volatile 关键字 每次都需要主存同步
    private static IdGeneratorDoubleCheck instance1;


    private static IdGeneratorDoubleCheck getInstance1() {
        IdGeneratorDoubleCheck temp = instance1;
        if (temp == null) {
            synchronized (IdGeneratorDoubleCheck.class) {
                temp = instance1;
                if (temp == null) {
                    temp = new IdGeneratorDoubleCheck();
                    instance1 = temp;
                }
            }
        }
        return instance1;
    }



    public long getId() {
        return id.incrementAndGet();
    }
}
