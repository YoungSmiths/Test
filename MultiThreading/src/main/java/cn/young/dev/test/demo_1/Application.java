package cn.young.dev.test.demo_1;

/**
 * Describe: 应用程序
 *
 * @author YoungSmith
 * 18-2-1 下午8:21
 */
public class Application {

    public static void main(String[] args){
        ItemQueue itemQueue = new ItemQueue();
        Producter client = new Producter(itemQueue);
        Consumer server = new Consumer(itemQueue);
        server.start();
        client.start();
    }
}
