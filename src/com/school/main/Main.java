package com.school.main;

import com.school.Course;
import com.school.School;

public class Main {

    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();

        Course course = new Course("math", 1);
        Course course1 = new Course("computer", 2);
        Course course2 = new Course("physic", 3);
        Course course3 = new Course("history", 4);
        Course course4 = new Course("art", 5);


        School school =  new School("maktab", 1);
        School school1 = new School("madani", 2);
        School school2 = new School("alavi", 3);
        School school3 = new School("razavi", 3);
        School school4 = new School("jalal", 1);
        School school5 = new School("diba", 1);

        System.out.println("*****************addSchoolForTeacher*****************");
        System.out.println(teacherService.addSchoolForTeacher("01565",school));
        System.out.println(teacherService.addSchoolForTeacher("01565",school1));
        System.out.println(teacherService.addSchoolForTeacher("61651",school1));
        System.out.println(teacherService.addSchoolForTeacher("01565",school2));

        System.out.println("*****************addCourseForTeacher*****************");
        System.out.println(teacherService.addCourseForTeacher("01565",course2));
        System.out.println(teacherService.addCourseForTeacher("01565",course1));
        System.out.println(teacherService.addCourseForTeacher("01565",course3));
        System.out.println(teacherService.addCourseForTeacher("64522",course2));

        System.out.println("****************findTeachersHaveSalaryMoreThanAverage******************");
        teacherService.findTeachersHaveSalaryMoreThanAverage().forEach(System.out::println);

        System.out.println("****************findTeachersWhit10YearExperience******************");
        teacherService.findTeachersWhit10YearExperience().forEach((i, j) -> System.out.println(i + ":" + j));

        System.out.println("****************findPartTeachersWhitBSDegreeAndDegree2SchoolAndMoreThan2Course******************");
        teacherService.findPartTeachersWhitBSDegreeAndDegree2SchoolAndMoreThan2Course().forEach(System.out::println);

        System.out.println("*****************findSchoolsByTeachersList*****************");
        teacherService.findSchoolsByTeachersList().forEach(System.out::println);

        System.out.println("*****************findSchoolsTeacher*****************");
        teacherService.findSchoolsTeacher(teacherService.findSchoolsByTeachersList()).forEach((i, j) -> System.out.println(i + ":" + j));
    }

}
