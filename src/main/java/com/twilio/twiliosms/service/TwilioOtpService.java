package com.twilio.twiliosms.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioOtpService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    public void sendOtp(String to, String otp) {
        Twilio.init(accountSid, authToken);

        String messageBody = "Your OTP is: " + otp;

        Message.creator(new PhoneNumber(to), new PhoneNumber(phoneNumber), messageBody).create();
    }
}

