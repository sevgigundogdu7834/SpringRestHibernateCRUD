package service;

import dao.DepartmentDao;
import model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional
    public int save(Department department) {

        departmentDao.save(department);
        return department.getId();
    }

    @Transactional
    public void deleteDepartment(int id) {

        departmentDao.deleteDepartment(id);
    }

    @Transactional
    public void updateDepartment(int id, Department department) {

        departmentDao.updateDepartment(id,department);
    }

    public List getListDepartment() {

        return departmentDao.getListDepartment();
    }

    public Department get(int id) {

       return departmentDao.get(id);
    }
}
