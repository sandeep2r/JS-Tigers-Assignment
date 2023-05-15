package com.vendors.services;

import java.util.List;

import com.vendors.entities.Vendor;

public interface VendorService {
    
    Vendor createVendor(Vendor vendor);
    Vendor getVendorById(Long id);
    List<Vendor> getAllVendors();
    Vendor updateVendor(Long id, Vendor updatedVendor);
    void deleteVendor(Long id);
}