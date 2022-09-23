package design.template;

/**
 * @author shuaishuai.wang
 * @date 2022-09-22
 **/
public abstract class AbstractTemplate {

    public void templateMethod() {
        abstractMethod();
        doHookMethod();
        concreteMethod();
    }


    protected abstract void abstractMethod();

    protected void doHookMethod(){}

    protected final void concreteMethod(){
        System.out.println("invoke concreteMethod");
    }

}
