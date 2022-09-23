package design.factory.abstra;

/**
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class Test {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1();
        AbstractProductA product1 = factory.createProductA();
        AbstractProductB product2 = factory.createProductB();
        product1.produceA();
        product2.produceB();
    }
}
