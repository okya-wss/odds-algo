package design.state;

/**
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class FreeTimeState implements State {

    private Room hotelManagement;

    public FreeTimeState(Room hotelManagement) {
        this.hotelManagement = hotelManagement;
    }


    @Override
    public void bookRoom() {
        System.out.println("您已成功预定");
        this.hotelManagement.setState(this.hotelManagement.getBookedState());
    }

    @Override
    public void unsubscribeRoom() {

    }

    @Override
    public void checkInRoom() {
        System.out.println("您已经入住了！");
        this.hotelManagement.setState(this.hotelManagement.getCheckInState());
    }

    @Override
    public void checkOutRoom() {

    }
}
