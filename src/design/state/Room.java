package design.state;

/**
 * 房间类 环境角色
 *
 * @author shuaishuai.wang
 * @date 2022-09-16
 **/
public class Room {

    private State freeTimeState;


    private State checkInState;


    private State bookedState;

    private State state;


    public Room() {
        freeTimeState = new FreeTimeState(this);
        checkInState = new CheckInState(this);
        bookedState = new BookedState(this);
        state = freeTimeState;
    }

    public void bookRoom() {
        state.bookRoom();
    }

    public void unsubscribeRoom() {
        state.unsubscribeRoom();
    }

    public void checkInRoom() {
        state.checkInRoom();
    }

    public void checkOutRoom() {
        state.checkOutRoom();
    }

    @Override
    public String toString(){
        return "该房间的状态" + getState().getClass().getName();
    }

    public State getFreeTimeState() {
        return freeTimeState;
    }

    public void setFreeTimeState(State freeTimeState) {
        this.freeTimeState = freeTimeState;
    }

    public State getCheckInState() {
        return checkInState;
    }

    public void setCheckInState(State checkInState) {
        this.checkInState = checkInState;
    }

    public State getBookedState() {
        return bookedState;
    }

    public void setBookedState(State bookedState) {
        this.bookedState = bookedState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }



}
