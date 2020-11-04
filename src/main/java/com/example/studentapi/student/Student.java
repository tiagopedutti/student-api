package com.example.studentapi.student;

import com.example.studentapi.external.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private String email;

  @NotNull
  private Integer semester;

  @Embedded
  @NotNull
  private Address address;

  public Student(@NotNull String name, @NotNull String email, @NotNull Integer semester,
      @NotNull Address address) {
    this.name = name;
    this.email = email;
    this.semester = semester;
    this.address = address;
  }

  public Student() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
