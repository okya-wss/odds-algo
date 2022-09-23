package design.bridge;/**
 *
 * @author shuaishuai.wang
 *
 * @date 2022-09-21
 **/
public abstract class Road {
    protected  Vehicle vehicle;

    public Road(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract void driveOnRoad();
}
