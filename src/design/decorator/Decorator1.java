package design.decorator;

/**
 * @author shuaishuai.wang
 * @date 2022-09-20
 **/
public class Decorator1 extends Decorator{


    public Decorator1(Human human) {
        super(human);
    }

    public void goHome() {
        System.out.println("进房子");
    }


    public void findMap() {
        System.out.println("书房找找Map");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findMap();
    }
}
