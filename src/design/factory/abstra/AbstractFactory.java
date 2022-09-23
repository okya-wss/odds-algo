package design.factory.abstra;

/**
 * 抽象工厂角色
 * 优点： 抽象工厂模式除具有工厂方法模式的优点外，最主要的优点是可以在类的内部对产品族进行约束，抽象工厂模式就可以在类内部对产品族的关联关系进行定义和描述，而不必引入一个新的类来进行管理
 * 缺点： 扩展新的产品的时候 对几乎所有的工厂都需要进行修改
 *
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public interface AbstractFactory {

    public AbstractProductA createProductA();


    public AbstractProductB createProductB();
}
