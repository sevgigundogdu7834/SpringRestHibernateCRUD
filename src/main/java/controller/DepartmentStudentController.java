package controller;

import model.Department;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.DepartmentService;
import service.StudentService;

import java.util.List;

@RestController
public class DepartmentStudentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/departments")
    public ResponseEntity<?> save(@RequestBody Department department){

       int id= departmentService.save(department);
        return ResponseEntity.ok().body("New department save with by :" +id);

    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> list(){

        List<Department> departmentList=departmentService.getListDepartment();
        return ResponseEntity.ok().body(departmentList);

    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> get(@PathVariable("id") int id){

        Department department=departmentService.get(id);
        return ResponseEntity.ok().body(department);
    }

    @PutMapping("/departmentUpdate/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Department department){

        departmentService.updateDepartment(id,department);
        return ResponseEntity.ok().body("Department has been updated successfully");

    }

    @DeleteMapping("/departmentDelete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){

        departmentService.deleteDepartment(id);

        return ResponseEntity.ok().body("Department has been deleted successfully");
    }

    @PostMapping("/department/{id}/students")
    public ResponseEntity<?> save(@PathVariable int id,@RequestBody Student student) {

        Department department1=departmentService.get(id);
        student.setDepartment(department1);
        int std_id=studentService.save(student);

        return ResponseEntity.ok().body("New Student has been saved with ID:" + std_id);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable("id") int id){

       Student student= studentService.get(id);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> listStudents(){

        List<Student> studentList=studentService.getListStudent();
        return ResponseEntity.ok().body(studentList);

    }

    @PutMapping("/studentUpdate/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int id,@RequestBody Student student){

        studentService.updateStudent(id,student);
        return ResponseEntity.ok().body("Student has been updated successfully "+id);

    }

    @DeleteMapping("/studentDelete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id){

        studentService.deleteStudent(id);

        return ResponseEntity.ok().body("Student has been deleted successfully"+id);
    }







}
/*

package controller;

        import model.Department;
        import model.Student;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import service.DepartmentService;
        import service.StudentService;

        import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;




    @GetMapping("/students/{id}")
    public ResponseEntity<Student> get(@PathVariable int id) {

        Student student=studentService.get(id);
        Department department=student.getDepartment();
        student.setDepartment(department);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> list() {

        List<Student> students = studentService.getListStudent();
        return ResponseEntity.ok().body(students);
    }

    @PutMapping("/studentUpdate/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Student student) {
        studentService.updateStudent(id,student);
        return ResponseEntity.ok().body("Student has been updated successfully.");
    }

    @DeleteMapping("/studentDelete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body("Student has been deleted successfully.");
    }

}

*/
