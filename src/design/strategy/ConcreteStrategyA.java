package design.strategy;

/**
 * @author shuaishuai.wang
 * @date 2022-09-22
 **/
public class ConcreteStrategyA implements Strategy{
    @Override
    public void operate() {
        System.out.println("初入东吴。。。");
    }
}
