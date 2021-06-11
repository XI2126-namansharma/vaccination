package com.cowin.vaccination.resource;

import com.cowin.vaccination.service.AvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/vaccination")
public class HomeController {

    @Autowired
    AvailabilityService availabilityService;

    @GetMapping("/pin-code/find")
    public String showAPIForCurrentDay(@RequestParam String pinCode, @RequestParam String date) {
        JSONObject jsonObject = availabilityService.availabilityForCurrentDay(pinCode, date);
        log.info("JSON - {}", jsonObject);
        return String.valueOf(jsonObject);
    }

    @GetMapping("/pin-code/calender")
    public String showAPIFor7Days(@RequestParam String pinCode, @RequestParam String date) {
        JSONObject jsonObject = availabilityService.availabilityFor7Days(pinCode, date);
        log.info("JSON - {}", jsonObject);
        return String.valueOf(jsonObject);
    }
}
