package cn.young.dev.test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午10:11
 */
public class PersonMarket {
    private int size = 1000;
    private ArrayBlockingQueue queue = new ArrayBlockingQueue(size);

    public void putPerson(Person person){
        queue.add(person);
    }

    public Person getPerson(){
        try {
            return (Person) queue.take();
        } catch (InterruptedException e) {
            return null;
        }
    }

}
