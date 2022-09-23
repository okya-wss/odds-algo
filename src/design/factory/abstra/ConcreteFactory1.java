package design.factory.abstra;

/**
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class ConcreteFactory1 implements AbstractFactory{
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
