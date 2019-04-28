package service;

import model.Department;

import java.util.List;

public interface DepartmentService {

    List getListDepartment();

    Department get(int id);

    int save(Department department);

    void deleteDepartment(int id);

    void updateDepartment(int id, Department department);

}
