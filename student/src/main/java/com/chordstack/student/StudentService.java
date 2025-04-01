package com.chordstack.student;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
  private final StudentRepository repository;

  public void saveStudent(Student student) {
    this.repository.save(student);
  }

  public List<Student> findAllStudents() {
    return this.repository.findAll();
  }

  public List<Student> findStudentsBySchool(Integer schoolId) {
    return this.repository.findAllBySchoolId(schoolId);
  }
}
