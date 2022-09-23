package design.strategy;

/**
 * @author shuaishuai.wang
 * @date 2022-09-22
 **/
public class Context {

    private Strategy strategy;


    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doOperate() {
        this.strategy.operate();
    }


    public static void main(String[] args) {

    }
}
