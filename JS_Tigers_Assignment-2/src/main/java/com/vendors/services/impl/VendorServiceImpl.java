package com.vendors.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendors.entities.Vendor;
import com.vendors.exception.ResourceNotFoundException;
import com.vendors.repositories.VendorRepository;
import com.vendors.services.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    @Transactional
    public Vendor createVendor(Vendor vendor) {
        try {
            return vendorRepository.save(vendor);
        } catch (Exception e) {
            throw new ServiceException("Failed to create vendor: " + vendor, e);
        }
    }

    @Override
    public Vendor getVendorById(Long id) {
        try {
            return vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found with id: " + id));
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Failed to get vendor by ID: " + id, e);
        }
    }

    @Override
    public List<Vendor> getAllVendors() {
        try {
            return vendorRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Failed to get all vendors", e);
        }
    }

    @Override
    @Transactional
    public Vendor updateVendor(Long id, Vendor updatedVendor) {
        try {

            
            
            return vendorRepository.save(updatedVendor);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("Failed to update vendor with ID: " + id, e);
        }
    }

    @Override
    @Transactional
    public void deleteVendor(Long id) {
        try {
            vendorRepository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Failed to delete vendor by ID: " + id, e);
        }
    }
}