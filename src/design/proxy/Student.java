package design.proxy;

/**
 *  被代理的对象
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }



    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }
}
