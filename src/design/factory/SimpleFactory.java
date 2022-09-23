package design.factory;

/**
 * 简单工厂
 *
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class SimpleFactory {

    public static IProduct produce(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else if ("B".equals(type)) {
            return new ProductB();
        } else {
            System.out.println("类型错误");
            return null;
        }
    }
}
