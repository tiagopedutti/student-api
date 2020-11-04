package com.example.studentapi.student;

import com.example.studentapi.external.address.Address;
import com.example.studentapi.external.address.AddressLookup;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private final StudentRepository repository;
  private final AddressLookup addressLookup;

  @Autowired
  public StudentService(StudentRepository repository, AddressLookup addressLookup) {
    this.repository = repository;
    this.addressLookup = addressLookup;
  }

  public Student createStudent(StudentDTO newStudent) {
    Address address = addressLookup.findAddressByZipCode(newStudent.getZipcode());
    Student student = new Student(newStudent.getName(), newStudent.getEmail(), newStudent.getSemester(), address);
    return repository.save(student);
  }

  public Student editStudent(Long id, StudentDTO newStudent) {
    return repository.findById(id)
        .map(student -> {
          Address address = addressLookup.findAddressByZipCode(newStudent.getZipcode());
          student.setName(newStudent.getName());
          student.setEmail(newStudent.getEmail());
          student.setSemester(newStudent.getSemester());
          student.setAddress(address);
          return repository.save(student);
        }).orElseThrow(NoSuchElementException::new);
  }
}
