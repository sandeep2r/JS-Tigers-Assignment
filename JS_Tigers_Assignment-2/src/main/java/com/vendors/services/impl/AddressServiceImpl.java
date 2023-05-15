package com.vendors.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendors.entities.Address;
import com.vendors.exception.ResourceNotFoundException;
import com.vendors.repositories.AddressRepository;
import com.vendors.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	@Transactional
	public Address createAddress(Address address) {
		try {
			return addressRepository.save(address);
		} catch (Exception e) {
			throw new ServiceException("Failed to create address: " + address, e);
		}
	}

	@Override
	public Address getAddressById(Long id) {
		try {
			return addressRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Failed to get address by ID: " + id, e);
		}
	}

	@Override
	public List<Address> getAllAddresses() {
		try {
			return addressRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException("Failed to get all addresses", e);
		}
	}

	@Override
	@Transactional
	public Address updateAddress(Long id, Address updatedAddress) {
		try {
			Address address = addressRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
			address.setLine1(updatedAddress.getLine1());
			address.setLine2(updatedAddress.getLine2());
			address.setCity(updatedAddress.getCity());
			address.setCountry(updatedAddress.getCountry());
			address.setZipCode(updatedAddress.getZipCode());
			return addressRepository.save(address);
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Failed to update address with ID: " + id, e);
		}
	}

	@Override
	@Transactional
	public void deleteAddress(Long id) {
		try {
			addressRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("Failed to delete address by ID: " + id, e);
		}
	}
}
