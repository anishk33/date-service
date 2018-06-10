package com.service.date.dateservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Set;

@RequestMapping("/timezones")
@RestController
public class TimezoneController {

    @RequestMapping
    public Set<String> getTimezones() {
        return ZoneId.getAvailableZoneIds();
    }
}
