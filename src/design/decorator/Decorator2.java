package design.decorator;

/**
 * @author shuaishuai.wang
 * @date 2022-09-20
 **/
public class Decorator2 extends Decorator{


    public Decorator2(Human human) {
        super(human);
    }

    public void goClothespress() {
        System.out.println("去衣柜找找");
    }


    public void findPlaceOnMap() {
        System.out.println("在Map上找找");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findPlaceOnMap();
    }
}
