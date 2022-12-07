package design.mediator;

/**
 * @author shuaishuai.wang
 * @date 2022-09-23
 **/
public class HouseOwner extends Person{


    HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void contact(String message) {
        mediator.contact(message, this);
    }

    public void getMessage(String message) {
        System.out.println("HouseOwner : " + name + ",get message :" + message);
    }
}
