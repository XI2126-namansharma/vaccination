package com.cowin.vaccination.service;

public interface AvailabilityService {
    String availabilityForCurrentDay(String pinCode, String date);

    String availabilityFor7Days(String pinCode, String date);
}
