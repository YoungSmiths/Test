package cn.young.dev.test;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午9:15
 */
public class CommonCompany extends AbstractCompany implements Runnable{

    private boolean isLive = true;

    public CommonCompany(Location location, Integer employeeNum) {
        super(location, employeeNum);
    }

    @Override
    public void run() {
        System.out.println("company start run...");
        while(isLive){
            if(this.getEmployeeNum() > this.getEmployees().size()) {
                this.getEmployees().add(new Employee((AbstractPerson) Application.personMarket.getPerson()));
            }
            System.out.println(this.getEmployees());
        }
    }
}
