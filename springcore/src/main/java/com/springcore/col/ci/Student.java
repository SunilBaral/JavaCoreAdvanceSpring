package com.springcore.col.ci;

import java.util.List;
import java.util.Set;

public class Student {
    private List<String> name;
    private Set<String> courses;
    private Addr ad;

    public Student(List<String> name, Set<String> courses, Addr ad) {
        this.name = name;
        this.courses = courses;
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", courses=" + courses +
                ", ad=" + ad +
                '}';
    }
}
