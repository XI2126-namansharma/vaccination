package com.cowin.vaccination.service;

import org.json.JSONObject;

public interface AvailabilityService {
    JSONObject availabilityForCurrentDay(String pinCode, String date);

    JSONObject availabilityFor7Days(String pinCode, String date);
}
