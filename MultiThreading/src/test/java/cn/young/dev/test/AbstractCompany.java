package cn.young.dev.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午9:13
 */
public abstract class AbstractCompany{
    private Location location;
    private Integer employeeNum;
    private List<Employee> employees;

    public AbstractCompany(Location location, Integer employeeNum) {
        this.location = location;
        this.employeeNum = employeeNum;
        this.employees = new ArrayList<>();
    }

    public Location getLocation() {
        return location;
    }

    public AbstractCompany setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public AbstractCompany setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public AbstractCompany setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
