package org.example.studentmanagementsystem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementSystemApplication {

  @Autowired
  private StudentRepositry studentRepositry;

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementSystemApplication.class, args);
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentRepositry.searchStudents();
  }

  @GetMapping("/studentCourses")
  public List<StudentCourse> getStudentCourses() {
    return studentRepositry.searchStudentCourses();
  }
}
