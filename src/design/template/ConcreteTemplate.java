package design.template;

/**
 * @author shuaishuai.wang
 * @date 2022-09-22
 **/
public class ConcreteTemplate extends AbstractTemplate{
    @Override
    protected void abstractMethod() {
        System.out.println("ConcreteTeamplate-abstractMethod");
    }

    @Override
    protected void doHookMethod() {
        super.doHookMethod();
    }


    public static void main(String[] args) {
        AbstractTemplate template = new ConcreteTemplate();
        template.templateMethod();
    }
}
