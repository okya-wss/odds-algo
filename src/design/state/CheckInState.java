package design.state;

/**
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class CheckInState implements State{


    private Room hotelManagement;


    public CheckInState(Room hotelManagement) {
        this.hotelManagement = hotelManagement;
    }

    @Override
    public void bookRoom() {
        System.out.println("该房间已经入住了");
    }

    @Override
    public void unsubscribeRoom() {

    }

    @Override
    public void checkInRoom() {
        System.out.println("该房间已经入住了");
    }

    @Override
    public void checkOutRoom() {
        System.out.println("退房成功");
        this.hotelManagement.setState(this.hotelManagement.getFreeTimeState());
    }
}
