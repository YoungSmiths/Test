package cn.young.dev.test;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午8:58
 */
public class Employee extends CommonPerson{
    private Position position;
    private Salary salary;
    private Grade grade;
    private WorkingInfo workingInfo;
    private Company company;

    public Employee() {
        super();
    }

    public Employee(AbstractPerson person){
        super(person);
    }

    public Employee(Position position, Salary salary, Grade grade, WorkingInfo workingInfo, Company company) {
        super();
        this.position = position;
        this.salary = salary;
        this.grade = grade;
        this.company = company;
        this.workingInfo = workingInfo;
    }

    public boolean wantLeaveWork(){
        return LeaveWorkAlgorithm.isWantLeaveWork(this.company);
    }

    public Position getPosition() {
        return position;
    }

    public Employee setPosition(Position position) {
        this.position = position;
        return this;
    }

    public Salary getSalary() {
        return salary;
    }

    public Employee setSalary(Salary salary) {
        this.salary = salary;
        return this;
    }

    public Grade getGrade() {
        return grade;
    }

    public Employee setGrade(Grade grade) {
        this.grade = grade;
        return this;
    }

    public WorkingInfo getWorkingInfo() {
        return workingInfo;
    }

    public Employee setWorkingInfo(WorkingInfo workingInfo) {
        this.workingInfo = workingInfo;
        return this;
    }

    @Override
    public void run() {
        System.out.println("a employee live");
    }
}