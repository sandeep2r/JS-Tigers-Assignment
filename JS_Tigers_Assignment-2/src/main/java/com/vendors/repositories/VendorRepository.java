package com.vendors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vendors.entities.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
