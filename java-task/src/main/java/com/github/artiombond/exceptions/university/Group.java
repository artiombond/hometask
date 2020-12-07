package com.github.artiombond.exceptions.university;

import com.github.artiombond.exceptions.UniversityExeption;

import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Student> students;

    public float getAverageSubjectMarkInTheGroup(SubjectName subjectName) throws UniversityExeption {
        if (students.size() == 0)
            throw new UniversityExeption("No students");
        float averageSubjectMarkInTheGroup = 0;
        int n = 0;
        for (Student student : students){
            for (Subject subject:student.getSubjects()){
                if (subject.getName() == subjectName){
                    averageSubjectMarkInTheGroup += subject.getAverageMark();
                    n++;
                }
            }
        }
        if (n == 0){
            throw new UniversityExeption("No such subject learn in this group");
        }
        return averageSubjectMarkInTheGroup/n;
    }

    public Group(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public Group(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
