package design.decorator;

/**
 * 装饰者
 *
 * @author shuaishuai.wang
 * @date 2022-09-20
 **/
public abstract class Decorator implements Human {

    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
    }

    @Override
    public void walkToWhere() {
        human.walkToWhere();
    }
}
