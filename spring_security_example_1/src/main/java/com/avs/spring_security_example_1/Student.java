package com.avs.spring_security_example_1;

public class Student {
    private int id;
    private String name;
    private int mark;

    public Student(int id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
    }
    public String getName() {
        return name;
    }
    public int getMark() {
        return mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}