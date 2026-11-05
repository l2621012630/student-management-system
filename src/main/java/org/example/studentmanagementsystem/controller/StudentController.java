package org.example.studentmanagementsystem.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.controller.converter.StudentConverter;
import org.example.studentmanagementsystem.data.Student;
import org.example.studentmanagementsystem.data.StudentCourse;
import org.example.studentmanagementsystem.domain.StudentDetail;
import org.example.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;
  private final StudentConverter studentConverter;

  @GetMapping("/students")
  public String getStudents(Model model) {
    List<Student> students = studentService.searchStudents();
    List<StudentCourse> studentCourses = studentService.searchStudentCourses();
    List<StudentDetail> studentDetails = studentConverter.convertStudentDetails(students, studentCourses);
    model.addAttribute("studentDetails", studentDetails);
    return "studentList";
  }

  @GetMapping("/studentCourses")
  public List<StudentCourse> getStudentCourses() {
    return studentService.searchStudentCourses();
  }

}
