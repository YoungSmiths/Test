package cn.young.dev.test.demo_1;

import java.util.LinkedList;

/**
 * Describe: 队列
 *
 * @author YoungSmith
 * 18-2-1 下午8:16
 */
public class ItemQueue {
    private LinkedList<Item> queue = new LinkedList<>();

    public void addRequest(Item item){
        queue.addFirst(item);
    }

    public Item getReuqest(){
        return queue.removeLast();
    }
}
