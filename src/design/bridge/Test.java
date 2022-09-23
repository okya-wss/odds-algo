package design.bridge;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class Test {

    public static void main(String[] args) {
        Road road = new CementRoad(new Car());
        road.driveOnRoad();
    }
}
