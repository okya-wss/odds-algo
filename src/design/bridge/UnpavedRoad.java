package design.bridge;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class UnpavedRoad extends Road{


    public UnpavedRoad(Vehicle vehicle) {
        super(vehicle);
    }

    @Override
    public void driveOnRoad() {
        super.vehicle.drive();
        System.out.println("行驶在石子路上");
    }
}
