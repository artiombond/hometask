package com.github.artiombond.exception.entity;

import com.github.artiombond.exception.exceptions.NoGroupException;
import com.github.artiombond.exception.exceptions.NoSubjectException;
import java.util.ArrayList;

public class Faculty {
    private String name;
    private ArrayList<Group> groups;

    public Faculty(String name) {
        this.name = name;
        groups = new ArrayList<>();
    }
    public Faculty(String name, ArrayList<Group> groupes) {
        this.name = name;
        this.groups = groupes;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public Group getGroup(String groupName) throws NoGroupException {
        return groups.stream().filter((group -> group.getName().equals(groupName))).findFirst().orElseThrow(() -> new NoGroupException());
    }

    public float getAverageSubjectMarkOnTheFaculty(SubjectName subjectName) throws NoGroupException, NoSubjectException {
        if (groups == null || groups.size() == 0)
            throw new NoGroupException("No groups on the faculty:" + name);
        float averageSubjectMarkOnTheFaculty = 0;
        int countOfMarks = 0;
        for (Group group : groups){
            for (Student student : group.getStudents()) {
                try {
                    averageSubjectMarkOnTheFaculty += student.getSubjectByName(subjectName).getAverageMark();
                    countOfMarks++;
                } catch (NoSubjectException noSubjectException) {
                }
            }
        }
        if (countOfMarks == 0){
            throw new NoSubjectException(subjectName + " isn't studied in the faculty " + name);
        }
        return averageSubjectMarkOnTheFaculty/countOfMarks;
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
