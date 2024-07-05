
package com.example.employee_vendor_management.service;

import com.example.employee_vendor_management.model.Vendor;
import com.example.employee_vendor_management.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    
    @Autowired
    private VendorRepository vendorRepository;

    // Create or save a new vendor
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Retrieve a list of all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Retrieve a vendor by ID
    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    // Update a vendor
    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Delete a vendor by ID
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
