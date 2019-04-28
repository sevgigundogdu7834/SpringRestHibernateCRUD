package dao;

import model.Department;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List getListDepartment() {

        Session session=sessionFactory.getCurrentSession();
        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<Department> cq=cb.createQuery(Department.class);
        Root<Department> root=cq.from(Department.class);
        cq.select(root);

       Query<Department> departmentQuery= session.createQuery(cq);
       return departmentQuery.getResultList();

    }

    public Department get(int id) {

        return sessionFactory.getCurrentSession().get(Department.class,id);
    }

    public int save(Department department) {

        sessionFactory.getCurrentSession().save(department);
        return department.getId();
    }

    public void deleteDepartment(int id) {

        Session session=sessionFactory.getCurrentSession();
        Department department=session.byId(Department.class).load(id);
        session.delete(department);
    }

    public void updateDepartment(int id, Department department) {

        Session session=sessionFactory.getCurrentSession();
       Department department1= session.byId(Department.class).load(id);
       department1.setDeptName(department.getDeptName());
       session.flush();


    }
}
