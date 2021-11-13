package com.school.main;

import com.school.*;
import com.school.enums.Degree;
import com.school.enums.TeacherType;

import java.util.*;
import java.util.stream.Collectors;

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

    public Teacher addSchoolForTeacher(String personalNumber, School school) {
        Optional<Teacher> t = teachers.stream().filter(i -> i.getPersonalNumber().equalsIgnoreCase(personalNumber)).findAny();
        Teacher teacher = t.get();
        Set<School> teachersSchool = teacher.getSchool();
        teachersSchool.add(school);
        teacher.setSchool(teachersSchool);
        return teacher;
    }

    public Teacher addCourseForTeacher(String personalNumber, Course course) {
        Teacher teacher = teachers.stream().filter(i -> i.getPersonalNumber().equalsIgnoreCase(personalNumber)).findAny().get();
        Set<Course> teachersCourse = teacher.getCourse();
        teachersCourse.add(course);
        teacher.setCourse(teachersCourse);
        return teacher;
    }

    private Double findPartTeachersSalaryAverage() {
        Double sum = teachers.stream().filter(i -> i.getType().equals(TeacherType.PART_TIME)).map(i -> i.calculateSalary()).reduce(0D, (i, j) -> i + j);
        Long count = teachers.stream().filter(i -> i.getType().equals(TeacherType.PART_TIME)).count();
        Double average = sum / count;
        return average;
    }
    public List<Teacher> findTeachersHaveSalaryMoreThanAverage() {
        Double average = findPartTeachersSalaryAverage();
        return teachers.stream().filter(i -> i.calculateSalary() > average).collect(Collectors.toList());
    }

    public Map<TeacherType, List<Teacher>> findTeachersWhit10YearExperience() {
        return teachers.stream().filter(i -> i.getExperienceYear() == 10).collect(Collectors.groupingBy(i -> i.getType()));
    }

    public List<Teacher> findPartTeachersWhitBSDegreeAndDegree2SchoolAndMoreThan2Course() {
        return teachers.stream()
                .filter(i -> i.getType().equals(TeacherType.PART_TIME))
                .filter(i -> i.getDegree().equals(Degree.BS))
                .filter(i -> i.getCourse().size() >= 2)
                .filter(i -> i.getSchool().stream().anyMatch(j -> j.getDegree() == 2)).collect(Collectors.toList());
    }

    public Set<School> findSchoolsByTeachersList() {
        Set<Set<School>> teachersSchools = teachers.stream().filter(i -> !i.getSchool().isEmpty()).map(t -> t.getSchool()).collect(Collectors.toSet());
        Set<School> schools = new HashSet<>();
        teachersSchools.forEach(schools::addAll);
        return schools;
    }

    public Map<School, List<Teacher>> findSchoolsTeacher(Set<School> schools) {
        Map<School, List<Teacher>> map = new HashMap<>();
        schools.forEach(i ->
                map.put(i, teachers.stream().filter(t -> t.getSchool().contains(i)).collect(Collectors.toList())));
        return map;
    }

}
