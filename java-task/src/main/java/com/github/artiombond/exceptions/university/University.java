package com.github.artiombond.exceptions.university;

import com.github.artiombond.exceptions.*;

import java.util.ArrayList;

public class University {
    private ArrayList<Faculty> faculties;

    public float getAverageSubjectMarkInTheUniversity(SubjectName subjectName) throws UniversityExeption {
        if(faculties == null || faculties.size() == 0){
            throw new UniversityExeption("No faculties");
        }
        float averageSubjectMarkInTheUniversity = 0;
        int n = 0;
        for (Faculty faculty:faculties) {
            for (Group group : faculty.getGroups()){
                for (Student student : group.getStudents()) {
                    for (Subject subject : student.getSubjects()) {
                        if (subject.getName() == subjectName) {
                            averageSubjectMarkInTheUniversity += subject.getAverageMark();
                            n++;
                        }
                    }
                }
            }
        }
        if( n == 0){
            throw new UniversityExeption("No such subject learn in the university");
        }
        return averageSubjectMarkInTheUniversity/n;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public University(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    public University() {
        faculties = new ArrayList<>();
    }
}
