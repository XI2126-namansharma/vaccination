package com.cowin.vaccination.service.impl;

import com.cowin.vaccination.service.AvailabilityService;
import lombok.SneakyThrows;
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

    @SneakyThrows
    @Override
    public JSONObject availabilityForCurrentDay(String pinCode, String date) {
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+pinCode+"&date="+date;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        log.info("response received from rest client - {}", response);
        String body = response.getBody();
        return new JSONObject(body);
    }

    @SneakyThrows
    @Override
    public JSONObject availabilityFor7Days(String pinCode, String date) {
        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="+pinCode+"&date="+date;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        log.info("response received from rest client - {}", response);
        String body = response.getBody();
        return new JSONObject(body);
    }
}
