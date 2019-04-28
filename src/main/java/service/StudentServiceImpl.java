package service;

import dao.StudentDao;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional()
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public List getListStudent() {
        return studentDao.getListStudent();
    }

    public Student get(int id) {

       Student student= studentDao.get(id);
       return student;
    }

    @Transactional
    public int save(Student student) {

        return studentDao.save(student);
    }

    @Transactional
    public void deleteStudent(int id) {

        studentDao.deleteStudent(id);
    }

    @Transactional
    public void updateStudent(int id, Student student) {

        studentDao.updateStudent(id,student);
    }
}
