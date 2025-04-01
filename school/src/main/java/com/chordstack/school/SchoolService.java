package com.chordstack.school;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chordstack.school.client.StudentClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
  private final SchoolRepository repository;
  private final StudentClient studentClient;

  public void saveSchool(School school) {
    this.repository.save(school);
  }

  public List<School> findAllSchools() {
    return this.repository.findAll();
  }

  public FullSchoolResponse findSchoolsWithSudents(Integer schoolId) {
    var school = repository.findById(schoolId)
        .orElse(
            School.builder()
                .name("NOT_FOUND")
                .email("NOT_FOUND")
                .build());

    var students = studentClient.findAllStudentsBySchool(schoolId);

    return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
  }
}
