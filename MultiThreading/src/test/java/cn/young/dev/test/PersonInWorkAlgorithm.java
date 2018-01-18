package cn.young.dev.test;

import java.util.Random;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午9:37
 */
public class PersonInWorkAlgorithm {
    public static boolean wantWork(Environment environment){
        return 1 == new Random().nextInt(Application.perpleNum);
    }
}
