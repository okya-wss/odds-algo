package design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuaishuai.wang
 * @date 2022-09-20
 **/
public class FlyweightFactory {

    private Map<String, ConcreteFlyweight> flyweights = new HashMap<>();

    public ConcreteFlyweight factory(String str) {
        ConcreteFlyweight flyweight = flyweights.get(str);
        if (null == flyweight) {
            flyweight = new ConcreteFlyweight(str);
            flyweights.put(str, flyweight);
        }
        return flyweight;
    }


    public int getFlyweightSize() {
        return flyweights.size();
    }


}
