package design.factory.abstra;

/**
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class ProductB1 implements AbstractProductB {

    @Override
    public void produceB() {
        System.out.println("I'm ProductB1");
    }
}
