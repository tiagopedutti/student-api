package com.example.studentapi.student;

import javax.validation.constraints.NotNull;

public class StudentDTO {
  @NotNull
  private String name;

  @NotNull
  private String email;

  @NotNull
  private Integer semester;

  @NotNull
  private String zipcode;

  public StudentDTO() {
  }

  public StudentDTO(@NotNull String name, @NotNull String email, @NotNull Integer semester,
      @NotNull String zipcode) {
    this.name = name;
    this.email = email;
    this.semester = semester;
    this.zipcode = zipcode;
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

  public String getZipcode() {
    return zipcode.replace("-", "");
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
}
