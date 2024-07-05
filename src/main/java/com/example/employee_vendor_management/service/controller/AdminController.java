package com.example.employee_vendor_management.service.controller;

import com.example.employee_vendor_management.model.Employee;
import com.example.employee_vendor_management.model.Vendor;
import com.example.employee_vendor_management.service.EmailService;
import com.example.employee_vendor_management.service.EmployeeService;
import com.example.employee_vendor_management.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private EmailService emailService;

    // Employee Endpoints
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    // Vendor Endpoints
    @PostMapping("/vendors")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.saveVendor(vendor);
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // Email Endpoints
    @PostMapping("/sendEmail")
    public String sendEmailToVendors(@RequestBody List<Vendor> vendors) {
        for (Vendor vendor : vendors) {
            String message = "Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi();
            emailService.sendEmail(vendor.getEmail(), "Payment Notification", message);
        }
        return "Emails sent successfully";
    }

    @GetMapping("/sentEmails")
    public List<String> getAllSentEmails() {
        return emailService.getSentEmails();
    }
}
