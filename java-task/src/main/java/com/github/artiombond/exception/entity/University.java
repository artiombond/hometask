package com.github.artiombond.exception.entity;

import com.github.artiombond.exception.exceptions.NoFacultyException;
import com.github.artiombond.exception.exceptions.NoSubjectException;
import java.util.ArrayList;

public class University {
    private ArrayList<Faculty> faculties;

    public University(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }
    public University() {
        faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public Faculty getFaculty(String facultyName) throws NoFacultyException {
        return faculties.stream().filter((faculty) -> faculty.getName().equals(facultyName)).findFirst().orElseThrow(() -> new NoFacultyException());
    }

    public float getAverageSubjectMarkInTheUniversity(SubjectName subjectName) throws NoSubjectException, NoFacultyException {
        if(faculties == null || faculties.size() == 0){
            throw new NoFacultyException("No faculties");
        }
        float averageSubjectMarkInTheUniversity = 0;
        int countOfMarks = 0;
        for (Faculty faculty:faculties) {
            for (Group group : faculty.getGroups()){
                for (Student student : group.getStudents()) {
                    try {
                        averageSubjectMarkInTheUniversity += student.getSubjectByName(subjectName).getAverageMark();
                        countOfMarks++;
                    } catch (NoSubjectException noSubjectException) {
                    }
                }
            }
        }
        if( countOfMarks == 0){
            throw new NoSubjectException(subjectName + " isn't studied at the university ");
        }
        return averageSubjectMarkInTheUniversity/countOfMarks;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }


}
