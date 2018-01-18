package cn.young.dev.test;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午9:34
 */
public class Application {
    public static int companyNum = 1;
    public static Integer perpleNum = 100;
    public static PersonMarket personMarket = new PersonMarket();


    public static void main(String[] args){
        new Thread(new CommonCompany(new Location(),40)).start();
        for(Integer index = 0; index < perpleNum; index++){
            new Thread(new CommonPerson()).start();
        }
    }
}
