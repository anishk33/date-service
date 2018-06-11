package com.service.date.dateservice.service;

import static com.service.date.dateservice.commons.DateTimeUtils.getZonedDateTime;

import java.time.ZoneId;
import java.util.Set;
import java.util.stream.Collectors;
import com.service.date.dateservice.commons.DateTimeStrings;
import com.service.date.dateservice.models.DateTime;
import org.springframework.stereotype.Service;

@Service
public class DateTimeService {

    public Set<DateTime> getDateTimesNow() {
        return ZoneId.getAvailableZoneIds().stream().map(tz -> getDateTimeNow(tz)).collect(Collectors.toSet());
    }

    public DateTime getDateTimeNow(final String timezone) {
        return new DateTime(getZonedDateTime(timezone));
    }

    public String getDateTimeStringNow(final String timezone) {
        return DateTimeStrings.zonedDateTime(getZonedDateTime(timezone));
    }
}
