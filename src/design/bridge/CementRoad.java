package design.bridge;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class CementRoad extends Road{


    public CementRoad(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void driveOnRoad() {
        super.vehicle.drive();
        System.out.println("行驶在水泥路");
    }
}
