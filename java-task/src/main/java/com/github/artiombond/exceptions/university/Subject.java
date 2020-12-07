package com.github.artiombond.exceptions.university;

import com.github.artiombond.exceptions.MarkExeption;
import java.util.ArrayList;

public class Subject {
    private SubjectName name;
    private ArrayList<Integer> marks;

    public void addMark(int mark) throws MarkExeption {
        if (mark < 0 || mark > 10)
            throw new MarkExeption("illegal mark");
        marks.add(mark);
    }

    public float getAverageMark() {
        return (float) marks.stream().mapToDouble((m) -> m).average().getAsDouble();
    }

    public SubjectName getName() {
        return name;
    }

    public void setName(SubjectName name) {
        this.name = name;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public Subject(SubjectName subjectName, ArrayList<Integer> marks) {
        this.name = subjectName;
        this.marks = marks;
    }

    public Subject(SubjectName name) {
        this.name = name;
        marks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

}
