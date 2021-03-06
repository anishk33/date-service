package com.service.date.dateservice.service;

import static com.service.date.dateservice.commons.DateTimeUtils.getZonedDateTime;
import static com.service.date.dateservice.commons.DateTimeUtils.toDateTime;
import static com.service.date.dateservice.commons.DateTimeUtils.toDate;
import static com.service.date.dateservice.commons.DateTimeUtils.toTime;
import static com.service.date.dateservice.commons.RandomOperation.getRandomOperation;

import com.service.date.dateservice.commons.DateTimeStrings;
import com.service.date.dateservice.commons.RandomOperation;
import com.service.date.dateservice.models.DateTime;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class RandomDateTimeService {

    public DateTime getRandomDateTime(final String timezone) {
        return toDateTime(operate(getZonedDateTime(timezone)));
    }

    public String getRandomDateTimeString(final String timezone) {
        return DateTimeStrings.zonedDateTime(operate(getZonedDateTime(timezone)));
    }

    public DateTime getRandomDate(final String timezone) {
        return toDate(operateDate(getZonedDateTime(timezone)));
    }

    public String getRandomDateString(final String timezone) {
        return DateTimeStrings.date(operateDate(getZonedDateTime(timezone)));
    }

    public DateTime getRandomTime(final String timezone) {
        return toTime(operateTime(getZonedDateTime(timezone)));
    }

    public String getRandomTimeString(final String timezone) {
        return DateTimeStrings.time(operateTime(getZonedDateTime(timezone)));
    }

    private ZonedDateTime operate(ZonedDateTime zonedDateTime) {
        zonedDateTime = operateDate(zonedDateTime);
        return operateTime(zonedDateTime);
    }

    private ZonedDateTime operateDate(ZonedDateTime zonedDateTime) {
        zonedDateTime = operateDays(zonedDateTime);
        zonedDateTime = operateMonths(zonedDateTime);
        return operateYears(zonedDateTime);
    }

    private ZonedDateTime operateTime(ZonedDateTime zonedDateTime) {
        zonedDateTime = operateHours(zonedDateTime);
        zonedDateTime = operateMinutes(zonedDateTime);
        return operateSeconds(zonedDateTime);
    }

    private ZonedDateTime operateDays(final ZonedDateTime zonedDateTime) {
        if (RandomOperation.ADD == getRandomOperation()) {
            return zonedDateTime.plusDays(random(3, 366));
        }
        return zonedDateTime.minusDays(random(3, 366));
    }

    private ZonedDateTime operateMonths(final ZonedDateTime zonedDateTime) {
        if (RandomOperation.ADD == getRandomOperation()) {
            return zonedDateTime.plusMonths(random(2, 13));
        }
        return zonedDateTime.minusMonths(random(2, 13));
    }

    private ZonedDateTime operateYears(final ZonedDateTime zonedDateTime) {
        if (RandomOperation.ADD == getRandomOperation()) {
            return zonedDateTime.plusYears(random(3, 1000));
        }
        return zonedDateTime.minusYears(random(3, 1000));
    }

    private ZonedDateTime operateHours(final ZonedDateTime zonedDateTime) {
        if (RandomOperation.ADD == getRandomOperation()) {
            return zonedDateTime.plusHours(random(2, 13));
        }
        return zonedDateTime.minusHours(random(2, 13));
    }

    private ZonedDateTime operateMinutes(final ZonedDateTime zonedDateTime) {
        if (RandomOperation.ADD == getRandomOperation()) {
            return zonedDateTime.plusMinutes(random(2, 61));
        }
        return zonedDateTime.minusMinutes(random(2, 61));
    }

    private ZonedDateTime operateSeconds(final ZonedDateTime zonedDateTime) {
        if (RandomOperation.ADD == getRandomOperation()) {
            return zonedDateTime.plusSeconds(random(2, 61));
        }
        return zonedDateTime.minusSeconds(random(2, 61));
    }

    private int random(int digits, int mod) {
        return (int) (Math.random() * Math.pow(10, digits)) % mod;
    }
}
