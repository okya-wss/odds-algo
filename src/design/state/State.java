package design.state;

/**
 * 状态接口
 *
 * @author shuaishuai.wang
 * @date 2022-09-15
 **/
public interface State {

    public void bookRoom();

    public void unsubscribeRoom();

    public void checkInRoom();

    public void checkOutRoom();
}
