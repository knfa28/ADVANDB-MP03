package model;

public class TransactionQuery {
    private int id;
    private int mem;
    private int sex;
    private int age;
    private int reason;
    private String others;

    public TransactionQuery(int id, int mem, int sex, int age, int reason, String others) {
        this.id = id;
        this.mem = mem;
        this.sex = sex;
        this.age = age;
        this.reason = reason;
        this.others = others;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
    
    
}
