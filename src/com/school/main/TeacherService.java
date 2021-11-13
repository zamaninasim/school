package com.school.main;

import com.school.FullTimeTeacher;
import com.school.PartTimeTeacher;
import com.school.Teacher;
import com.school.enums.Degree;
import com.school.enums.TeacherType;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    List<Teacher> teachers = new ArrayList<>();

    public TeacherService() {
        teachers.add(new PartTimeTeacher("nasim", "zamani", "01565", TeacherType.PART_TIME, 10, Degree.BS, 20, 500000));
        teachers.add(new PartTimeTeacher("meysam", "rezai", "25616", TeacherType.PART_TIME, 10, Degree.BS, 10, 200000));
        teachers.add(new PartTimeTeacher("negar", "razavi", "61651", TeacherType.PART_TIME, 2, Degree.PHD, 50, 300000));
        teachers.add(new FullTimeTeacher("ahmad", "ahmadi", "64522", TeacherType.FULL_TIME, 10, Degree.BS, 7000000));
        teachers.add(new FullTimeTeacher("zahra", "zahraei", "95859", TeacherType.FULL_TIME, 3, Degree.MA, 4000000));
        teachers.add(new FullTimeTeacher("ali", "alinia", "65187", TeacherType.FULL_TIME, 12, Degree.BS, 10000000));
    }
}
