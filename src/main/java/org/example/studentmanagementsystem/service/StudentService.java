package org.example.studentmanagementsystem.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.studentmanagementsystem.data.Student;
import org.example.studentmanagementsystem.data.StudentCourse;
import org.example.studentmanagementsystem.repository.StudentRepositry;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepositry studentRepositry;

  public List<Student> searchStudents() {
    return studentRepositry.searchStudents();
  }

  public List<StudentCourse> searchStudentCourses() {
    return studentRepositry.searchStudentCourses();
  }

}
