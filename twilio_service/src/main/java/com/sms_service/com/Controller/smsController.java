package com.sms_service.com.Controller;

import com.sms_service.com.Service.smsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/twilio")
public class smsController {
    @Autowired
    private smsService smsService;

    public smsController(smsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/getStatus")
    public ResponseEntity getStatus() {
        String SID = smsService.sendSMS("+916291447461", "FUCK");
        return new ResponseEntity(SID, HttpStatus.OK);
    }

    @PostMapping("/sendSMS")
    public ResponseEntity sendSMS(@RequestBody String phoneNumber, @RequestBody String message) {
        String response = smsService.sendSMS(phoneNumber, message);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
