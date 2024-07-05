package com.example.employee_vendor_management.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {
    
    private List<String> sentEmails = new ArrayList<>();

    public void sendEmail(String to, String subject, String body) {
        // Mock sending email by printing the email content
        String emailContent = String.format("To: %s\nSubject: %s\nBody: %s", to, subject, body);
        System.out.println(emailContent);

        // Save the email content to the sent emails list
        sentEmails.add(emailContent);
    }

    public List<String> getSentEmails() {
        return sentEmails;
    }
}
