package design.bridge;

/**
 * @author shuaishuai.wang
 * @date 2022-09-21
 **/
public class Bus implements Vehicle{
    @Override
    public void drive() {
        System.out.println("大巴");
    }
}


