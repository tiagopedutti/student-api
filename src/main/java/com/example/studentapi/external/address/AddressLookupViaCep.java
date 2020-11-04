package com.example.studentapi.external.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class AddressLookupViaCep implements AddressLookup {

  private static final String URI = "https://viacep.com.br/ws/%ZIP%/json/";
  private final RestTemplate restTemplate;

  @Autowired
  public AddressLookupViaCep(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Address findAddressByZipCode(String zipcode) {
    AddressLookupViaCepDTO addressLookupViaCepDTO = restTemplate.getForObject(URI.replace("%ZIP%", zipcode), AddressLookupViaCepDTO.class);
    if (addressLookupViaCepDTO == null) {
      throw new IllegalArgumentException();
    }
    return createAddressFromDTO(addressLookupViaCepDTO);
  }

  private static Address createAddressFromDTO(AddressLookupViaCepDTO addressLookupViaCepDTO) {
    Address address = new Address();
    address.setZipcode(addressLookupViaCepDTO.getZipcode());
    address.setStreet(addressLookupViaCepDTO.getStreet());
    address.setComplement(addressLookupViaCepDTO.getComplement());
    address.setDistrict(addressLookupViaCepDTO.getDistrict());
    address.setCity(addressLookupViaCepDTO.getCity());
    address.setState(addressLookupViaCepDTO.getState());
    return address;
  }
}
