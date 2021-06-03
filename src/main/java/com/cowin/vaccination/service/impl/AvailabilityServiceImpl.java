package com.cowin.vaccination.service.impl;

import com.cowin.vaccination.service.AvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
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
    public JSONObject availability(String pinCode, String date) {
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+pinCode+"&date="+date;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.GET, request, JSONObject.class);
        log.info("Http status - {} with response - {}",response.getStatusCode(),response.getBody());
        return response.getBody();
    }
}
