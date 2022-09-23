package design.factory;

/**
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class ConcreteFactoryA implements IFactory{
    @Override
    public IProduct produce() {
        return new ProductA();
    }
}
