package com.cowin.vaccination.resource;

import com.cowin.vaccination.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vaccination")
public class HomeController {

    @Autowired
    AvailabilityService availabilityService;

    @GetMapping("/pin-code")
    public String showAPI(@RequestParam String pinCode, @RequestParam String date) {
        return availabilityService.availability(pinCode,date);
    }
}
