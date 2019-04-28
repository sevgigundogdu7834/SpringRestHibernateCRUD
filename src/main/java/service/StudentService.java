package service;

import model.Student;

import java.util.List;

public interface StudentService {

    List getListStudent();

    Student get(int id);

    int save(Student student);

    void deleteStudent(int id);

    void updateStudent(int id, Student student);
}
