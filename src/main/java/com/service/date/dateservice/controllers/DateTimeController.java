package com.service.date.dateservice.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import com.service.date.dateservice.models.DateTime;
import com.service.date.dateservice.service.DateTimeService;
import com.service.date.dateservice.service.RandomDateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeController {

    @Autowired private DateTimeService dateTimeService;
    @Autowired private RandomDateTimeService randomDateTimeService;

    @RequestMapping(value = "/datetime", produces = APPLICATION_JSON_VALUE)
    public DateTime getDateTimeDefault(@RequestParam(value = "tz", required = false) String timezone) {
        return dateTimeService.getDateTimeNow(timezone);
    }

    @RequestMapping(value = "/datetime.text", produces = TEXT_PLAIN_VALUE)
    public String getDateTimeStringDefault(@RequestParam(value = "tz", required = false) String timezone) {
        return dateTimeService.getDateTimeStringNow(timezone);
    }

    @RequestMapping(value = "/datetime/random", produces = APPLICATION_JSON_VALUE)
    public DateTime getRandomDateTime(@RequestParam(value = "tz", required = false) String timezone) {
        return randomDateTimeService.getRandomDateTime(timezone);
    }

    @RequestMapping(value = "/datetime/random.text", produces = TEXT_PLAIN_VALUE)
    public String getRandomDateTimeString(@RequestParam(value = "tz", required = false) String timezone) {
        return randomDateTimeService.getRandomDateTimeString(timezone);
    }
}
