package com.example.studentapi.student;

import com.example.studentapi.external.address.Address;
import com.example.studentapi.external.address.AddressLookup;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  private final StudentService service;
  private final StudentRepository repository;

  @Autowired
  public StudentController(StudentService service, StudentRepository repository) {
    this.service = service;
    this.repository = repository;
  }

  @GetMapping("/students")
  public List<Student> all() {
    return repository.findAll();
  }

  @PostMapping("/students")
  public Student create(@RequestBody StudentDTO newStudent) {
    return service.createStudent(newStudent);
  }

  @GetMapping("/student/{id}")
  public Student find(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @PutMapping("/student/{id}")
  public Student edit(@PathVariable Long id, @RequestBody StudentDTO newStudent) {
    return service.editStudent(id, newStudent);
  }

  @DeleteMapping("/student/{id}")
  public void remove(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
