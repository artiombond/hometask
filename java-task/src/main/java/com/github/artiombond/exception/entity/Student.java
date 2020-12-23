package com.github.artiombond.exception.entity;

import com.github.artiombond.exception.exceptions.NoSubjectException;
import java.util.ArrayList;
import java.util.HashMap;


public class Student {
    private String name;
    private ArrayList<Subject> subjects;

    public Student(String name, ArrayList<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
    public Student(String name) {
        this.name = name;
        subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public HashMap<SubjectName,Float> getAverageStudentMarks() throws NoSubjectException {
        if (subjects.size() == 0)
            throw new NoSubjectException("Student " + name + "has no sujects");
        HashMap<SubjectName,Float> averageMarks = new HashMap<>();
        for (Subject subject : subjects) {
                averageMarks.put(subject.getName(), subject.getAverageMark());
        }
        return averageMarks;
    }

    public Subject getSubjectByName (SubjectName subjectName) throws NoSubjectException {
            return subjects.stream().filter((s) -> s.getName() == subjectName).findFirst().orElseThrow(() -> new NoSubjectException(this.name + " doesn't learn " + subjectName));
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
