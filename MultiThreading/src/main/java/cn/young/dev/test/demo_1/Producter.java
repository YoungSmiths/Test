package cn.young.dev.test.demo_1;

import java.util.UUID;

/**
 * Describe: 生产者
 *
 * @author YoungSmith
 * 18-2-1 下午8:15
 */
public class Producter extends Thread {
    private ItemQueue itemQueue;

    public Producter(ItemQueue itemQueue){
        this.itemQueue = itemQueue;
    }
    @Override
    public void run() {
        while(true){
            Item item = new Item(UUID.randomUUID().toString());
            itemQueue.addRequest(item);
            System.out.println("Client product a request , name : " + item.getName());
        }
    }
}
