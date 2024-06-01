package org.student;

import java.util.*;

public class StudentManager {
    private List<Student> students;
    private Map<String, Student> index;

    public StudentManager() {
        students = new ArrayList<>();
        index = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        index.put(student.getId(), student);
    }

    public void deleteStudent(String id) {
        Student student = index.get(id);
        students.remove(student);
        index.remove(id);
    }

    public Student findStudent(String id) {
        return index.get(id);
    }

    public void updateStudent(String id, Student newStudent) {
        deleteStudent(id);
        addStudent(newStudent);
    }

    public void sortStudents() {
        students.sort(Comparator.comparing(Student::getScore));
    }

    // other methods
    // ...

    public List<Student> getStudents() {
        return students;
    }

    public void save() {

    }
}