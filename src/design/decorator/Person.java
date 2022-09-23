package design.decorator;

/**
 * @author shuaishuai.wang
 * @date 2022-09-20
 **/
public class Person implements Human{
    @Override
    public void wearClothes() {
        System.out.println("穿什么呢？");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢");
    }


    public static void main(String[] args) {
        Human human = new Person();
        Decorator decorator = new Decorator3(new Decorator2(new Decorator1(human)));
        decorator.wearClothes();
        decorator.walkToWhere();
    }
}
