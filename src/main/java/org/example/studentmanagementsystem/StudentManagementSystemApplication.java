package org.example.studentmanagementsystem;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementSystemApplication {

  @Autowired
  private StudentRepositry studentRepositry;

  private String name = "Taro Tanaka";
  private String age = "27";

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementSystemApplication.class, args);
  }

  @GetMapping("/student")
  public String getStudent(@RequestParam String name) {
    Student student = studentRepositry.searchByName(name);
    return student.getName() + " " + student.getAge() + "歳";
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentRepositry.searchAll();
  }

  @PostMapping("/student")
  public void registerStudent(String name, int age) {
    studentRepositry.registerStudent(name, age);
  }

  @PatchMapping("/student")
  public void updateStudent(String name, int age) {
    studentRepositry.updateStudent(name, age);
  }

  @DeleteMapping("/student")
  public void deleteStudent(String name) {
    studentRepositry.deleteStudent(name);
  }

}
