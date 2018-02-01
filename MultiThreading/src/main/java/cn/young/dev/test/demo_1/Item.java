package cn.young.dev.test.demo_1;

/**
 * Describe: 生产消费的实体
 *
 * @author YoungSmith
 * 18-2-1 下午8:13
 */
public class Item {
    private final String name;

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
