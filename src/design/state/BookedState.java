package design.state;

/**
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class BookedState implements State {

    private Room hotelManagement;

    public BookedState(Room hotelManagement) {
        this.hotelManagement = hotelManagement;
    }


    @Override
    public void bookRoom() {
        System.out.println("该房间已预定");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("成功退订");
        this.hotelManagement.setState(this.hotelManagement.getFreeTimeState());
    }

    @Override
    public void checkInRoom() {
        System.out.println("入住成功！");
        this.hotelManagement.setState(this.hotelManagement.getCheckInState());
    }

    @Override
    public void checkOutRoom() {

    }
}
