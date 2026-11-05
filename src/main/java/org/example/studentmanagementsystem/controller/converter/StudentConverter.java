package org.example.studentmanagementsystem.controller.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.example.studentmanagementsystem.data.Student;
import org.example.studentmanagementsystem.data.StudentCourse;
import org.example.studentmanagementsystem.domain.StudentDetail;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourse> studentCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<StudentCourse> targetStudentCourses = studentCourses.stream()
          .filter(studentCourse -> student.getId().equals(studentCourse.getStudentId()))
          .collect(Collectors.toList());

      studentDetail.setStudentCourses(targetStudentCourses);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }

}
