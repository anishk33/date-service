package com.service.date.dateservice.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import com.service.date.dateservice.models.DateTime;
import com.service.date.dateservice.service.DateService;
import com.service.date.dateservice.service.RandomDateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class DateController {

    @Autowired private DateService dateService;
    @Autowired private RandomDateTimeService randomDateTimeService;

    @RequestMapping(value = "/dates", produces = APPLICATION_JSON_VALUE)
    public Set<DateTime> getDatesDefault() {
        return dateService.getDatesNow();
    }

    @RequestMapping(value = "/date", produces = APPLICATION_JSON_VALUE)
    public DateTime getDateDefault(@RequestParam(value = "tz", required = false) String timezone) {
        return dateService.getDateNow(timezone);
    }

    @RequestMapping(value = "/date.text", produces = TEXT_PLAIN_VALUE)
    public String getDateStringDefault(@RequestParam(value = "tz", required = false) String timezone) {
        return dateService.getDateStringNow(timezone);
    }

    @RequestMapping(value = "/date/random", produces = APPLICATION_JSON_VALUE)
    public DateTime getDateRandom(@RequestParam(value = "tz", required = false) String timezone) {
        return randomDateTimeService.getRandomDate(timezone);
    }

    @RequestMapping(value = "/date/random.text", produces = TEXT_PLAIN_VALUE)
    public String getDateStringRandom(@RequestParam(value = "tz", required = false) String timezone) {
        return randomDateTimeService.getRandomDateString(timezone);
    }
}
