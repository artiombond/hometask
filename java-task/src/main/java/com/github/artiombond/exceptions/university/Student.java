package com.github.artiombond.exceptions.university;

import com.github.artiombond.exceptions.UniversityExeption;

import java.util.ArrayList;
import java.util.HashMap;


public class Student {
    private String name;
    private ArrayList<Subject> subjects;

    public HashMap<SubjectName,Float> getAverageStudentMarks() throws UniversityExeption {
        if (subjects.size() == 0)
            throw new UniversityExeption("No subjects");
        HashMap<SubjectName,Float> averageMarks = new HashMap<>();
        for (Subject subject : subjects) {
                averageMarks.put(subject.getName(), subject.getAverageMark());
        }
        return averageMarks;
    }

    public Student(String name, ArrayList<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Student(String name) {
        this.name = name;
        subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
