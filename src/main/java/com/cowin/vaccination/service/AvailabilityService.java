package com.cowin.vaccination.service;

import org.json.JSONObject;

public interface AvailabilityService {
    JSONObject availability(String pinCode, String date);
}
