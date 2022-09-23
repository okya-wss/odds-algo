package design.proxy;

/**
 * 代理对象 : 静态代理 学生代理类，也实现了Person接口，保存一个学生实体，这样既可以代理学生产生行为
 *
 * @author shuaishuai.wang
 * @date 2022-09-19
 **/
public class StudentProxy implements Person {


    private Student student;

    public StudentProxy(Person student) {
        this.student = (Student) student;
    }


    @Override
    public void giveMoney() {
        student.giveMoney();
    }

    public static void main(String[] args) {
        new StudentProxy(new Student("zhangsan")).giveMoney();
    }
}



