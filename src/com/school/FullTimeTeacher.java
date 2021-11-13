package com.school;

import com.school.enums.Degree;
import com.school.enums.TeacherType;

public class FullTimeTeacher extends Teacher {
    private double baseSalary;

    public FullTimeTeacher(String name, String lastName, String personalNumber, TeacherType type, Integer experienceYear, Degree degree, double baseSalary) {
        super(name, lastName, personalNumber, type, experienceYear, degree);
        this.baseSalary = baseSalary;
        calculateSalary();
    }


    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public Double calculateSalary() {
        return baseSalary - super.calculateInsurance(baseSalary) - super.calculateTax(baseSalary);
    }
}
