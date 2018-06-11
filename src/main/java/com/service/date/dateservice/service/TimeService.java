package com.service.date.dateservice.service;

import com.service.date.dateservice.commons.DateTimeStrings;
import com.service.date.dateservice.models.DateTime;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Set;
import java.util.stream.Collectors;

import static com.service.date.dateservice.commons.DateTimeUtils.getZonedDateTime;
import static com.service.date.dateservice.commons.DateTimeUtils.toTime;

@Service
public class TimeService {

    public Set<DateTime> getTimesNow() {
        return ZoneId.getAvailableZoneIds().stream().map(tz -> getTimeNow(tz)).collect(Collectors.toSet());
    }

    public DateTime getTimeNow(final String timezone) {
        return toTime(getZonedDateTime(timezone));
    }

    public String getTimeStringNow(final String timezone) {
        return DateTimeStrings.time(getZonedDateTime(timezone));
    }
}
