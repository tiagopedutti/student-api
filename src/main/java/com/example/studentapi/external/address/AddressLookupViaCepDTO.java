package com.example.studentapi.external.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class AddressLookupViaCepDTO {
  @JsonProperty("cep")
  @NotNull
  private String zipcode;

  @JsonProperty("logradouro")
  @NotNull
  private String street;

  @JsonProperty("complemento")
  private String complement;

  @JsonProperty("bairro")
  @NotNull
  private String district;

  @JsonProperty("localidade")
  @NotNull
  private String city;

  @JsonProperty("uf")
  @NotNull
  private String state;

  public String getZipcode() {
    return zipcode;
  }

  public String getStreet() {
    return street;
  }

  public String getComplement() {
    return complement;
  }

  public String getDistrict() {
    return district;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }
}
