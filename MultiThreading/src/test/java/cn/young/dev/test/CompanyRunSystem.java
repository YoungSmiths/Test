package cn.young.dev.test;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午8:30
 */
public class CompanyRunSystem {
    public static void main(String[] args){
       new CompanyRunSystem().run();
    }

    public void run(){

    }
}
class MyThread implements Runnable{

    public static final Integer flag = 0;

    private String name;

    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (flag){
            try {
                flag.wait();
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(this.name + flag);
//            flag.notify();
        }
    }
}







