package design.mediator;

/**
 * @author shuaishuai.wang
 * @date 2022-09-23
 **/
public abstract class Person {

    protected String name;

    protected Mediator mediator;

    Person(String name, Mediator mediator) {
        this.mediator = mediator;
        this.name = name;
    }
}
