package com.github.artiombond.exception;

import com.github.artiombond.exception.entity.*;
import com.github.artiombond.exception.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Student> students = Arrays.asList(
            new Student("Artiom Bond", new ArrayList<Subject>(Arrays.asList(
                    new Subject(SubjectName.COMPUTER_VISION, new ArrayList<>(Arrays.asList(1,8,9))),
                    new Subject(SubjectName.ENGLISH, new ArrayList<>(Arrays.asList(10,8,9))),
                    new Subject(SubjectName.JAVA, new ArrayList<>(Arrays.asList(5,6,9,10)))))),
            new Student("Elon Mask", new ArrayList<Subject>(Arrays.asList(
                    new Subject(SubjectName.JAVA, new ArrayList<>(Arrays.asList(3,5))),
                    new Subject(SubjectName.MATH, new ArrayList<>(Arrays.asList(5,8))),
                    new Subject(SubjectName.ENGLISH, new ArrayList<>(Arrays.asList(5,9)))))),
            new Student("Bill Geyts", new ArrayList<Subject>(Arrays.asList(
                    new Subject(SubjectName.MATH, new ArrayList<>(Arrays.asList(1,2,3))),
                    new Subject(SubjectName.COMPUTER_VISION, new ArrayList<>(Arrays.asList(7,5,3))),
                    new Subject(SubjectName.ENGLISH, new ArrayList<>(Arrays.asList(7,8,4)))))),
            new Student("Mark Zuckerberg", new ArrayList<Subject>(Arrays.asList(
                    new Subject(SubjectName.PHYSICS, new ArrayList<>(Arrays.asList(6,7))),
                    new Subject(SubjectName.HISTORY, new ArrayList<>(Arrays.asList(6,7,9))),
                    new Subject(SubjectName.ENGLISH, new ArrayList<>(Arrays.asList(4,4,4)))))),
            new Student("Sergey Brinn", new ArrayList<Subject>(Arrays.asList(
                    new Subject(SubjectName.HISTORY, new ArrayList<>(Arrays.asList(5,5,5))),
                    new Subject(SubjectName.MATH, new ArrayList<>(Arrays.asList(6,7,8))),
                    new Subject(SubjectName.ENGLISH, new ArrayList<>(Arrays.asList(9,9,9)))))),
            new Student("Jeff Bezos", new ArrayList<Subject>(Arrays.asList(
                    new Subject(SubjectName.COMPUTER_VISION, new ArrayList<>(Arrays.asList(2,2,2))),
                    new Subject(SubjectName.PHYSICS, new ArrayList<>(Arrays.asList(6,6,4,3,5))),
                    new Subject(SubjectName.ENGLISH, new ArrayList<>(Arrays.asList(6,7,4))))))
            );
    static Faculty computerVisionFaculty = new Faculty("Computer Vision",new ArrayList<>(Arrays.asList(
            new Group("CV-1", new ArrayList<>(Arrays.asList(students.get(0), students.get(1)))),
            new Group("CV-2", new ArrayList<>(Arrays.asList(students.get(2))))
                    ))
            );
    static Faculty virtualRealityFaculty = new Faculty("Virtual Reality",new ArrayList<>(Arrays.asList(
           new Group("VR-1"),
           new Group("VR-2", new ArrayList<>(Arrays.asList(students.get(3), students.get(5))))))
    );
    static Faculty teleportationTechnologyFaculty = new Faculty("TeleportationTechnology");


    public static void main(String[] args) {
        University belsut = new University(new ArrayList<Faculty>(Arrays.asList(computerVisionFaculty,virtualRealityFaculty, teleportationTechnologyFaculty)));

        try {
            System.out.println("Average marks of Artiom Bond " +
                    belsut.getFaculty("Computer Vision").getGroup("CV-1").getStudent("Artiom Bond").getAverageStudentMarks());
        } catch (NoStudentException | NoGroupException | NoFacultyException | NoSubjectException exception) {
            exception.printStackTrace();
        }

        try {
            System.out.println("Average Mark for Computer Vision in group CV-1 "
                    + belsut.getFaculty("Computer Vision").getGroup("CV-1").getAverageSubjectMarkInTheGroup(SubjectName.COMPUTER_VISION));
        } catch (NoStudentException | NoSubjectException | NoFacultyException | NoGroupException exception) {
            exception.printStackTrace();
        }

        try {
            System.out.println("Average Mark for CV in faculty Computer Vision " +
                    belsut.getFaculty("Computer Vision").getAverageSubjectMarkOnTheFaculty(SubjectName.COMPUTER_VISION));
        } catch (NoSubjectException | NoGroupException | NoFacultyException exception) {
            exception.printStackTrace();
        }

        try {
            System.out.println("Average mark for CV in university: " + belsut.getAverageSubjectMarkInTheUniversity(SubjectName.COMPUTER_VISION));
        } catch (NoFacultyException | NoSubjectException exception) {
            exception.printStackTrace();
        }

        try {
            belsut.getFaculty("Computer Vision").getGroup("CV-1").getStudent("Artiom Bond").
                    getSubjectByName(SubjectName.COMPUTER_VISION).addMark(11);
        } catch (IllegalMarkException | NoFacultyException | NoGroupException | NoStudentException | NoSubjectException exception) {
            exception.printStackTrace();
        }
    }
}
