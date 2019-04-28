package dao;

import model.Department;
import model.Student;


import java.util.List;

public interface DepartmentDao {

    List getListDepartment();

    Department get(int id);

    int save(Department department);

    void deleteDepartment(int id);

    void updateDepartment(int id, Department department);

}