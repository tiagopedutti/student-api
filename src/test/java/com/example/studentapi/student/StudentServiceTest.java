package com.example.studentapi.student;

import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import com.example.studentapi.external.address.Address;
import com.example.studentapi.external.address.AddressLookup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentServiceTest {

  @Autowired
  private StudentService service;

  @Mock
  private StudentRepository repository;

  @MockBean
  private AddressLookup addressLookup;

  @Test
  public void createStudent_verifyIfStudentWillBeCreate() {
    StudentDTO student = new StudentDTO("Tiago", "tiagopedutti2@gmail.com", 4, "11700-100");
    Address address = new Address("11700100", "Praça Dezenove de Janeiro", "", "Boqueirão", "Praia Grande", "SP");
    Student newStudent = new Student(student.getName(), student.getEmail(), student.getSemester(), address);
    given(addressLookup.findAddressByZipCode("11700100")).willReturn(address);
    given(repository.save(newStudent)).willReturn(newStudent);

    Student studentCreated = service.createStudent(student);

    assertThat(studentCreated, instanceOf(Student.class));
  }

  @Test
  public void createStudent_verifyCreatedStudentAddress() {
    StudentDTO student = new StudentDTO("Tiago", "tiagopedutti2@gmail.com", 4, "11700-100");
    Address address = new Address("11700100", "Praça Dezenove de Janeiro", "", "Boqueirão", "Praia Grande", "SP");
    Student newStudent = new Student(student.getName(), student.getEmail(), student.getSemester(), address);
    given(addressLookup.findAddressByZipCode("11700100")).willReturn(address);
    given(repository.save(newStudent)).willReturn(newStudent);

    Student studentCreated = service.createStudent(student);

    assertThat(studentCreated.getAddress(), instanceOf(Address.class));
  }
}
