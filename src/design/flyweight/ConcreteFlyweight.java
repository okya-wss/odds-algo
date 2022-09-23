package design.flyweight;

/**
 * @author shuaishuai.wang
 * @date 2022-09-20
 **/
public class ConcreteFlyweight implements Flyweight {

    private String str;


    public ConcreteFlyweight(String str) {
        this.str = str;
    }


    @Override
    public void operation(String state) {
        System.out.println("内蕴状态:" + state);
        System.out.println("外蕴状态:" + state);
    }
}
