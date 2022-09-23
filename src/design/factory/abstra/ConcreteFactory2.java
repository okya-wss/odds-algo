package design.factory.abstra;

/**
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class ConcreteFactory2 implements AbstractFactory{
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
