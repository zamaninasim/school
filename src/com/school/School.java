package com.school;

import java.util.Objects;

public class School {
    private String name;
    private Integer degree; // درجه بندی مدرسه که بیانگر کیفیت مدرسه می باشد و  میتواند مقادیر ۱و۲و۳ باشد

    public School(String name, Integer degree) {
        this.name = name;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return degree == school.degree && Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, degree);
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", degree=" + degree +
                '}';
    }
}
