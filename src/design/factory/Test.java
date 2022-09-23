package design.factory;

/**
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class Test {


    public static void main(String[] args) {
        // 简单工厂  当对象逻辑比较复杂时 简单工厂里面将存在着许多逻辑
        IProduct produce = SimpleFactory.produce("A");
        produce.method();
        // 工厂方法， 工厂方法模式的核心是一个饿抽象工厂类，增加产品不需要改动原有的工厂
        IFactory factoryA = new ConcreteFactoryA();
        IProduct product1 = factoryA.produce();
        product1.method();
    }
}
