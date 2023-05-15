package com.vendors.services;

import java.util.List;

import com.vendors.entities.Address;

public interface AddressService {
    
    Address createAddress(Address address);
    Address getAddressById(Long id);
    List<Address> getAllAddresses();
    Address updateAddress(Long id, Address updatedAddress);
    void deleteAddress(Long id);
}