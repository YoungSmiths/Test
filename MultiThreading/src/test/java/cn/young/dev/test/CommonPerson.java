package cn.young.dev.test;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午9:43
 */
public class CommonPerson extends AbstractPerson{

    public CommonPerson(AbstractPerson person){
        super(person);
    }

    public CommonPerson(){}

    private boolean isLive = true;
    @Override
    public void run() {
        System.out.println("a person come the world");
        while(isLive){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.ideaAndToDo();
        }
    }

    public void ideaAndToDo(){
        if(WantWorking()){
            Application.personMarket.putPerson(this);
            System.out.println("去人才市场面试");
        }

    }

    public boolean WantWorking(){
       return PersonInWorkAlgorithm.wantWork(this.getEnvironment());
    }

}
