package model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property="id"

)*/
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String deptName;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department",fetch = FetchType.EAGER)
//    @JsonManagedReference
    private List<Student> student;

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", student=" + student +
                '}';
    }
}
