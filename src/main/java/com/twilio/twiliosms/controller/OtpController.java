package com.twilio.twiliosms.controller;

import com.twilio.twiliosms.payload.OtpRequest;
import com.twilio.twiliosms.service.TwilioOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtpController {

    private TwilioOtpService twilioOtpService;

    @Autowired
    public OtpController(TwilioOtpService twilioOtpService) {
        this.twilioOtpService = twilioOtpService;
    }




    @PostMapping("/otp/send")
    public void sendOtp(@RequestBody OtpRequest otpRequest) {
        String to = otpRequest.getTo();
        String otp = generateOtp(); // Implement your logic to generate the OTP

        // Store the generated OTP in the database or cache for verification

        twilioOtpService.sendOtp(to, otp);
    }

    private String generateOtp() {
        // Implement your logic to generate the OTP
        // This can be a random number, alphanumeric code, or any other logic you prefer
        return "18967"; // Example OTP value
    }
}

