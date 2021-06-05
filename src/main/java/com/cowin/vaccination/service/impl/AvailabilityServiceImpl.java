package com.cowin.vaccination.service.impl;

import com.cowin.vaccination.service.AvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    RestTemplate restTemplate;

    public AvailabilityServiceImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public String availability(String pinCode, String date) {
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+pinCode+"&date="+date;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        log.info("Http status - {} with response - {}",response.getStatusCode(),response.getBody());
        return String.valueOf(response.getBody());
    }
}
