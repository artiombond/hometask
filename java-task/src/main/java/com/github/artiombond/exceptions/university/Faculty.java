package com.github.artiombond.exceptions.university;

import com.github.artiombond.exceptions.*;

import java.util.ArrayList;

public class Faculty {
    private String name;
    private ArrayList<Group> groups;

    public float getAverageSubjectMarkOnTheFaculty(SubjectName subjectName) throws UniversityExeption {
        if (groups == null || groups.size() == 0)
            throw new UniversityExeption("No groups on the faculty");
        float averageSubjectMarkOnTheFaculty = 0;
        int n = 0;
        for (Group group : groups){
            for (Student student : group.getStudents()) {
                for (Subject subject : student.getSubjects()) {
                    if (subject.getName() == subjectName) {
                        averageSubjectMarkOnTheFaculty += subject.getAverageMark();
                        n++;
                    }
                }
            }
        }
        if (n == 0){
            throw new UniversityExeption("No such subject learn on the faculty");
        }
        return averageSubjectMarkOnTheFaculty/n;
    }

    public Faculty(String name) {
        this.name = name;
        groups = new ArrayList<>();
    }

    public Faculty(String name, ArrayList<Group> groupes) {
        this.name = name;
        this.groups = groupes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups()  {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
}
