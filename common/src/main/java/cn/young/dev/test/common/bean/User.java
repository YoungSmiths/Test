package cn.young.dev.test.common.bean;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-17 下午9:51
 */
public class User {
    private String name;
    private String sex;
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
