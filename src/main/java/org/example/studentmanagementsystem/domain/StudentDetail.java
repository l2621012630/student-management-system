package org.example.studentmanagementsystem.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.example.studentmanagementsystem.data.Student;
import org.example.studentmanagementsystem.data.StudentCourse;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentCourse> studentCourses;

}
