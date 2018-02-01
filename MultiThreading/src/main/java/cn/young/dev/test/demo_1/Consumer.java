package cn.young.dev.test.demo_1;

/**
 * Describe: 消费者
 *
 * @author YoungSmith
 * 18-2-1 下午8:29
 */
public class Consumer extends Thread{

    private ItemQueue itemQueue;

    public Consumer(ItemQueue itemQueue){
        this.itemQueue = itemQueue;
    }

    @Override
    public void run(){
        while(true){
            System.out.println("Server consume a request, name : " + itemQueue.getReuqest().getName());
        }
    }
}
