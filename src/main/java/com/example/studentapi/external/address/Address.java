package com.example.studentapi.external.address;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {
  @NotNull
  private String zipcode;

  @NotNull
  private String street;

  private String complement;

  @NotNull
  private String district;

  @NotNull
  private String city;

  @NotNull
  private String state;

  public Address() {
  }

  public Address(@NotNull String zipcode, @NotNull String street, String complement,
      @NotNull String district, @NotNull String city, @NotNull String state) {
    this.zipcode = zipcode;
    this.street = street;
    this.complement = complement;
    this.district = district;
    this.city = city;
    this.state = state;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
