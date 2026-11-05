package org.example.studentmanagementsystem.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.studentmanagementsystem.data.Student;
import org.example.studentmanagementsystem.data.StudentCourse;

@Mapper
public interface StudentRepositry {

  @Select("SELECT * FROM students")
  List<Student> searchStudents();

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentCourses();

}
