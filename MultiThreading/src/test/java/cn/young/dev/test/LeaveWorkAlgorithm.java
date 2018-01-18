package cn.young.dev.test;

import java.util.Random;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午9:17
 */
public class LeaveWorkAlgorithm {
    public static boolean isWantLeaveWork(Company company){
      return 1 == new Random().nextInt(1000);
    }

    public static void main(String[] args){
        for(int i = 0 ; i < 100; i ++){
            int gg = new Random().nextInt(100);
            System.out.println(gg);
        }
    }
}
