package cn.young.dev.test;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-1-18 下午8:50
 */
public abstract class AbstractPerson implements Person{
    private String name;
    private boolean sex;
    private int age;
    private float height;
    private float weight;

    public AbstractPerson(){}
    public AbstractPerson(AbstractPerson person){
        this.name = person.name;
        this.sex = person.sex;
        this.age = person.age;
        this.height = person.height;
        this.weight = person.weight;
    }

    private Environment environment;

    public String getName() {
        return name;
    }

    public AbstractPerson setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isSex() {
        return sex;
    }

    public AbstractPerson setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    public int getAge() {
        return age;
    }

    public AbstractPerson setAge(int age) {
        this.age = age;
        return this;
    }

    public float getHeight() {
        return height;
    }

    public AbstractPerson setHeight(float height) {
        this.height = height;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public AbstractPerson setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public AbstractPerson setEnvironment(Environment environment) {
        this.environment = environment;
        return this;
    }

    @Override
    public void sleep() {

    }

    @Override
    public void eat() {

    }
}
