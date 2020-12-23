package com.github.artiombond.exception.entity;

import com.github.artiombond.exception.exceptions.NoStudentException;
import com.github.artiombond.exception.exceptions.NoSubjectException;
import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Student> students;

    public Group(String name) {
        this.name = name;
        students = new ArrayList<>();
    }
    public Group(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudent(String studentName) throws NoStudentException {
        return students.stream().filter((student -> student.getName().equals(studentName))).findFirst().orElseThrow(() -> new NoStudentException());
    }

    public float getAverageSubjectMarkInTheGroup(SubjectName subjectName) throws NoStudentException, NoSubjectException {
        if (students.size() == 0)
            throw new NoStudentException("No students in the group: " + name );
        float averageSubjectMarkInTheGroup = 0;
        int countOfMarks = 0;
        for (Student student : students){
            try {
                averageSubjectMarkInTheGroup += student.getSubjectByName(subjectName).getAverageMark();
                countOfMarks++;
            } catch (NoSubjectException noSubjectException) {
            }
        }
        if (countOfMarks == 0){
            throw new NoSubjectException(subjectName + " isn't studied in the group " + name);
        }
        return averageSubjectMarkInTheGroup/countOfMarks;
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
