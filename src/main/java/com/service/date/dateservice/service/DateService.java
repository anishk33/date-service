package com.service.date.dateservice.service;

import com.service.date.dateservice.commons.DateTimeStrings;
import com.service.date.dateservice.models.DateTime;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Set;
import java.util.stream.Collectors;

import static com.service.date.dateservice.commons.DateTimeUtils.getZonedDateTime;
import static com.service.date.dateservice.commons.DateTimeUtils.toDate;

@Service
public class DateService {

    public Set<DateTime> getDatesNow() {
        return ZoneId.getAvailableZoneIds().stream().map(tz -> getDateNow(tz)).collect(Collectors.toSet());
    }

    public DateTime getDateNow(final String timezone) {
        return toDate(getZonedDateTime(timezone));
    }

    public String getDateStringNow(final String timezone) {
        return DateTimeStrings.date(getZonedDateTime(timezone));
    }
}
