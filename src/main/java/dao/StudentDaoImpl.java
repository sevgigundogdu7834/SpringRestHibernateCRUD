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
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List getListStudent() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        Query<Student> query = session.createQuery(cq);
        return query.getResultList();
    }

    public Student get(int id) {
        return sessionFactory.getCurrentSession().get(Student.class,id);
    }

    public int save(Student student) {

        sessionFactory.getCurrentSession().save(student);
        return student.getId();
    }

    public void deleteStudent(int id) {

        Session session=sessionFactory.getCurrentSession();
        Student student= session.byId(Student.class).load(id);
        session.delete(student);
    }

    public void updateStudent(int id, Student student) {

        Session session= sessionFactory.getCurrentSession();
        Student student1=session.byId(Student.class).load(id);
        student1.setName(student.getName());
        student1.setSurname(student.getSurname());
        student1.setSchoolNumber(student.getSchoolNumber());
        session.flush();
    }

}
