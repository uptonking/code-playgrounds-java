package yao.usage.inherit;

/**
 * Created by yaoo on 6/15/17.
 */
public class Base {
    public Base newInstance() {
        return new Base();
    }

    public Base newInstance2() {
        return new Base();
    }
}

class BaseChild extends Base {
    // 返回值不同
    public BaseChild newInstance() {
        return new BaseChild();
    }

    // 返回值相同
    public Base newInstance2() {
        return new BaseChild();
    }
}
