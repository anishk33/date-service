package com.service.date.dateservice.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import com.service.date.dateservice.models.DateTime;
import com.service.date.dateservice.service.RandomDateTimeService;
import com.service.date.dateservice.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TimeController {

    @Autowired private TimeService timeService;
    @Autowired private RandomDateTimeService randomDateTimeService;

    @RequestMapping(value = "/times", produces = APPLICATION_JSON_VALUE)
    public Set<DateTime> getTimesDefault() {
        return timeService.getTimesNow();
    }

    @RequestMapping(value = "/time", produces = APPLICATION_JSON_VALUE)
    public DateTime getTimeDefault(@RequestParam(value = "tz", required = false) String timezone) {
        return timeService.getTimeNow(timezone);
    }

    @RequestMapping(value = "/time.text", produces = TEXT_PLAIN_VALUE)
    public String getTimeStringDefault(@RequestParam(value = "tz", required = false) String timezone) {
        return timeService.getTimeStringNow(timezone);
    }

    @RequestMapping(value = "/time/random", produces = APPLICATION_JSON_VALUE)
    public DateTime getTimeRandom(@RequestParam(value = "tz", required = false) String timezone) {
        return randomDateTimeService.getRandomTime(timezone);
    }

    @RequestMapping(value = "/time/random.text", produces = TEXT_PLAIN_VALUE)
    public String getTimeStringRandom(@RequestParam(value = "tz", required = false) String timezone) {
        return randomDateTimeService.getRandomTimeString(timezone);
    }
}
