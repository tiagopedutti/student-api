package com.example.studentapi.external.address;

public interface AddressLookup {
  public Address findAddressByZipCode(String zipcode);
}
