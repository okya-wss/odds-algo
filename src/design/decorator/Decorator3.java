package design.decorator;

/**
 * @author shuaishuai.wang
 * @date 2022-09-20
 **/
public class Decorator3 extends Decorator{


    public Decorator3(Human human) {
        super(human);
    }

    public void findClothes() {
        System.out.println("找到一件🧥");
    }


    public void findTheTarget() {
        System.out.println("在Map上找到神秘花园和城堡");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }
}
