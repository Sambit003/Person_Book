package com.dbscope.personbook;

public class personDB {
    private int id;
    private String name;
    private int age;
    private String bgroup;
    private String contact;


    //Constructor
    public personDB(int id, String name, int age, String bgroup, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bgroup = bgroup;
        this.contact = contact;
    }

    //empty constructor
    public personDB() {
    }

    @Override
    public String toString() {
        return "personDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bgroup='" + bgroup + '\'' +
                ", contact=" + contact +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
